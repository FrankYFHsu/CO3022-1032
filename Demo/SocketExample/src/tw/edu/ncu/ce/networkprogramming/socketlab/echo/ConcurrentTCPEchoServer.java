package tw.edu.ncu.ce.networkprogramming.socketlab.echo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConcurrentTCPEchoServer {

	public static void main(String[] args) {
		ConcurrentTCPEchoServer server = new ConcurrentTCPEchoServer();
		server.startServer(12345);
	}

	public void startServer(int port) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);

			while (true) {
				Socket newSocket = serverSocket.accept();
				Thread subServerThread = new Thread(new SubServer(newSocket));
				subServerThread.start();

			}

		} catch (IOException e) {
			print("Server Error :" + e.getMessage());
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e1) {
					print("Server Error :" + e.getMessage());
				}
			}
		}

	}

	public static void print(String message) {
		System.out.println(message);
	}

}

class SubServer implements Runnable {
	private Socket socketToClient;

	public SubServer(Socket socket) {
		socketToClient = socket;
	}

	@Override
	public void run() {
		try (Scanner sc = new Scanner(socketToClient.getInputStream());
				PrintWriter pw = new PrintWriter(
						socketToClient.getOutputStream())) {

			ConcurrentTCPEchoServer.print("Client information :"
					+ socketToClient.getRemoteSocketAddress());

			while (sc.hasNextLine()) {
				String incomingMessage = sc.nextLine();
				pw.println(incomingMessage);
				pw.flush();
			}
			ConcurrentTCPEchoServer.print("Client exits");
			pw.close();
			sc.close();

			socketToClient.close();
		} catch (IOException e) {
			ConcurrentTCPEchoServer.print("Server Error :" + e.getMessage());
		}

	}

}
