package tw.edu.ncu.ce.networkprogramming.socketlab.filetransfer;

import java.io.*;
import java.net.*;

public class TCPFileTransferServerExample {
	private ServerSocket socket;
	private Socket clntSocket;
	
	public static void main(String[] args) throws IOException {
		TCPFileTransferServerExample server = new TCPFileTransferServerExample();
		server.acceptClientSocket();
		server.deliverContent();
		server.closeSocket();
		
	}

	public TCPFileTransferServerExample() throws IOException {
		this.socket = new ServerSocket(3333);
	}

	public void acceptClientSocket() throws IOException {
		this.clntSocket = socket.accept();
	}

	public void deliverContent() throws IOException {
		OutputStream out = clntSocket.getOutputStream();
		InputStream in = new FileInputStream(new File("src.txt"));

		byte[] buff = new byte[8192];
		int len = 0;
		while ((len = in.read(buff)) >= 0) {
			out.write(buff, 0, len);
			System.out.println("Deliver:" + new String(buff));
			out.flush();
		}
		in.close();
	}

	public void closeSocket() throws IOException {
		socket.close();
	}
}
