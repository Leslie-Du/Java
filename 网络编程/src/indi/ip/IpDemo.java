package indi.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpDemo {

public static void main(String[] args) throws UnknownHostException {
		
		//获取本地主机的ip地址对象。
		InetAddress ip = InetAddress.getLocalHost();
		
		//获取其他主机的ip地址对象。
		ip = InetAddress.getByName("127.0.0.1");
//		ip = InetAddress.getByName("dell-MY");
		
		
		System.out.println(ip.getHostAddress());//返回IP地址字符串
		System.out.println(ip.getHostName());//获取此IP地址的主机名

	}

}
