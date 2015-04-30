package tw.edu.ncu.ce.networkprogramming.socketlab.multicast;

import java.io.IOException;

public class Multicast {

	public static void main(String[] args) throws IOException {

		MulticastSender mSender = new MulticastSender();
		MulticastReceiver mReceiver = new MulticastReceiver();
		mSender.sendPacket();
		mReceiver.receivePacket();
		mReceiver.closeSocket();
		mSender.closeSocket();

	}
}
