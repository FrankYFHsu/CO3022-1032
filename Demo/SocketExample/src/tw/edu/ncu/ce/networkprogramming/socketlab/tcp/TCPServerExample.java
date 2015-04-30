package tw.edu.ncu.ce.networkprogramming.socketlab.tcp;

import java.net.*;
import java.io.*;

public class TCPServerExample {
	private ServerSocket servSock;
	private Socket clntSock;
	private SocketAddress clientAddress;
	private int listenPort;

	public TCPServerExample() throws IOException {
		this.listenPort = 8888;
		this.servSock = new ServerSocket(listenPort);
	}

	public void acceptClientSocket() throws IOException {
		this.clntSock = servSock.accept(); // to get client connection
		this.clientAddress = clntSock.getRemoteSocketAddress();
		System.out.println("client information " + clientAddress);
	}

	public void receiveMessage() throws IOException {
		int recvMsgSize;
		int bufSize = 1024;
		byte[] receiveBuf = new byte[bufSize];
		InputStream in = clntSock.getInputStream();

		while ((recvMsgSize = in.read(receiveBuf)) != -1) {
			System.out.println(new String(receiveBuf, 0, recvMsgSize));
		}
	}

	public void closeClientSocket() throws IOException {
		clntSock.close();
	}
}
