/**
 * ��������cn.nbcc.chap02.snippets
 * �ļ�����CharDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-1-28 ����12:18:29
 */
package cn.nbcc.chap02.snippets;
public class CharDemo {
	public static void main(String[] args) {
		char a = 'A';
		char b = (char) (a + 1);
		System.out.println(a + b);
		System.out.println("a + b is " + a + b);
		int x = 75;
		char y = (char) x;
		char omega = '\u03A9';
		System.out.println("y is " + y + " omega is " + omega);
	}
}
