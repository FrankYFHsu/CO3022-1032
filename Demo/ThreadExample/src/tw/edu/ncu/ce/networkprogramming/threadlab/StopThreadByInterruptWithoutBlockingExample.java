package tw.edu.ncu.ce.networkprogramming.threadlab;

public class StopThreadByInterruptWithoutBlockingExample implements Runnable {

	public static void main(String[] args) {
		StopThreadByInterruptWithoutBlockingExample runnableExample = new StopThreadByInterruptWithoutBlockingExample();
		Thread thread = new Thread(runnableExample);
		thread.setName("StopThreadByInterruptWithoutBlockingExample");
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

				if (Thread.interrupted())
					throw new InterruptedException();

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
