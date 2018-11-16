package HomeWork2;

public class Homework2 {
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2(t1);
		t2.start();
		t1.start();
	}
	
}

class Thread1 extends Thread{
	@Override
	public void run() {
		for(int i=1;i<=26;i++) {
			System.out.print((char)(96+i)+" ");
			if(i == 14) {
				yield();
			}
			try {
				sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Thread2 extends Thread{
	Thread t1 = null;
	public Thread2(Thread1 t1) {
		this.t1 = t1;
	}
	@Override
	public void run() {
		for(int i=1;i<=26;i++) {
			System.out.print(i+" ");
			if(i == 20) {
				try {
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
