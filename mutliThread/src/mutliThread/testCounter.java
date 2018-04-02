package mutliThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter implements Runnable {
	
	private static final Exception Exception = null;
	private int initNumber = 100;
	private Lock numberLock = new ReentrantLock();
	
	@Override
	public void run() {
		numberLock.lock();
		try{
			while(initNumber > 0){
				initNumber -= 1;
				System.out.println(Thread.currentThread());
				System.out.println("initNumber: " + initNumber);
				throw Exception;
			}
			
		} catch (java.lang.Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			numberLock.unlock();
		}
		
	}
}

public class testCounter {
	
	public static void main(String args[]) {
		Counter counter = new Counter();
		
		Thread thread1 = new Thread(counter);
		Thread thread2 = new Thread(counter);
		Thread thread3 = new Thread(counter);
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}

