/**
 * 所属包：cn.nbcc.chap05.snippets
 * 文件名：Point.java
 * 创建者：郑哲
 * 创建时间：2014-5-7 上午10:45:57
 */
package cn.nbcc.chap05.snippets;
public class Point {
	
	private int x;
	private int y;
	
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return String.format("x=%d,y=%d", x,y);
	}

}

