package tw.edu.ncu.ce.networkprogramming.threadlab;

public class JoinThreadExample extends Thread {

	public static void main(String[] args) {
		
		JoinThreadExample threadExample = new JoinThreadExample();
		threadExample.setName("JoinThreadExample");
		threadExample.start();

		for (int i = 0; i < 10; i++) {
			System.out.println(i + "-This is the thread:"
					+ Thread.currentThread().getName());
			if (i == 1) {
				try {
					System.out.println("threadExample join");
					threadExample.join();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}

		}

	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "-This is the thread:"
					+ Thread.currentThread().getName());
			if (i == 2) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		}

	}

}
