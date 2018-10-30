package project4;


public class Rectangle {

	private double width = 1;
	private double height = 1;
	private String color = "White";
	
	public Rectangle() {
		width = 1;
		height = 1;
		color = "White";
	}
	
	public Rectangle(double width,double height,String color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	
	public double getArea() {
		return (double)Math.round(width*height*100)/100;  //保留两位小数
	}
	public double getPerimeter() {
		return 2*(width+height);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Width: " + width + " Height: " + height + " Color: " + color + " Area: " + getArea() + " Perimeter: " + getPerimeter();
	}
}
