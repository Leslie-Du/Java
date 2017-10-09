package indi.udp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo2 {

	public static void main(String[] args) throws IOException {

		System.out.println("���Ͷ�����������������");
		
		
		/*
		 * ����UDP����ķ��Ͷ�˼·��
		 * 
		 * 1.����udp��socket����
		 * 2.��Ҫ���͵����ݷ�װ�����ݰ��С�
		 * 3.ͨ��udp��socket����(send����)�����ݰ����ͳ�ȥ��
		 * 4.�ر�socket����
		 */
		
		//1.����udp��socket����ʹ��DatagramSocket����
		DatagramSocket ds = new DatagramSocket(8888);
		
//		String str = "udp������ʾ���������ˣ���";
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		while((line=bufr.readLine())!=null){
			byte[] buf = line.getBytes();
			
			DatagramPacket dp = 
					new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 10000);
			ds.send(dp);
			
			if("over".equals(line))
				break;
		}
		
		
		
		
		//4.�ر�socket����
		ds.close();
		
		
		
		
		
		
		
		
	}
}
