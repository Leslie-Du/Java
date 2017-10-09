package indi.tcp.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo2 {

	public static void main(String[] args) throws IOException {

		//服务端接收从客户端发送的数据，并打印在控制台上。
		/*
		 * 建立tcp服务端的思路：
		 * 1.创建服务端socket服务。通过ServerSocket对象。
		 * 
		 * 2.服务端必须对外提供一个端口，否则客户端无法连接。
		 * 
		 * 3.获取连接过来的客户端对象。
		 * 
		 * 4.通过客户端对象获取socket流读取客户端发来的数据并打印在控制台上。
		 * 
		 * 5.关闭资源。关客户端，关服务端。
		 * 
		 */
		
		
		ServerSocket ss = new ServerSocket(10002);
		
		Socket socket = ss.accept();
		
		String ip = socket.getInetAddress().getHostAddress();
		
		InputStream in = socket.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		String text = new String(buf,0,len);
		System.out.println(ip+":"+text);
		
		
		//使用客户端socket对象的输出流给客户端返回数据。
		OutputStream out = socket.getOutputStream();
		
		out.write("收到！！".getBytes());
		
		
		socket.close();
		ss.close();
		
		
	}

}








