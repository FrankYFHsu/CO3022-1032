package tw.edu.ncu.ce.networkprogramming.socketlab.filetransfer;

import java.io.*;
import java.net.*;

public class TCPFileTransferClientExample {
	private Socket socket;

	public static void main(String[] args) throws IOException {
		TCPFileTransferClientExample client = new TCPFileTransferClientExample();
		client.getContent();
		client.closeSocket();
	}
	
	
	public TCPFileTransferClientExample() throws UnknownHostException, IOException {
		this.socket = new Socket("127.0.0.1", 3333);
	}

	public void getContent() throws IOException {

		BufferedInputStream in = new BufferedInputStream( socket.getInputStream());
		FileOutputStream out = new FileOutputStream(new File("dest.txt"));

		byte[] buff = new byte[8192];
		int len = 0;
		while (in.available()>0) {
			len = in.read(buff);
			
			out.write(buff, 0, len);
			System.out.println("Receive:" + new String(buff));
			out.flush();
		}
		out.close();
	}

	public void closeSocket() throws IOException {
		socket.close();
	}
}
