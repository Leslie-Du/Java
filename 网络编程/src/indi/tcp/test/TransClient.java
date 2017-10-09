package indi.tcp.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TransClient {

	public static void main(String[] args) throws UnknownHostException, IOException {

		/*
		 * 转换客户端：
		 * 1.创建socket客户端对象。
		 * 2.获取键盘录入。
		 * 3.将录入的信息发送给socket输出流。
		 * 4.socket输入流，读取服务端返回的大写数据
		 */
		
		//1.创建socket客户端对象。
		Socket s = new Socket("127.0.0.1",10002);
		
		//2.获取键盘录入
		BufferedReader bufr = 
				new BufferedReader(new InputStreamReader(System.in));
		
		//3.将录入的信息发送给socket输出流.
//		new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		//4.socket输入流，读取服务端返回的大写数据
		BufferedReader bufIn = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
		
		String line = null;
		
		while((line=bufr.readLine())!=null){
			
			if("over".equals(line))
				break;
			out.println(line);
			
			//读取服务端发回的一行大写数据。
			String upperStr = bufIn.readLine();
			System.out.println(upperStr);
			
		}
		
		s.close();
		
	}

}
