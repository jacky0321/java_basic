package mutliThread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(3);
		CountDownLatchThread testA = new CountDownLatchThread("A", countDownLatch);
		CountDownLatchThread testB = new CountDownLatchThread("B", countDownLatch);
		CountDownLatchThread testC = new CountDownLatchThread("C", countDownLatch);
		CountDownLatchThread testD = new CountDownLatchThread("D", countDownLatch);
		CountDownLatchThread testE = new CountDownLatchThread("E", countDownLatch);
		CountDownLatchThread testF = new CountDownLatchThread("F", countDownLatch);
		
		testA.start();
		testB.start();
		testC.start();
		testD.start();
		testE.start();
		testF.start();
		
		for(int i = 3; i > 0; i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("countDownLatch " + i);
			countDownLatch.countDown();
		}
	}

}
