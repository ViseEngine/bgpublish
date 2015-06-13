/**
 * 
 */
package com.bgpublish.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.bgpublish.util.SpringUtil;

/**
 * 服务线程
 * 
 * @author ps
 *
 */
public class ServerThread implements Runnable {
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
	private String sendmsg = null;
	private String getnameString = null;
	public List<Map<Object, Object>> getList;

	public ServerThread(Socket socket) {
		this.socket = socket;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			bConnected = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			while (bConnected) {
				Object obj = ois.readObject();
				FileSerial fileSerial = (FileSerial) obj;
				String fromUser = fileSerial.getFromUser();

				switch (fileSerial.getType()) {
				case FileSerial.TYPE_OFFLINE_MSG:
					ChatServer.socketMap.put(fromUser, socket);

					// 查询离线信息

					// 发送离线信息

					break;
				case FileSerial.TYPE_OFFLINE:
					ChatServer.onlineMap.remove(fromUser);
					break;
				case FileSerial.TYPE_ONLINE:
					// 用户上线保存用户的手机号码或者QQ号等
					ChatServer.onlineMap.put(fromUser, socket);

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
						if (fromUser.equals(key)) {
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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}