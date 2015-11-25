/**
 * 
 */
package com.bgpublish.socket;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bgpublish.service.ChatOffLineMsgService;
import com.bgpublish.util.ServerConfig;

/**
 * 聊天功能服务端
 * 
 * @author ps
 *
 */
//@Service
public class ChatServer {
	private static final Log LOG = LogFactory.getLog(ChatServer.class);

	//离线信息service
	private @Autowired @Getter @Setter ChatOffLineMsgService chatOffLineMsgService;
	//服务器socket
	protected ServerSocket serverSocket = null;
	boolean started = false;
	//保存客户端线程
	public static List<ServerThread> clients = new ArrayList<ServerThread>();
	protected static Map<String, Socket> socketMap = new HashMap<String, Socket>();
	protected static Map<String, Socket> onlineMap = new HashMap<String, Socket>();

	/*
	 * public static void main(String[] args) { new
	 * ChatServer().start(ServerConfig.PORT); }
	 */

	public ChatServer() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				start(ServerConfig.PORT);
			}
		}).start();
	}

	public void start(int port) {
		try {
			serverSocket = new ServerSocket(port);
			LOG.info(">> 服务器启动成功,端口:[" + port + "]");
			started = true;
		} catch (BindException e) {
			LOG.error(">> 端口:[" + port + "]被其他程序占用");
			System.exit(0);
		} catch (IOException e) {
			LOG.error(">> IO 异常", e);
			System.exit(0);
		}

		try {
			while (started) {
				LOG.info(">> 等待客户端线程接入...");
				Socket socket = serverSocket.accept();
				LOG.info(">> 客户端线程[" + socket.getInetAddress().getHostAddress()
						+ "]接入成功");

				ServerThread serverThread = new ServerThread(socket,this.chatOffLineMsgService);
				new Thread(serverThread).start();
				clients.add(serverThread);
			}
		} catch (IOException e) {
			LOG.error(">> 线程接入IO异常", e);
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				LOG.error(">> 线程Socket 关闭IO异常", e);
			}
		}
	}
}
