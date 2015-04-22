package tw.edu.ncu.ce.networkprogramming.threadlab;

public class ThreadExample extends Thread {

	public static void main(String[] args) {

		ThreadExample threadExample = new ThreadExample();
		threadExample.setName("ThreadExample");
		threadExample.start();
		for (int i = 0; i < 10; i++)
			System.out.println("This is the thread:"
					+ Thread.currentThread().getName());

	}

	public void run() {
		for (int i = 0; i < 10; i++)
			System.out.println("This is the thread:"
					+ Thread.currentThread().getName());

	}

}
