package cn.nbcc.chap04.snippets;
public class Circle extends Shape {
	
	private int radius;
	
	public Circle(int radius) {
		this.radius = radius;
	}
	
	@Override//方法的覆盖
	public double getArea() {
		return Math.PI*radius*radius;
	}
	@Override//方法的覆盖
	public double getPerimeter() {
		return 2*Math.PI*radius;
	}

}

