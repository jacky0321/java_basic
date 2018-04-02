package mutliThread;

public class MyThread implements Runnable {

	private int num = 10;

	@Override
	public void run() {
		while (num > 0) {
			System.out.println(Thread.currentThread() + " " + num--);
		}
		System.out.println(Thread.currentThread() + " is over.");
	}

	public static void main(String[] args) throws InterruptedException {
		MyThread myThread = new MyThread();
		Thread thread1 = new Thread(new MyThread(), "线程1");
		Thread thread2 = new Thread(new MyThread(), "线程2");
		Thread thread3 = new Thread(new MyThread(), "线程3");
		
		thread1.setDaemon(true);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
//		thread1.join();
		thread2.join();
		thread3.join();
		
		System.out.println(Thread.activeCount());
		System.out.println(thread1.isAlive());
	}
}

