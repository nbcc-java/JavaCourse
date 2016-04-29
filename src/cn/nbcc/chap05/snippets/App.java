/**
 * 所属包：cn.nbcc.chap05.snippets
 * 文件名：App.java
 * 创建者：郑哲
 * 创建时间：2014-5-7 上午10:11:59
 */
package cn.nbcc.chap05.snippets;
public class App {
	public static void main(String[] args) {
		Point p1 = new Point(100, 20);
		System.out.println(p1);
		
		Circle c1 = new Circle(100, 20,5);
		System.out.println(c1);
		
		Cylinder cy1  = new Cylinder(100, 20, 5,10);
		System.out.println(cy1);
	}

}

