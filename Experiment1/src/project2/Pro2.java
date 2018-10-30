package project2;

public class Pro2 {

	public static void main(String[] args) {
		showL();
	}
	
	public static double Single(double x) {
		return (4090.00 + (x - 29700) * 0.25);
	}
	
	public static double MFJ(double x) {
		if(x<=59400) {
			return (1460.00 + (x - 14600) * 0.15);
		}
		else {
			return (8180.00 + (x - 59400) * 0.25);
		}
	}
	
	public static double MFS(double x) {
		if(x<=59975) {
			return (4090.00 + (x - 29700) * 0.25);
		}
		else {
			return (11658.75 + (x - 59975) * 0.28);
		}
	}
	
	public static double HeadofHousehold(double x) {
		return (5447.50 + (x - 39800) * 0.25);
	}
	
	public static void showL() {
		System.out.println("___________________________________________________"
				+ "");
		System.out.println("| taxable | Single | Married | Married  | Head of |");
		System.out.println("| Income  |        | Joint   | Separate | a House |");
		System.out.println("©À©¤©¤©¤©¤©¤©¤©¤©¤©¤©à©¤©¤©¤©¤©¤©¤©¤©¤©à©¤©¤©¤©¤©¤©¤©¤©¤©¤©à©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©à©¤©¤©¤©¤©¤©¤©¤©¤©¤©È");
		for(int i=50000;i<=60000;i+=50) {
			System.out.printf("|  %d  |%8.2f|%9.2f|%10.2f|%9.2f|\n", i,Single(i),MFJ(i),MFS(i),HeadofHousehold(i));
		}
		System.out.println("©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤©¤");
	}
}
