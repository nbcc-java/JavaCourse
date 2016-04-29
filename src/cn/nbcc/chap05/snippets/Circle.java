/**
 * ��������cn.nbcc.chap05.snippets
 * �ļ�����Circle.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-7 ����10:50:42
 */
package cn.nbcc.chap05.snippets;
public class Circle extends Point{
	private int radius; //�뾶
	public Circle(int x, int y) {
		super(x, y);
	}
	
	public Circle(int x,int y,int r)
	{
		this(x,y);//super��� ���ø������Ӧ���췽����������Ϊ��һ�����
		//this��� ����ͬ�����صĹ��췽����Ҳ������Ϊ��һ�����
		radius = r;
	}
	@Override
	public String toString() {
		//ͨ��"super.���෽��"��ʽ�������ø������ط���
		return String.format("%s,r=%d", super.toString(),radius);
	}


}

