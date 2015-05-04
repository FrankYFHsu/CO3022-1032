package tw.edu.ncu.ce.networkprogramming.socketlab.echo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPEchoServer {

	public static void main(String[] args) {
		
		TCPEchoServer example = new TCPEchoServer();
		example.startServer(12345);

	}

	public void startServer(int port) {

		try {
			ServerSocket serverSocket = new ServerSocket(port);

			Socket newSocket = serverSocket.accept();
			print("Client information :" + newSocket.getRemoteSocketAddress());
			
			Scanner sc = new Scanner(newSocket.getInputStream());
			PrintWriter pw = new PrintWriter(newSocket.getOutputStream());

			while (sc.hasNextLine()) {
				String incomingMessage = sc.nextLine();
				pw.println(incomingMessage);
				pw.flush();
			}
			print("Client exits");
			pw.close();
			sc.close();

			newSocket.close();
			serverSocket.close();
		} catch (IOException e) {
			print("Server Error :"+e.getMessage());
		}

	}
	public static void print(String message){
		System.out.println(message);
	}

}
