package tw.edu.ncu.ce.networkprogramming.threadlab;

public class StopThreadByFlagExample implements Runnable {

	private volatile boolean isStopped = false;

	public static void main(String[] args) {

		StopThreadByFlagExample runnableExample = new StopThreadByFlagExample();
		Thread thread = new Thread(runnableExample);
		thread.setName("StopThreadByFlagExample");
		thread.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("(" + i + ")" + "This is the thread:"
					+ Thread.currentThread().getName());
			if (i == 5) {
				runnableExample.stopThread();

			}
		}

	}

	public void run() {
		int i = 0;
		while (!isStopped) {

			try {
				Thread.sleep(2000);// Blocking this thread
				System.out.println("(" + i + ")" + "This is the thread:"
						+ Thread.currentThread().getName());
				i++;
			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}
		return;

	}

	public void stopThread() {
		isStopped = true;
		System.out.println("try to stop?");
	}

}
