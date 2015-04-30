package tw.edu.ncu.ce.networkprogramming.socketlab.tmp;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientExample example = new ClientExample();
		example.startClient("localhost", 12345);

	}
	
	public void startClient(String ip, int port){
		
		try {
			Socket socketToServer = new Socket(ip,port);
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socketToServer.getOutputStream()));
			
			pw.println("yo");
			pw.close();
			socketToServer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
