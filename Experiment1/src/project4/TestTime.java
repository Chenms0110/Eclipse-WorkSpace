package project4;


public class TestTime {
	public static void main(String[] args) {
		Time x1 = new Time(555550000);
		Time x2 = new Time();
		
		System.out.println(x1.toString());
		System.out.println(x2.toString());
		//注：这里算出的是0时区，而我们现在是东8区，加上八小时就是我们现在的正确时间了。

	}
}
