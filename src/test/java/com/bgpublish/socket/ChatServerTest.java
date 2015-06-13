/**
 * 
 */
package com.bgpublish.socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

/**
 * 
 * @author ps
 *
 */
public class ChatServerTest {
	
	private String ip = "192.168.1.102";
	private int port = 10000;

	@Test
	public void testConnect(){
		Socket socket = null;
		try {
			socket = new Socket(ip,port);
			OutputStream outputStream = socket.getOutputStream();
			
			FileSerial fileSerial = new FileSerial();
			fileSerial.setType(FileSerial.TYPE_TEXT);
			fileSerial.setFileName("Test text info");
			
			ObjectOutputStream oos = new ObjectOutputStream(outputStream);
			oos.writeObject(fileSerial);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
