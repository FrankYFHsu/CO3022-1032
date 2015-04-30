package tw.edu.ncu.ce.networkprogramming.socketlab.tcp;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UseSocketCheckHTTP {

	public static void main(String[] args) {
		String host = "www.ncu.edu.tw";
		int port = 80;
		
		try {
			Socket socket = new Socket(host, port);

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(
					socket.getOutputStream()), true);
			pw.println("GET / HTTP/1.1");
			pw.println("HOST: "+host);
			pw.println();

			Scanner sc = new Scanner(socket.getInputStream());
			while (sc.hasNextLine())
				System.out.println(sc.nextLine());

			sc.close();
			pw.close();

		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
