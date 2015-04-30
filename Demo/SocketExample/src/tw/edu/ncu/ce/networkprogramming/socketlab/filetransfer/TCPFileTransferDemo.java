package tw.edu.ncu.ce.networkprogramming.socketlab.filetransfer;

import java.io.IOException;

public class TCPFileTransferDemo {

	public static void main(String[] args) throws IOException {

		TCPFileTransferServerExample server = new TCPFileTransferServerExample();
		TCPFileTransferClientExample client = new TCPFileTransferClientExample();

		server.acceptClientSocket();
		server.deliverContent();
		client.getContent();

	}

}
