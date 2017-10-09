package indi.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {

	public static void main(String[] args) throws UnknownHostException, IOException {

		//�ͻ��˷����ݵ������
		/*
		 * TCP���䣺�ͻ��˽����Ĺ��̡�
		 * 1.����tcp�ͻ���socket����ʹ�õ���Socket����
		 * 		����ö���һ��������ȷĿ�ĵأ�Ҫ���ӵ�������
		 * 
		 * 2.������ӽ����ɹ���˵�����ݴ���ͨ���ѽ�����
		 * 		��ͨ������socket�����ǵײ㽨���õġ���Ȼ������˵������������룬���������
		 * 		��Ҫ���������������󣬿�����Socket����ȡ��
		 * 		����ͨ��getOutputStream()��getInputStream()����ȡ�����ֽ�����
		 * 
		 * 3.ʹ���������������д����
		 * 
		 * 4.�ر���Դ��
		 *		 
		 */
		
		//�����ͻ���socket����
		Socket socket = new Socket("127.0.0.1",10002);
		
		//��ȡsocket���е��������
		OutputStream out = socket.getOutputStream();
		
		//ʹ���������ָ��������д��ȥ��
		out.write("tcp��ʾ���������ˣ�����".getBytes());
		
		//�ر���Դ��
		socket.close();
	}

}










