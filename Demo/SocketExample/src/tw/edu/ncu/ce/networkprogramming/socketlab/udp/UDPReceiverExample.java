package tw.edu.ncu.ce.networkprogramming.socketlab.udp;

import java.net.*;
import java.io.*;

public class UDPReceiverExample {
	private DatagramSocket receiver;

	public UDPReceiverExample() throws IOException {
		int listenPort = 8888;
		this.receiver = new DatagramSocket(listenPort);
	}

	public void receiveDatagram() throws IOException {
		int bufSize = 1024;
		byte[] recBuf = new byte[bufSize];
		DatagramPacket receiveData = new DatagramPacket(recBuf, recBuf.length);
		this.receiver.receive(receiveData);
		String rec = new String(recBuf, 0, receiveData.getLength());
		System.out.println(rec);
	}

	public void closeSocet() {
		receiver.close();
	}
}
