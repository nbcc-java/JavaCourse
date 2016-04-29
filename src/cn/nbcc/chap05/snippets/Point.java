/**
 * ��������cn.nbcc.chap05.snippets
 * �ļ�����Point.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-7 ����10:45:57
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

