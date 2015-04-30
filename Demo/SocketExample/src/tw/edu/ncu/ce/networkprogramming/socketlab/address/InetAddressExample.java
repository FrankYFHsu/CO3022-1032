package tw.edu.ncu.ce.networkprogramming.socketlab.address;

import java.net.*;
import java.util.*;

public class InetAddressExample {
	public static void main(String args[]) {

		try {
			System.out.println("getLocalHost()");
			System.out.println(InetAddress.getLocalHost());
			System.out.println("-----------");
			System.out.println("getLoopbackAddress()");
			System.out.println(InetAddress.getLoopbackAddress());
			System.out.println("-----------");
			System.out.println("getByName(host)");
			findIPbyHostName("www.ncu.edu.tw");
			System.out.println("-----------");
			System.out.println("getAllByName(host)");
			findAllIPsbyHostName("www.ncu.edu.tw");
			System.out.println("-----------");
			System.out.println("NetworkInterface");
			showNetworkInterfaceInformation();
	
		} catch (SocketException e) {

		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
	}

	public static void findIPbyHostName(String hostname) {

		try {
			InetAddress address = InetAddress.getByName(hostname);
			System.out.println(address);
		} catch (UnknownHostException e) {
			System.out.println("Could't find" + hostname);
		}

	}

	public static void findAllIPsbyHostName(String hostname) {

		try {
			InetAddress[] address = InetAddress.getAllByName(hostname);

			for (int i = 0; i < address.length; i++) {
				System.out.println(address[i]);
			}
		} catch (UnknownHostException e) {
			System.out.println("Could't find" + hostname);
		}

	}

	public static void showNetworkInterfaceInformation() throws SocketException {

		Enumeration<NetworkInterface> nets = NetworkInterface
				.getNetworkInterfaces();
		for (NetworkInterface netint : Collections.list(nets)) {
			System.out.println("Display name:" + netint.getDisplayName());
			System.out.println("Name: " + netint.getName());

			Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
			for (InetAddress inetAddress : Collections.list(inetAddresses))
				System.out.println("InetAddress: " + inetAddress);

			System.out.println();
		}
	}
}
