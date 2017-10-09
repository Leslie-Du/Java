package indi.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	public static void main(String[] args) throws IOException {

		//����˽��մӿͻ��˷��͵����ݣ�����ӡ�ڿ���̨�ϡ�
		/*
		 * ����tcp����˵�˼·��
		 * 1.���������socket����ͨ��ServerSocket����
		 * 
		 * 2.����˱�������ṩһ���˿ڣ�����ͻ����޷����ӡ�
		 * 
		 * 3.��ȡ���ӹ����Ŀͻ��˶���
		 * 
		 * 4.ͨ���ͻ��˶����ȡsocket����ȡ�ͻ��˷��������ݲ���ӡ�ڿ���̨�ϡ�
		 * 
		 * 5.�ر���Դ���ؿͻ��ˣ��ط���ˡ�
		 * 
		 */
		
		
		//1.��������˶���
		ServerSocket ss = new ServerSocket(10002);
		
		//2.��ȡ���ӹ����Ŀͻ��˶���
		Socket socket = ss.accept();//����ʽ
		
		String ip = socket.getInetAddress().getHostAddress();
		
		//3.ͨ��socket�����ȡ��������Ҫ��ȡ�ͻ��˷��������ݡ�
		InputStream in = socket.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		String text = new String(buf,0,len);
		System.out.println(ip+":"+text);
		
		//�ر���Դ��
		socket.close();
		ss.close();
		
		
	}

}








