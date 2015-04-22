package tw.edu.ncu.ce.networkprogramming.iolab;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		
		String msg = "1 3 5 7 9 11";
		
		Scanner sc = new Scanner(msg);
		
		while(sc.hasNextInt()){
			System.out.println(sc.nextInt());
		}
		
		sc.close();
		
		
	}

}
