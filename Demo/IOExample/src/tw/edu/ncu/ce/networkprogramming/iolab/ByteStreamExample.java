package tw.edu.ncu.ce.networkprogramming.iolab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExample {

	public static void main(String[] args) throws IOException {
		
		example3();
		
	}
	
	public static void example1() throws IOException {
		
		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			in = new FileInputStream("input.txt");
			out = new FileOutputStream("output.txt");
			int nextByte;

			while ((nextByte = in.read()) != -1) {
				System.out.println(nextByte);
				out.write(nextByte);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
	
	public static void example2() throws IOException {

		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			in = new FileInputStream("input.txt");
			out = new FileOutputStream("output.txt");
			int availableByte;
			byte[] buff = new byte[1024];

			while ((availableByte = in.read(buff)) != -1) {
				System.out.println(availableByte);
				out.write(buff);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
	
	public static void example3() throws IOException {

		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			in = new FileInputStream("input.txt");
			out = new FileOutputStream("output.txt");
			int availableByte;
			byte[] buff = new byte[1024];

			while ((availableByte = in.read(buff, 0, buff.length)) != -1) {
				System.out.println(availableByte);
				out.write(buff, 0, availableByte);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

}
