package indi.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpDemo {

public static void main(String[] args) throws UnknownHostException {
		
		//��ȡ����������ip��ַ����
		InetAddress ip = InetAddress.getLocalHost();
		
		//��ȡ����������ip��ַ����
		ip = InetAddress.getByName("127.0.0.1");
//		ip = InetAddress.getByName("dell-MY");
		
		
		System.out.println(ip.getHostAddress());//����IP��ַ�ַ���
		System.out.println(ip.getHostName());//��ȡ��IP��ַ��������

	}

}
