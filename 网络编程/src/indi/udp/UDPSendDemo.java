package indi.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPSendDemo {

	public static void main(String[] args) throws IOException {

		System.out.println("发送端启动。。。。。。");
		
		
		/*
		 * 创建UDP传输的发送端思路：
		 * 
		 * 1.建立udp的socket服务。
		 * 2.将要发送的数据封装到数据包中。
		 * 3.通过udp的socket服务(send方法)将数据包发送出去。
		 * 4.关闭socket服务。
		 */
		
		//1.建立udp的socket服务。使用DatagramSocket对象。
		DatagramSocket ds = new DatagramSocket(8888);
		
		//2.将要发送的数据封装到数据包中。
		String str = "udp传输演示！来了来了！！";
			//使用DatagramPacket将数据封装到该对象包中。
		byte[] buf = str.getBytes();
		DatagramPacket dp = 
				new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 10000);
		
		//3.通过udp的socket服务将数据包发送出去。使用send方法。
		ds.send(dp);
		
		//4.关闭socket服务。
		ds.close();
		
		
		
		
		
		
		
		
	}
}
