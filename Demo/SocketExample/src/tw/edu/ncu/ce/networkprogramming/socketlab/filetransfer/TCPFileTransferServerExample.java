package tw.edu.ncu.ce.networkprogramming.socketlab.filetransfer;

import java.io.*;
import java.net.*;

import javax.swing.JFileChooser;

public class TCPFileTransferServerExample {
	private ServerSocket socket;
	private Socket clntSocket;
	private JFileChooser fileChooser;

	public static void main(String[] args) throws IOException {
		TCPFileTransferServerExample server = new TCPFileTransferServerExample();
		server.acceptClientSocket();
		server.deliverContent();
		server.closeSocket();

	}

	public TCPFileTransferServerExample() throws IOException {
		this.socket = new ServerSocket(3333);
		fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Transfer");
	}

	public void acceptClientSocket() throws IOException {
		this.clntSocket = socket.accept();
	}

	public void deliverContent() throws IOException {

		int returnVal = fileChooser.showSaveDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {

			File deliveredFile = fileChooser.getSelectedFile();
			OutputStream out = clntSocket.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(out);
			FileInputStream in = new FileInputStream(deliveredFile);

			byte[] buff = new byte[1024];
			int len = 0;
			while ((len = in.read(buff)) >= 0) {
				bos.write(buff, 0, len);
				System.out.println("Deliver:" + new String(buff));
				bos.flush();
			}
			bos.close();
			in.close();

		}

	}

	public void closeSocket() throws IOException {
		socket.close();
		System.out.println("Server is closed");
	}
}
