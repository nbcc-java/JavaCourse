/**
 * ��������cn.nbcc.chap04.snippets
 * �ļ�����Rectangle.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-2 ����10:38:56
 */
package cn.nbcc.chap04.snippets;
public class Rectangle extends Shape{
	private int width;
	private int height;
	
	public Rectangle(int width,int height){
		this.width=width;
		this.height=height;
	}
	@Override
	public double getArea() {
		return width*height;
	}
	@Override
	public double getPerimeter() {
		return 2*(width+height);
	}

	public Rectangle() {
	}

}

