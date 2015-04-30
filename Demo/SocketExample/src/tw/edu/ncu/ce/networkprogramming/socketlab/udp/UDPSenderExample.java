package tw.edu.ncu.ce.networkprogramming.socketlab.udp;

import java.io.*;
import java.net.*;

public class UDPSenderExample {

	private DatagramSocket sender = null;
	private String receiverAddress = null;
	private int receiverPort;

	public UDPSenderExample() throws UnknownHostException, IOException {
		this.receiverAddress = "127.0.0.1";
		this.receiverPort = 8888;
		sender = new DatagramSocket();
	}

	public void sendDatagram() throws IOException {
		String message = "Hi";
		byte[] data = message.getBytes();
		DatagramPacket packet = new DatagramPacket(data, data.length,
				InetAddress.getByName(this.receiverAddress), this.receiverPort);
		sender.send(packet);
	}

	public void closeSocket() {
		sender.close();
	}

}
