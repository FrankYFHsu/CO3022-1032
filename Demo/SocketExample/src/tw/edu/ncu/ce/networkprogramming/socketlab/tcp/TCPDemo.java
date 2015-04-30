package tw.edu.ncu.ce.networkprogramming.socketlab.tcp;

import java.io.IOException;

public class TCPDemo {

	public static void main(String[] args) throws IOException {
		TCPServerExample tcpServer = new TCPServerExample();
		TCPClientExample tcpClient = new TCPClientExample();

		tcpServer.acceptClientSocket();
		tcpClient.sendMessage();
		tcpServer.receiveMessage();

		tcpServer.closeClientSocket();
		tcpClient.closeSocket();

	}

}
