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
		System.out.println("ִ�в���...");
		try {
			sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("�ȴ��������ﵽ��׼...");
		
		try {
			this.countDownLatch.await();
			System.out.println("��������ɣ�����ִ��...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
