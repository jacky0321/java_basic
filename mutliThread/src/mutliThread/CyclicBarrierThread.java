package mutliThread;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThread extends Thread{

	private CyclicBarrier cyclicBarrier;
	
	public CyclicBarrierThread(String name, CyclicBarrier cyclicBarrier) {
		setName(name);
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		System.out.println("执行操作...");
		try {
			int time = new Random().nextInt(10)	* 1000;
			System.out.println("休眠" + time/1000 + "秒");
			sleep(time);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			this.cyclicBarrier.await();
			System.out.println("计数达成，继续执行...");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
