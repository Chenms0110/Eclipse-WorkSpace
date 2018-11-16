package Unit07P01;


//线程池了解即可。


public class Demo07P01 {

	int[] x = {3,4,2,1};      //用线程排序试试，sleep睡眠排序未必能成功，若是30,40……还好。	
	//睡眠排序方法：创建四个线程，每个线程都对应数sleep（元素）。然后把这个线程和它对应的数输出出来。
	
	public static void main(String[] args)throws InterruptedException{
		Thread2 t2 = new Thread2();
		Thread1 t1 = new Thread1(t2);
		//new Thread(t2).start();  //t2实现了Runnable接口，没有extends Thread 。没有start()函数，所以要这么start。
		t1.start();
		t2.start();
		Thread.sleep(10);  //只睡眠当前线程，这里是睡眠主线程。
		System.out.println("________________________");
		
		
	}
}

class Thread1 extends Thread {
	
	Thread2 t2 = null;
	public Thread1(Thread2 t2) {
		this.t2=t2;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			//System.out.println("Hello World");
			//如何先输出5个Hello World之后，输出别的，再输出5个？
			//可以考虑用sleep偷懒：i==4后，sleep（100000）；
			//但实验不让使用，我们可以考虑yield()，调用这个的时候，当前线程就会暂停执行，将资源让给其他进程，但不代表这个线程就不执行了，由JVM判断。
			
			System.out.println("11111111111111");
			if(i == 4) {
				try {
					t2.join();
					//new Thread(t2).join();
					//t2.x.join(); //不好使
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //为了使用t2，在这里搞个构造函数。
			}
			
			try {
				sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			if(i == 4) {
				Thread.yield(); //单写这个，不能实现输出5个Hello World后输出完其他的，将下面的sleep删了也不行。
				//将Thread2中的sleep删除也不行。Thread1和2中的sleep全删了也不行。
				//将sleep全删了，然后将main中start位置换位。
				//我们的现在条件是，在第六个helloworld之前，所有222输出完毕。即使先10个22222再10个Hellowworld 也是符合条件的。
				//我们只能控制某些输出一定在谁谁谁之前，不能做到如先输出一个Hello World再输出所有2这样子的控制。
			}
			/*
			try {
			sleep(1);
			}
			catch(InterruptedException e) {
				//TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		}
	}
}

class Thread2 extends Thread{
	public Thread x = new Thread() {
		@Override
		public void run() {
			//nothing
		}
	};
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("222222222222222222");
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*
			if(i==1) {
				Thread.yield(); //这个效果是输出两次之后就把资源让给其他线程了，但这就打破了“所有2都在第六个HelloWorld之前输出”的要求。
				//对于yield，我们只能是给JVM发送请求，让出资源，而不能决定在谁之后完成。
				//考虑join()。
			}
			/*
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		}
	}
}