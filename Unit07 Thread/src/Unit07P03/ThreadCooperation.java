package Unit07P03;

import java.util.concurrent.*;

public class ThreadCooperation {
	private static Account account = new Account();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new DepositTask());
		executor.execute(new WithdrawTask());
		executor.shutdown();

		System.out.println("Deopist Task\t\tWithdraw Task\t\tBalance");
	}

	// A task for adding an amount to the account
	public static class DepositTask implements Runnable {
		public void run() {
			while (true) {
				account.deposit((int) (Math.random() * 10) + 1);
				try { // Purposely delay it to let the withdraw method proceed
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	// A task for subtracting an amount from the account
	public static class WithdrawTask implements Runnable {
		public void run() {
			while (true) {
				account.withdraw((int) (Math.random() * 10) + 1);
			}
		}
	}

	// An inner class for account
	public static class Account {
		private int balance = 0;

		public int getBalance() {
			return balance;
		}

		public synchronized void deposit(int amount) {
			balance += amount;
			System.out.println("Deposit " + amount + "\t\t\t\t\t"
					+ getBalance());
			notifyAll();
		}
		
		public void deposit1(int amount) {
			synchronized(this){ //锁定了this对象，两个deposit函数作用一样。
				this.balance += amount;
				System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());
				notifyAll();
			}
		}

		public synchronized void withdraw(int amount) {
			try {
				while (balance < amount)
					wait();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

			balance -= amount;
			System.out.println("\t\t\tWithdraw " + amount + "\t\t"
					+ getBalance());
		}
	}
}
