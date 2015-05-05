package tw.edu.ncu.ce.networkprogramming.socketlab.address;

import java.net.*;
import java.util.*;

public class InetAddressExample {
	public static void main(String args[]) {

		try {
			println("getLocalHost()");
			println(InetAddress.getLocalHost());
			println("-----------");
			println("getLoopbackAddress()");
			println(InetAddress.getLoopbackAddress());
			println("-----------");
			println("getByName(host)");
			findIPbyHostName("www.ncu.edu.tw");
			println("-----------");
			println("getAllByName(host)");
			findAllIPsbyHostName("www.ncu.edu.tw");
			println("-----------");
			println("NetworkInterface");
			showNetworkInterfaceInformation();

		} catch (SocketException e) {
			println("Error:" + e.getMessage());
		} catch (UnknownHostException e) {

			println("Error:" + e.getMessage());
		}
	}

	public static void findIPbyHostName(String hostname) {

		try {
			InetAddress address = InetAddress.getByName(hostname);
			println(address);
		} catch (UnknownHostException e) {
			println("Could't find" + hostname);
		}

	}

	public static void findAllIPsbyHostName(String hostname) {

		try {
			InetAddress[] address = InetAddress.getAllByName(hostname);

			for (int i = 0; i < address.length; i++) {
				println(address[i]);
			}
		} catch (UnknownHostException e) {
			println("Could't find" + hostname);
		}

	}

	public static void showNetworkInterfaceInformation() throws SocketException {

		Enumeration<NetworkInterface> nets = NetworkInterface
				.getNetworkInterfaces();
		for (NetworkInterface netint : Collections.list(nets)) {
			println("Display name:" + netint.getDisplayName());
			println("Name: " + netint.getName());

			Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
			for (InetAddress inetAddress : Collections.list(inetAddresses))
				println("InetAddress: " + inetAddress);

		}
	}

	public static void println(String str) {
		System.out.println(str);
	}
	public static void println(InetAddress address){
		System.out.println(address);
	}
}
