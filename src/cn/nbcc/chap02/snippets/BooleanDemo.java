/**
 * ��������cn.nbcc.chap02.snippets
 * �ļ�����BooleanDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-1-28 ����12:12:47
 */
package cn.nbcc.chap02.snippets;
public class BooleanDemo {
	public static void main(String[] args) {
		boolean t = true;
		System.out.println("t ��ֵ�� " + t);
		int x = 2;
		boolean y = (x > 2);
		System.out.println("y ��ֵ�� " + y);
		x = x + 1;
		y = (x > 2);
		System.out.println("��x��1�Ժ�y��" + y);
		// y = x; // ���ܱ���!
	}
}
