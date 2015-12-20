package tw.edu.ncu.ce.networkprogramming.socketlab.udp;

import java.io.IOException;
import java.net.UnknownHostException;

public class UDPDemo {

	public static void main(String[] args) throws IOException,
			UnknownHostException {

		UDPReceiverExample udpServer = new UDPReceiverExample();
		UDPSenderExample udpClient = new UDPSenderExample();

		udpClient.sendDatagram();
		udpClient.closeSocket();
		udpServer.receiveDatagram();
		udpServer.closeSocet();

	}

}
