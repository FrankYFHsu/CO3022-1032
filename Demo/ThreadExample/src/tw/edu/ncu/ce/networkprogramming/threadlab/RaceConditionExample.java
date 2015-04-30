package tw.edu.ncu.ce.networkprogramming.threadlab;


public class RaceConditionExample {

	public static void main(String[] args) {

		MyCounter counter = new MyCounter();
		Runnable runnableA = new TestRunnable(counter);
		Thread t1 = new Thread(runnableA, "T1");
		Runnable runnableB = new TestRunnable(counter);
		Thread t2 = new Thread(runnableB, "T2");

		t1.start();
		t2.start();

	}

}

class TestRunnable implements Runnable {

	private MyCounter myNumber;

	public TestRunnable(MyCounter myNumber) {
		this.myNumber = myNumber;
	}

	public void run() {

		for (int i = 1; i <= 50; i++) {

			try {
				Thread.sleep(100);
				count();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

	}

	public void count() {
		myNumber.count();
	}

}

class MyCounter {

	private int number = 0;

	public void count() {
		synchronized (this) {
			number = number + 1;
			System.out.println(Thread.currentThread().getName() + " count = "
					+ number);
		}
	}

}
