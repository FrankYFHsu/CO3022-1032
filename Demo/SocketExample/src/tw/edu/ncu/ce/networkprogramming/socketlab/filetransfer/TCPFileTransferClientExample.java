package tw.edu.ncu.ce.networkprogramming.socketlab.filetransfer;

import java.io.*;
import java.net.*;

public class TCPFileTransferClientExample {
	private Socket socket;

	public TCPFileTransferClientExample() throws UnknownHostException, IOException {
		this.socket = new Socket("127.0.0.1", 3333);
	}

	public void getContent() throws IOException {

		InputStream in = socket.getInputStream();
		OutputStream out = new FileOutputStream(new File("dest.txt"));

		byte[] buff = new byte[8192];
		int len = 0;
		while ((len = in.read(buff)) >= 0) {
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
