package mutliThread;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3);
		SemaphoreThread testA = new SemaphoreThread("A", semaphore);
		SemaphoreThread testB = new SemaphoreThread("B", semaphore);
		SemaphoreThread testC = new SemaphoreThread("C", semaphore);
		SemaphoreThread testD = new SemaphoreThread("D", semaphore);
		SemaphoreThread testE = new SemaphoreThread("E", semaphore);
		SemaphoreThread testF = new SemaphoreThread("F", semaphore);
		
		testA.start();
		testB.start();
		testC.start();
		testD.start();
		testE.start();
		testF.start();
	}
}
