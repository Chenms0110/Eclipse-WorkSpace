package HomeWork1;

public class Homework1 {
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();
	}
}

class Thread1 extends Thread{
	@Override
	public void run() {
		for(int i=1;i<=26;i++) {
			System.out.print((char)(96+i)+" ");
		}
	}
}

class Thread2 extends Thread{
	@Override
	public void run() {
		for(int i=1;i<=26;i++) {
			System.out.print(i+" ");
		}
	}
}