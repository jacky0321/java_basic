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
		System.out.println("ִ�в���...");
		try {
			int time = new Random().nextInt(10)	* 1000;
			System.out.println("����" + time/1000 + "��");
			sleep(time);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			this.cyclicBarrier.await();
			System.out.println("������ɣ�����ִ��...");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
