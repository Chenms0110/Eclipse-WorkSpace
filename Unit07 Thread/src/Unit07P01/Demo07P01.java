package Unit07P01;


//�̳߳��˽⼴�ɡ�


public class Demo07P01 {

	int[] x = {3,4,2,1};      //���߳��������ԣ�sleep˯������δ���ܳɹ�������30,40�������á�	
	//˯�����򷽷��������ĸ��̣߳�ÿ���̶߳���Ӧ��sleep��Ԫ�أ���Ȼ�������̺߳�����Ӧ�������������
	
	public static void main(String[] args)throws InterruptedException{
		Thread2 t2 = new Thread2();
		Thread1 t1 = new Thread1(t2);
		//new Thread(t2).start();  //t2ʵ����Runnable�ӿڣ�û��extends Thread ��û��start()����������Ҫ��ôstart��
		t1.start();
		t2.start();
		Thread.sleep(10);  //ֻ˯�ߵ�ǰ�̣߳�������˯�����̡߳�
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
			//��������5��Hello World֮�������ģ������5����
			//���Կ�����sleep͵����i==4��sleep��100000����
			//��ʵ�鲻��ʹ�ã����ǿ��Կ���yield()�����������ʱ�򣬵�ǰ�߳̾ͻ���ִͣ�У�����Դ�ø��������̣�������������߳̾Ͳ�ִ���ˣ���JVM�жϡ�
			
			System.out.println("11111111111111");
			if(i == 4) {
				try {
					t2.join();
					//new Thread(t2).join();
					//t2.x.join(); //����ʹ
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //Ϊ��ʹ��t2�������������캯����
			}
			
			try {
				sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			if(i == 4) {
				Thread.yield(); //��д���������ʵ�����5��Hello World������������ģ��������sleepɾ��Ҳ���С�
				//��Thread2�е�sleepɾ��Ҳ���С�Thread1��2�е�sleepȫɾ��Ҳ���С�
				//��sleepȫɾ�ˣ�Ȼ��main��startλ�û�λ��
				//���ǵ����������ǣ��ڵ�����helloworld֮ǰ������222�����ϡ���ʹ��10��22222��10��Hellowworld Ҳ�Ƿ��������ġ�
				//����ֻ�ܿ���ĳЩ���һ����˭˭˭֮ǰ�����������������һ��Hello World���������2�����ӵĿ��ơ�
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
				Thread.yield(); //���Ч�����������֮��Ͱ���Դ�ø������߳��ˣ�����ʹ����ˡ�����2���ڵ�����HelloWorld֮ǰ�������Ҫ��
				//����yield������ֻ���Ǹ�JVM���������ó���Դ�������ܾ�����˭֮����ɡ�
				//����join()��
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