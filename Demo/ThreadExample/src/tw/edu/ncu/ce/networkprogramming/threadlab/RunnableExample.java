package tw.edu.ncu.ce.networkprogramming.threadlab;

public class RunnableExample implements Runnable {
	public static void main(String[] args) {

		RunnableExample runnableExample = new RunnableExample();
		Thread thread = new Thread(runnableExample);
		thread.setName("RunnableExample");
		thread.start();
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
