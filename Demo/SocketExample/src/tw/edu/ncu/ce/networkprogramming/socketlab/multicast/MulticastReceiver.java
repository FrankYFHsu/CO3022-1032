package tw.edu.ncu.ce.networkprogramming.socketlab.multicast;

import java.io.*;
import java.net.*;

public class MulticastReceiver {
	// public static void main(String[] args) throws IOException

	private MulticastSocket socket = null;
	private InetAddress broadcastAddress = null;

	public MulticastReceiver() throws IOException {
		int listenPort = 8888;
		this.socket = new MulticastSocket(listenPort);
		this.broadcastAddress = InetAddress.getByName("224.0.0.1");
		this.socket.joinGroup(broadcastAddress);
	}

	public void receivePacket() throws IOException {
		int bufSize = 8192;
		byte[] recBuf = new byte[bufSize];
		DatagramPacket packet = new DatagramPacket(recBuf, recBuf.length);
		this.socket.receive(packet);
		String msg = new String(recBuf, 0, packet.getLength());
		System.out.println("From " + packet.getAddress() + " Msg : " + msg);
	}

	public void closeSocket() {
		socket.close();
	}
}
