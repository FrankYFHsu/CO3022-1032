package tw.edu.ncu.ce.networkprogramming.socketlab.multicast;

import java.io.*;
import java.net.*;

public class MulticastSender {
	private DatagramPacket packet = null;
	private MulticastSocket socket = null;
	private InetAddress address = null;
	int port;

	public MulticastSender() throws IOException {
		this.socket = new MulticastSocket();
		this.address = InetAddress.getByName("224.0.0.1");
		this.port = 8888;
	}

	public void sendPacket() throws IOException {
		String msg = "Hello";
		packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length,
				this.address, this.port);

		socket.send(packet);
	}

	public void closeSocket() {
		socket.close();
	}
}
