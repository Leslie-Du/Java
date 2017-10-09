package indi.tcp.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo2 {

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
		
		
		ServerSocket ss = new ServerSocket(10002);
		
		Socket socket = ss.accept();
		
		String ip = socket.getInetAddress().getHostAddress();
		
		InputStream in = socket.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		String text = new String(buf,0,len);
		System.out.println(ip+":"+text);
		
		
		//ʹ�ÿͻ���socket�������������ͻ��˷������ݡ�
		OutputStream out = socket.getOutputStream();
		
		out.write("�յ�����".getBytes());
		
		
		socket.close();
		ss.close();
		
		
	}

}








