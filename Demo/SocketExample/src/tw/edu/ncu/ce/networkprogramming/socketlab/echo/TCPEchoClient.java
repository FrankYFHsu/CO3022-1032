package tw.edu.ncu.ce.networkprogramming.socketlab.echo;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPEchoClient {

	public static void main(String[] args) {

		TCPEchoClient example = new TCPEchoClient();
		example.startEchoService("localhost", 12345);

	}

	public void startEchoService(String ip, int port) {

		/*
		 * Using try-with-resources statement the Java runtime will close these
		 * resources automatically.
		 */
		try (Socket socketToServer = new Socket(ip, port);

				Scanner sc = new Scanner(System.in);

				PrintWriter pw = new PrintWriter(new OutputStreamWriter(
						socketToServer.getOutputStream()));
				Scanner inputScanner = new Scanner(
						socketToServer.getInputStream())) {

			while (sc.hasNextLine()) {
				String message = sc.nextLine();
				if (message.equals("quit") || message.equals("exit")) {
					break;
				}
				pw.println(message);
				pw.flush();
				print("send: " + message);

				String echoMessage = inputScanner.nextLine();
				print("receive: " + echoMessage);

			}
			/*
			 * The following is not required.
			 * inputScanner.close(); pw.close(); sc.close();
			 * socketToServer.close();
			 */

		} catch (IOException e) {
			print("Client Error:" + e.getMessage());
		}

	}

	public static void print(String message) {
		System.out.println(message);
	}

}
