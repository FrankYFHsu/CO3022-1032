package tw.edu.ncu.ce.networkprogramming.threadlab;

public class StopThreadByInterruptWithBlockingExample implements Runnable {

	public static void main(String[] args) {
		StopThreadByInterruptWithBlockingExample runnableExample = new StopThreadByInterruptWithBlockingExample();
		Thread thread = new Thread(runnableExample);
		thread.setName("StopThreadByInterruptWithBlockingExample");
		thread.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("(" + i + ")" + "This is the thread:"
					+ Thread.currentThread().getName());
			if (i == 5) {
				thread.interrupt();
			}
		}

	}

	@Override
	public void run() {
		int i = 0;
		while (true) {

			try {
				Thread.sleep(2000);// Blocking thiss thread
				System.out.println("(" + i + ")" + "This is the thread:"
						+ Thread.currentThread().getName());
				i++;
			} catch (InterruptedException e) {
				System.out.println("Interrupted! ");
				return;
			}

		}

	}

}
