package tw.edu.ncu.ce.networkprogramming.iolab;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharacterExample {

	public static void main(String[] args) {

		try {
			File srcFile = new File("inputExample.txt");

			FileReader input = new FileReader(srcFile);

			File destFile = new File("outputFile.txt");

			FileWriter fw = new FileWriter(destFile);

			char[] charBuffer = new char[512];

			int numberOfCharacters;
			while ((numberOfCharacters = input.read(charBuffer)) != -1) {

				fw.write(charBuffer, 0, numberOfCharacters);
				fw.flush();
			}
			input.close();
			fw.close();

		} catch (IOException e) {

			System.out.println(e.getMessage());
		}

	}
}
