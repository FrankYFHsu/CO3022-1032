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

		try (ServerSocket serverSocket = new ServerSocket(port)) {

			while (true) {
				Socket newSocket = serverSocket.accept();
				Thread clientHandler = new Thread(new ClientHandler(newSocket));
				clientHandler.start();

			}

		} catch (IOException e) {
			print("Server Error :" + e.getMessage());

		}

	}

	public static void print(String message) {
		System.out.println(message);
	}

}

class ClientHandler implements Runnable {
	private Socket client;
	private Scanner in;
	PrintWriter out;

	public ClientHandler(Socket socket) {
		client = socket;
		try {
			in = new Scanner(client.getInputStream());
			out = new PrintWriter(client.getOutputStream());
		} catch (IOException e) {
			ConcurrentTCPEchoServer.print("Server Error :" + e.getMessage());
		}

	}

	@Override
	public void run() {
		try {

			ConcurrentTCPEchoServer.print("Client information :"
					+ client.getRemoteSocketAddress());

			while (in.hasNextLine()) {
				String incomingMessage = in.nextLine();
				out.println(incomingMessage);
				out.flush();
			}
			ConcurrentTCPEchoServer.print("Client exits");
			out.close();
			in.close();

			client.close();
		} catch (IOException e) {
			ConcurrentTCPEchoServer.print("Server Error :" + e.getMessage());
		} finally {
			try {
				if (client != null) {
					client.close();
				}
			} catch (IOException e) {
				ConcurrentTCPEchoServer
						.print("Server Error :" + e.getMessage());
			}
		}

	}

}
