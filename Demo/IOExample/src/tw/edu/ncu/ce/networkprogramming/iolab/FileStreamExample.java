package tw.edu.ncu.ce.networkprogramming.iolab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamExample {

	public static void main(String[] args) throws IOException {

		File sourceFile = new File("abc.jpg");
		System.out.println("檔案大小:" + sourceFile.length() + "bytes");
		System.out.println("檔案路徑:" + sourceFile.getAbsolutePath());
		FileInputStream input = new FileInputStream(sourceFile);

		File destFile = new File("abc_new.jpg");
		FileOutputStream output = new FileOutputStream(destFile);

		byte[] data = new byte[1024];
		int numberOfBytes;
		while ((numberOfBytes = input.read(data)) != -1) {
			output.write(data, 0, numberOfBytes);
			output.flush();
		}

		input.close();
		output.close();
		System.out.println(destFile.length());
	}

}
