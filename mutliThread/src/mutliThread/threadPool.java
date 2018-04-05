package mutliThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class threadDemo implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is running...");
	}
	
}
public class threadPool {

	public static void main(String[] args) {
//		ExecutorService pool = Executors.newSingleThreadExecutor();
////		ExecutorService pool = Executors.newFixedThreadPool(3);
//		ExecutorService pool = Executors.newCachedThreadPool();
//		Thread thread1 = new Thread(new threadDemo());
//		Thread thread2 = new Thread(new threadDemo());
//		Thread thread3 = new Thread(new threadDemo());
//		
////		thread1.start();
////		thread2.start();
////		thread3.start();
//		
//		pool.execute(thread1);
//		pool.execute(thread2);
//		pool.execute(thread3);
//
//		try {
//			Thread.sleep(3 * 1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		pool.execute(thread2);
//		pool.execute(thread3);
//		
//		pool.shutdown();
		
		ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(1);
		pool.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				System.out.print("=====");
				System.out.println(System.currentTimeMillis());
			}
		}, 1000, 5000, TimeUnit.MILLISECONDS);
		
		
	}
}
