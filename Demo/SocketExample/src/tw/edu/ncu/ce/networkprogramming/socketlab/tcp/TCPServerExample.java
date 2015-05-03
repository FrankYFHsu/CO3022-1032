package tw.edu.ncu.ce.networkprogramming.socketlab.tcp;

import java.net.*;
import java.util.Scanner;
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

		InputStream in = clntSock.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		String str;
		while((str=br.readLine())!=null){
			System.out.println(str);
		}
		System.out.println("end");
	}

	public void closeClientSocket() throws IOException {
		clntSock.close();
		servSock.close();
	}
}
