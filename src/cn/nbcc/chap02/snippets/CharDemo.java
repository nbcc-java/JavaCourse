/**
 * 所属包：cn.nbcc.chap02.snippets
 * 文件名：CharDemo.java
 * 创建者：郑哲
 * 创建时间：2014-1-28 上午12:18:29
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
