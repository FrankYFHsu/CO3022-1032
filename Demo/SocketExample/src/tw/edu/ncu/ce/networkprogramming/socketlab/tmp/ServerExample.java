package tw.edu.ncu.ce.networkprogramming.socketlab.tmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServerExample example = new ServerExample();
		example.startServer();

	}

	public void startServer() {

		try {
			ServerSocket serverSocket = new ServerSocket(12345);

			Socket newSocket = serverSocket.accept();
			
			Scanner sc = new Scanner(newSocket.getInputStream());
			
			while(sc.hasNextLine()){
				System.out.println(sc.nextLine());
			}
			System.out.println("over");
			sc.close();

			//BufferedReader br = new BufferedReader(new InputStreamReader(
			//		newSocket.getInputStream()));

			//String str = br.readLine();
			//System.out.println(str);

			//br.close();
			newSocket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
