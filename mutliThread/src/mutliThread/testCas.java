package mutliThread;

import java.util.concurrent.atomic.AtomicInteger;

public class testCas {
//	public static volatile int race = 0;
	public static AtomicInteger race = new AtomicInteger(0);
	public static int THREAD_NUM = 10;
	public static void increment() {
//		race ++;
		race.incrementAndGet();
	}
	
	public static void main(String[] args) {
		
		Thread[] threads = new Thread[THREAD_NUM];
		
		for (int i = 0; i < THREAD_NUM; i ++) {
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					int j = 0;
					for(int i = 0; i < 10000; i ++)
						j ++;
//					increment();
					System.out.println(Thread.currentThread() + " " + j);
				}
			});
			threads[i].start();
		}
	
		while (Thread.activeCount() > 1)
			Thread.yield();
		
		System.out.println(race);
	}
}
