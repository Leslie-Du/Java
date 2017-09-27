package indi.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiveDemo2 {

	public static void main(String[] args) throws IOException {

		System.out.println("���ն�����������������");
		
		/*
		 * ����UDP����Ľ��ն˵�˼·��
		 * 
		 * 1.����udp��socket������Ϊ��Ҫ�������ݣ�����Ҫ��ȷһ���˿ںš�
		 * 2.�������ݰ������ڴ洢���յ������ݣ����������ݰ�����ķ���������Щ���ݡ�
		 * 3.ʹ��socket�����receive���������յ������ݴ洢�����ݰ��С�
		 * 4.ͨ�����ݰ�����ķ����������ݰ��е����ݡ�
		 * 5.�ر�socket����
		 */
		
//		1.����udp��socket����
		DatagramSocket ds = new DatagramSocket(10000);
		
		while(true){
		
//		2.�������ݰ�.
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		
//		3.ʹ��socket�����receive���������յ������ݴ洢�����ݰ��С�
		ds.receive(dp);//�����Ͷ�δ����ʱ���˷�����������״̬��
		
//		4.ͨ�����ݰ�����ķ����������ݰ��е����ݡ����磬��ַ���˿ڡ��������ݡ�
		String ip = dp.getAddress().getHostAddress();
		int port = dp.getPort();
		String text = new String(dp.getData(),0,dp.getLength());
		
		System.out.println(ip+"::"+port+"::"+text);
		
		}
		
		
//		5.�ر�socket����
//		ds.close();
		
	}

}
