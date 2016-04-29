/**
 * 所属包：cn.nbcc.chap04.snippets
 * 文件名：App3.java
 * 创建者：郑哲
 * 创建时间：2014-5-2 上午11:35:17
 */
package cn.nbcc.chap04.snippets;
public class App3 {
	public static void main(String[] args) {
		Shape s[] = {
				new Circle(3),
				new Rectangle(2, 5),
				new Circle(5),
				new Rectangle(3, 4)
		};//抽象类不能实例化
		
		
		for (int i = 0; i < s.length; i++) {
			Shape shape = s[i];
			System.out.println(shape.getArea());
			System.out.println(shape.getPerimeter());
		}

	}

}

