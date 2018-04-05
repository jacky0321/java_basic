package mutliThread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchThread extends Thread{

	private CountDownLatch countDownLatch;
	
	public CountDownLatchThread(String name, CountDownLatch countDownLatch) {
		setName(name);
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		System.out.println("执行操作...");
		try {
			sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("等待计数器达到标准...");
		
		try {
			this.countDownLatch.await();
			System.out.println("计数器达成，继续执行...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
