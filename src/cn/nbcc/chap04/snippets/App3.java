/**
 * ��������cn.nbcc.chap04.snippets
 * �ļ�����App3.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-2 ����11:35:17
 */
package cn.nbcc.chap04.snippets;
public class App3 {
	public static void main(String[] args) {
		Shape s[] = {
				new Circle(3),
				new Rectangle(2, 5),
				new Circle(5),
				new Rectangle(3, 4)
		};//�����಻��ʵ����
		
		
		for (int i = 0; i < s.length; i++) {
			Shape shape = s[i];
			System.out.println(shape.getArea());
			System.out.println(shape.getPerimeter());
		}

	}

}

