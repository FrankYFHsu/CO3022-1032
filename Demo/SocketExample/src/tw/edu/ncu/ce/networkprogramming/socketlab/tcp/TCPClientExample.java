package tw.edu.ncu.ce.networkprogramming.socketlab.tcp;

import java.io.*;
import java.net.*;

public class TCPClientExample {
	private Socket socket;
	private String server;
	private int serverPort;

	public TCPClientExample() throws UnknownHostException, IOException {
		this.server = "127.0.0.1";
		this.serverPort = 8888;
		this.socket = new Socket(server, serverPort);
	}

	public void sendMessage() throws IOException {
		String message = "Hi";
		OutputStream out = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(out);
		pw.println(message);
		pw.flush();	
		pw.close();//send eof?
	}

	public void closeSocket() throws IOException {
		socket.close();
	}
}
