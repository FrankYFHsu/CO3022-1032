package tw.edu.ncu.ce.networkprogramming.iolab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CharacterStreamExample {

	public static void main(String[] args) throws IOException {
		example4();
	}

	public static void example1() throws IOException {

		FileReader in = null;
		FileWriter out = null;

		try {
			in = new FileReader("input.txt");
			out = new FileWriter("output.txt");
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

		FileReader in = null;
		FileWriter out = null;

		try {
			in = new FileReader("input.txt");
			out = new FileWriter("output.txt");
			int availableByte;
			char[] buff = new char[1024];

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

		FileReader in = null;
		FileWriter out = null;

		try {
			in = new FileReader("input.txt");
			out = new FileWriter("output.txt");
			int availableByte;
			char[] buff = new char[1024];
			while ((availableByte = in.read(buff, 0, buff.length)) != -1) {
				System.out.println(availableByte);
				out.write(buff, 0, availableByte);
				out.flush();
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

	public static void example4() throws IOException {

		BufferedReader in = null;
		BufferedWriter out = null;

		try {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new BufferedWriter(new FileWriter("output.txt"));
			String message;
			while ((message = in.readLine()) != null) {
				System.out.println(message);
				out.write(message + "\n");
				out.flush();
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

	public static void example5() throws IOException {

		BufferedReader in = null;
		PrintWriter out = null;

		try {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter(new FileWriter("output.txt"));
			String message;
			while ((message = in.readLine()) != null) {
				System.out.println(message);
				out.println(message);

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

	public static void example6() throws IOException {

		try (BufferedReader in = new BufferedReader(new FileReader("input.txt"));
				PrintWriter out = new PrintWriter(new FileWriter("output.txt"))

		) {

			String message;
			while ((message = in.readLine()) != null) {
				System.out.println(message);
				out.println(message);

			}

		}
	}

}
