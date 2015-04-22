package tw.edu.ncu.ce.networkprogramming.threadlab;

public class SleepExample extends Thread {

	public static void main(String[] args) {

		SleepExample threadExample = new SleepExample();
		threadExample.setName("SleepExample");
		threadExample.start();
		for (int i = 0; i < 10; i++) {
			if(i==0){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			System.out.println("This is the thread:"
					+ Thread.currentThread().getName());

		}

	}

	public void run() {
		for (int i = 0; i < 10; i++)
			System.out.println("This is the thread:"
					+ Thread.currentThread().getName());

	}

}
