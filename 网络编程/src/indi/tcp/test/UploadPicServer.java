package indi.tcp.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadPicServer {

	public static void main(String[] args) throws IOException {

		//1.创建tcp的socket服务端。
		ServerSocket ss = new ServerSocket(10004);
		
		//2.获取客户端。
		Socket s = ss.accept();
		
		String ip = s.getInetAddress().getHostAddress();//获取ip地址
		System.out.println(ip+"......connected");
		
		//读取客户端发来的数据。
		InputStream in = s.getInputStream();
		
		//将读取到的数据存储到一个文件中。
		File dir = new File("c:\\pic");
		if(!dir.exists()){
			dir.mkdirs();
		}
		File file = new File(dir,ip+".jpg");
		FileOutputStream fos = new FileOutputStream(file);
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		
		while((len=in.read(buf))!=-1){
			fos.write(buf, 0, len);
		}
		
		//获取socket输出流，将上传成功字样发送给客户端。
		OutputStream out = s.getOutputStream();
		out.write("上传成功".getBytes());
		
		fos.close();
		s.close();
		ss.close();
		
	}

}










