package mutliThread;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	public static void main(String[] args) {

		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
			
			@Override
			public void run() {
				System.out.println("---���������ִ�е�����---");
			}
		});
		
		new CyclicBarrierThread("A", cyclicBarrier).start();
		new CyclicBarrierThread("B", cyclicBarrier).start();
		new CyclicBarrierThread("C", cyclicBarrier).start();
		
		new CyclicBarrierThread("A", cyclicBarrier).start();
		new CyclicBarrierThread("B", cyclicBarrier).start();
		new CyclicBarrierThread("C", cyclicBarrier).start();
	}

}
