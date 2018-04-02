package mutliThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class A implements Runnable {

	private Condition condition1;
	private Condition condition2;
	private Lock lock;
	public A (Lock lock, Condition condition1, Condition condition2) {
		this.condition1 = condition1;
		this.condition2 = condition2;
		this.lock = lock;
	}
	@Override
	public void run() {
		try {
			lock.lock();
			while (true) {
				System.out.println("A");
				condition1.signalAll();
				try {
					condition2.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} finally {
			lock.unlock();
			// TODO: handle finally clause
		}
	}
}

class B implements Runnable {

	private Condition condition1;
	private Condition condition2;
	private Lock lock;
	public B (Lock lock, Condition condition1, Condition condition2) {
		this.condition1 = condition1;
		this.condition2 = condition2;
		this.lock = lock;
	}
	@Override
	public void run() {
		try {
			lock.lock();
			while (true) {
				System.out.println("B");
				condition2.signalAll();
				try {
					condition1.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} finally {
			lock.unlock();
			// TODO: handle finally clause
		}
	}
}


public class ABA {
	static Lock lock = new ReentrantLock();
	static Condition conditionA = lock.newCondition();
	static Condition conditionB = lock.newCondition();
	public static void main(String[] args) {
		A a = new A(lock, conditionA, conditionB);
		B b = new B(lock, conditionA, conditionB);
		Thread threadA = new Thread(a);
		Thread threadB = new Thread(b);
		threadA.start();
		threadB.start();
	}
}
