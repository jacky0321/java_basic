package mutliThread;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Bank implements Runnable {
	private double[] accounts;
	private int accountNumber;
	private double balance;

	private Lock banklock = new ReentrantLock();

	public Bank(int number, double balance) {
		this.accountNumber = number;
		this.balance = balance;
		this.accounts = new double[number];
		Arrays.fill(this.accounts, balance);
	}

	private void sum() {
		double balance = 0;
		for (double b : this.accounts) {
			balance += b;
		}
		System.out.printf("Total balance: %10.2f\n", balance);

	}

	private void transfer() {

		banklock.lock();
		try {
			int toAccount = (int) (this.accountNumber * Math.random());
			int fromAccount = (int) (this.accountNumber * Math.random());
			double amount = this.balance * Math.random();
			this.accounts[fromAccount] -= amount;
			this.accounts[toAccount] += amount;
			System.out.println("fromAccount: " + fromAccount + " toAccount: " + toAccount + " amount " + amount);
		}

		finally {
			banklock.unlock();
		}

	}

	@Override
	public void run() {
		while (true) {
			this.transfer();
			this.sum();
		}
	}
}

public class testBank {
	public static void main(String args[]) {
		Bank bank = new Bank(3, 1000);
		Thread thread1 = new Thread(bank);
		Thread thread2 = new Thread(bank);
		Thread thread3 = new Thread(bank);

		thread1.start();
		thread2.start();
		thread3.start();
	}
}
