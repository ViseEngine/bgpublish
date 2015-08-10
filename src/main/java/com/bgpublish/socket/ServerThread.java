/**
 * 
 */
package com.bgpublish.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bgpublish.domain.ChatOffLineMsg;
import com.bgpublish.service.ChatOffLineMsgService;

/**
 * 服务线程
 * 
 * @author ps
 *
 */
public class ServerThread implements Runnable {
	private static final Log LOG = LogFactory.getLog(ServerThread.class);
	/** 出错！返回String，描述出错原因 */
	public static final int EVENT_ERROR = 0;
	/** 线程结束, 停止运行 */
	public static final int EVENT_STOPPED = 1;
	/** 收到来自客户端的tcp连接, 报告一个socketchannel */
	public static final int EVENT_ACCEPTED = 2;
	/** 收到来自客户端的tcp消息, 报告一个TcpArgs, content为FileSerial对象 */
	public static final int EVENT_RECEIVED = 3;
	/** SocketChannel,ServerSocketChannel关闭 */
	public static final int EVENT_CLOSED = 4;

	private Socket socket = null;
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	private boolean bConnected = false;
	public List<Map<Object, Object>> getList;
	
	private ChatOffLineMsgService chatOffLineMsgService;

	public ServerThread(Socket socket) {
		this.socket = socket;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			bConnected = true;
		} catch (IOException e) {
			LOG.error("IO异常", e);
		}
	}
	public ServerThread(Socket socket,ChatOffLineMsgService chatOffLineMsgService) {
		this(socket);
		this.chatOffLineMsgService = chatOffLineMsgService;
	}

	public void run() {
		try {
			while (bConnected) {
				Object obj = ois.readObject();
				FileSerial fileSerial = (FileSerial) obj;
				String fromUserId = fileSerial.getFromUserId();
				String toUserId = fileSerial.getToUserId();

				switch (fileSerial.getType()) {
				case FileSerial.TYPE_OFFLINE_MSG:
					ChatServer.socketMap.put(fromUserId, socket);

					Map<String,String> map = new HashMap<String, String>();
					map.put("from_user_id", toUserId);
					map.put("to_user_id", fromUserId);
					// 查询离线信息
					List<ChatOffLineMsg> offLineList = this.chatOffLineMsgService.queryByUserId(map);
					// 发送离线信息
					//TODO 还有语音和文件的离线信息未作处理
					for (ChatOffLineMsg chatOffLineMsg : offLineList) {
						FileSerial offLineObj = new FileSerial();
						offLineObj.setFileName(chatOffLineMsg.getChat_content());
						int chatType = Integer.parseInt(chatOffLineMsg.getChat_type());
						int type = FileSerial.TYPE_TEXT;
						if(chatType == 1){
							type = FileSerial.TYPE_AUDIO;
						}else if(chatType == 2){
							type = FileSerial.TYPE_PICTURE;
						}
						offLineObj.setType(type);
						offLineObj.setFromUserMobile(chatOffLineMsg.getFrom_mobile());
						offLineObj.setToUserMobile(chatOffLineMsg.getTo_mobile());
						offLineObj.setToUserId(chatOffLineMsg.getTo_user_id()+"");
						offLineObj.setFromUserId(chatOffLineMsg.getFrom_user_id()+"");
						offLineObj.setToUserName(chatOffLineMsg.getTo_user_name());
						offLineObj.setFromUserName(chatOffLineMsg.getFrom_user_name());
						offLineObj.setChatTime(chatOffLineMsg.getChat_date()+chatOffLineMsg.getChat_time());
						oos.writeObject(offLineObj);
					}
					//发送完后，更新状态
					for (ChatOffLineMsg chatOffLineMsg : offLineList) {
						ChatOffLineMsg offLineMsg = new ChatOffLineMsg();
						offLineMsg.setChat_id(chatOffLineMsg.getChat_id());
						offLineMsg.setIs_read("1");
						this.chatOffLineMsgService.updateOffLineMsg(offLineMsg);
					}
					break;
				case FileSerial.TYPE_OFFLINE:
					ChatServer.onlineMap.remove(fromUserId);
					break;
				case FileSerial.TYPE_ONLINE:
					// 用户上线保存用户的手机号码或者QQ号等
					ChatServer.onlineMap.put(fromUserId, socket);

					break;
				case FileSerial.TYPE_NAME:

					break;
				case FileSerial.TYPE_TEXT:

					boolean isSend = false;
					Iterator<Entry<String, Socket>> iterator = ChatServer.socketMap
							.entrySet().iterator();
					while (iterator.hasNext()) {
						Entry<String, Socket> elementEntry = iterator.next();
						String key = elementEntry.getKey();
						if (toUserId.equals(key)) {
							isSend = true;
							break;
						}
					}

					if (isSend) {
						// 实时发送
						oos.writeObject(obj);
						oos.flush();
					} else {
						// 保存离线信息
						this.chatOffLineMsgService.addOffLine2(fromUserId,toUserId,(FileSerial.TYPE_TEXT-1)+"",fileSerial.getFileName());
					}

					break;
				case FileSerial.TYPE_AUDIO:

					break;
				case FileSerial.TYPE_PICTURE:

					break;
				default:
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			LOG.error("找不到类异常", e);
		} catch (IOException e) {
			LOG.error("IO异常", e);
		}
	}
}
