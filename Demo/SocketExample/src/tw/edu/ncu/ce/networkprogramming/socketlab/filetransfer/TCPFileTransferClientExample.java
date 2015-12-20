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

	public TCPFileTransferClientExample() throws UnknownHostException,
			IOException {
		this.socket = new Socket("127.0.0.1", 3333);

	}

	public void getContent() throws IOException {

		File saveFile = new File("tmp");
		BufferedInputStream in = new BufferedInputStream(
				socket.getInputStream());
		FileOutputStream out = new FileOutputStream(saveFile);

		int len = 0;
		while ((len = in.read()) != -1) {

			out.write(len);
			out.flush();

		}
		System.out.println("Receive:END");
		out.close();

	}

	public void closeSocket() throws IOException {
		socket.close();
	}
}
