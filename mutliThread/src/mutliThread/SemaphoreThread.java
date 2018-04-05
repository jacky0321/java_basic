package mutliThread;

import java.util.concurrent.Semaphore;

public class SemaphoreThread extends Thread {

	public Semaphore semaphore;

	/**
	 * @param name
	 * @param semaphore
	 */
	public SemaphoreThread(String name, Semaphore semaphore) {
		setName(name);
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			// this.semaphore.acquire();
			System.out.println(getName() + "��ȡ�ź�..." + System.currentTimeMillis());
			sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.semaphore.release();
			System.out.println(getName() + "�ͷ��ź�..." + System.currentTimeMillis());
		}

	}
}
