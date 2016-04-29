/**
 * 所属包：cn.nbcc.chap05.snippets
 * 文件名：Circle.java
 * 创建者：郑哲
 * 创建时间：2014-5-7 上午10:50:42
 */
package cn.nbcc.chap05.snippets;
public class Circle extends Point{
	private int radius; //半径
	public Circle(int x, int y) {
		super(x, y);
	}
	
	public Circle(int x,int y,int r)
	{
		this(x,y);//super语句 调用父类的相应构造方法，必须作为第一条语句
		//this语句 调用同名重载的构造方法，也必须作为第一条语句
		radius = r;
	}
	@Override
	public String toString() {
		//通过"super.父类方法"格式，来复用父类的相关方法
		return String.format("%s,r=%d", super.toString(),radius);
	}


}

