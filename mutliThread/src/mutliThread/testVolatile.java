package mutliThread;

class Counter1 implements Runnable {

	private static volatile boolean status = false;
	
	@Override
	public void run() {
		int initNumber = 100;
		while(! status){
			initNumber -= 1;
			System.out.println(Thread.currentThread() + " initNumber: " + initNumber);
			if(initNumber == -100){
				status = true;
				System.out.println("It's over.");
			}
		}
	}
}

public class testVolatile {
	
	private static final int THREAD_NUM = 3;
	
	public static void main(String args[]) {
		
		Counter1 counter = new Counter1();
		
		Thread[] threads = new Thread[THREAD_NUM];
		for(int i = 0; i < THREAD_NUM; i ++) {
			threads[i] = new Thread(counter);
		}
		
		for(int i = 0; i < THREAD_NUM; i ++){
			threads[i].start();
		}
	}
}

