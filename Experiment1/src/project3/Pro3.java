package project3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import java.util.AbstractList;

public class Pro3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("请输入两个数，输入0退出");
			int n1 = input.nextInt(); 	//第一个数
			if(n1 == 0) {				//如果为0，退出循环
				break;
			}
			int n2 = input.nextInt(); 	//得到第二个数
			if(n1<=0||n2<=0) {
				System.out.println("输入不能为非正数");
			}
			else {
				System.out.println(n1+"与"+n2+"的最小公倍数是："+getLCM(n1,n2));
			}
		}
		System.out.println(getLCM(120,150));
		System.out.println(getLCM(7,14));
		System.out.println(getLCM(7,8));
		System.out.println(getLCM(1,2));
		System.out.println(getLCM(345,455));
	}
	
	public static  int[][] getPrimeFactors(int number) {		
		ArrayList<Integer> h = new ArrayList<Integer>(); //存素数因子
		ArrayList<Integer> j = new ArrayList<Integer>(); //存出现次数
		//一一对应
		
		int temp = 0;
		int num;
		for(int i=2;i<number+1;i++){
			if(0==number%i) {
				num = 0;
				while(0==number%i){
					num++;
					number/=i;
				}	
				h.add(i);
				j.add(num);
				temp++;
			}
		}
		int[][] x = new int[temp][2];
		for(int i=0;i<temp;i++) {
			x[i][0]=h.get(i);
			x[i][1]=j.get(i);
		}
		return x;
	}
	
	public static int getLCM(int n1,int n2) {     //求最小公倍数，根据两个数的素数因子及出现次数计算。
		int[][] x = getPrimeFactors(n1);
		int[][] y = getPrimeFactors(n2);
		ArrayList<Integer> h = new ArrayList<Integer>(); //存素数因子
		ArrayList<Integer> j = new ArrayList<Integer>(); //存出现次数
		
		for(int i=0;i<x.length;i++) {
			h.add(x[i][0]);
			j.add(x[i][1]);
		}    //将第一个数的素数因子和次数对应存入h和j
		
		boolean flag;  //判断当前数字是否匹配
		
		for(int i=0;i<y.length;i++) {
			flag = false;   //每个数字一开始都初始化为不匹配
			for(int k=0;k<h.size();k++) {   //与现有即将计算的数字进行比对
				if(y[i][0]==h.get(k)) {     //若匹配
					if(y[i][1]>j.get(k)) {    //比较出现次数，进行替换
						j.set(k, y[i][1]);
					}
					flag = true;          //说明当前数字有匹配
				}
			}
			
			if(!flag) {               //无匹配，则加入新的素数因子和次数
				h.add(y[i][0]);
				j.add(y[i][1]);
			}
		}
		int LCM = 1;
		int temp;
		for(int i=0;i<h.size();i++) {      //将数组里所有元素根据次数相乘，最后得出结果
			temp = h.get(i);
			for(int k=0;k<j.get(i)-1;k++) {
				temp*=h.get(i);
			}
			LCM*=temp;
		}
		return LCM;
	}
	
}

