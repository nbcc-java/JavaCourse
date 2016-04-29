/**
 * 所属包：cn.nbcc.chap02.snippets
 * 文件名：ArithmeticDemo.java
 * 创建者：郑哲
 * 创建时间：2014-1-28 上午01:06:38
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
