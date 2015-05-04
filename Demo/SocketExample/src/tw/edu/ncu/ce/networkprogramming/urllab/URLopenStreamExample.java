package tw.edu.ncu.ce.networkprogramming.urllab;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class URLopenStreamExample {

	public static void main(String[] args) {
		String host = "http://www.ncu.edu.tw/index.php";

		try {
			URL url = new URL(host);
			System.out.println("protocol = " + url.getProtocol());
			System.out.println("authority = " + url.getAuthority());
			System.out.println("host = " + url.getHost());
			System.out.println("port = " + url.getPort());
			System.out.println("path = " + url.getPath());
			System.out.println("query = " + url.getQuery());
			System.out.println("filename = " + url.getFile());
			System.out.println("ref = " + url.getRef());
			System.out.println("----------------");

			Scanner sc = new Scanner(url.openStream());
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			sc.close();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
