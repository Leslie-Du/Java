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
		 * ת���ͻ��ˣ�
		 * 1.����socket�ͻ��˶���
		 * 2.��ȡ����¼�롣
		 * 3.��¼�����Ϣ���͸�socket�������
		 * 4.socket����������ȡ����˷��صĴ�д����
		 */
		
		//1.����socket�ͻ��˶���
		Socket s = new Socket("127.0.0.1",10002);
		
		//2.��ȡ����¼��
		BufferedReader bufr = 
				new BufferedReader(new InputStreamReader(System.in));
		
		//3.��¼�����Ϣ���͸�socket�����.
//		new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		//4.socket����������ȡ����˷��صĴ�д����
		BufferedReader bufIn = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
		
		String line = null;
		
		while((line=bufr.readLine())!=null){
			
			if("over".equals(line))
				break;
			out.println(line);
			
			//��ȡ����˷��ص�һ�д�д���ݡ�
			String upperStr = bufIn.readLine();
			System.out.println(upperStr);
			
		}
		
		s.close();
		
	}

}
