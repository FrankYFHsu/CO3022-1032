package tw.edu.ncu.ce.networkprogramming.iolab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BufferedReaderExample {

	public static void main(String[] args) {
		try {
			File srcFile = new File("inputExample.txt");
			BufferedReader br = new BufferedReader(new FileReader(srcFile));

			File destFile = new File("outputFile.txt");

			PrintWriter pw = new PrintWriter(new FileWriter(destFile),true);
			//第二個參數設true, println,printf,format會autoflush
			String readStrings;

			while ((readStrings = br.readLine()) != null) {
				pw.printf("%s\n", readStrings);
				// 最後一行會有換行符號
			}

			br.close();
			pw.close();

		} catch (IOException e) {

			System.out.println(e.getMessage());
		}

	}
}
