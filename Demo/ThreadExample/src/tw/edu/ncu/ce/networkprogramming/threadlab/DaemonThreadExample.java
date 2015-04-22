package tw.edu.ncu.ce.networkprogramming.threadlab;

public class DaemonThreadExample extends Thread {
	public static void main(String[] args) {

		DaemonThreadExample threadExample = new DaemonThreadExample();
		threadExample.setName("DaemonThreadExample");
		threadExample.setDaemon(true);
		threadExample.start();

		for (int i = 0; i < 10; i++)
			System.out.println(i+"- "+"This is the thread:"
					+ Thread.currentThread().getName());

	}

	public void run() {

		for (int i = 0; i < 100; i++)
			System.out.println(i+"- "+"This is the thread:"
					+ Thread.currentThread().getName());

	}
}
