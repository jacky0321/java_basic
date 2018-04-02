package mutliThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.sql.PooledConnection;

class Producer implements Runnable {

	private int num = 100;
	private BlockingQueue<Integer> queue = null;
	
	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			while(this.num > 0){
				this.queue.put(this.num);
				this.num -= 1;
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable {
	
	private int num = 100;
	private BlockingQueue<Integer> queue = null;
	
	public Consumer (BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			
			while(num != 0){
				num = this.queue.take();
				System.out.print(Thread.currentThread());
				System.out.println(" take : " + num + " ticket. ");
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class testQueue {

	public static final int capacity = 100;
	public static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);
		
	public static void main(String args[]) {
		
		ExecutorService pool = Executors.newCachedThreadPool();

		Producer producer = new Producer(queue);
		Consumer consumer1 = new Consumer(queue);
		Consumer consumer2 = new Consumer(queue);
		Consumer consumer3 = new Consumer(queue);
		
		Thread thread1 = new Thread(producer);
//		Thread thread2 = new Thread(consumer1);
//		Thread thread3 = new Thread(consumer2);
//		Thread thread4 = new Thread(consumer3);
		
		Future<?> result = pool.submit(consumer1);
		Future<?> result1 = pool.submit(consumer2);
		Future<?> result2 = pool.submit(consumer3);
		
		thread1.start();
//		thread2.start();
//		thread3.start();
//		thread4.start();
		
	}
}

