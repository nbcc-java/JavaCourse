/**
 * ��������cn.nbcc.chap02.snippets
 * �ļ�����ArithmeticDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-1-28 ����01:06:38
 */
package cn.nbcc.chap02.snippets;
public class ArithmeticDemo {
	public static void main(String[] args) {
		System.out.println(5 + 4 * 6 / 3 - 2);
		System.out.println((5 + 4) * 6 / (3 - 2));
		int x = 5, y, z;
		y = x++;
		System.out.println("x = " + x + " y = " + y);
		x = 5;
		z = ++x;
		System.out.println("x = " + x + " z = " + z);
		int m = 15 % 4;
		System.out.println("m = " + m);
		m = 29;
		System.out.println("m << 2 = " + (m >> 2));
		double d = 5.0;
		d *= 4.0;
		System.out.println("d = " + d);
		System.out.println("Ternary: " + (x == 5 ? "yes" : "no"));
	}
}
