/**
 * 所属包：cn.nbcc.chap02.snippets
 * 文件名：StringDemo.java
 * 创建者：郑哲
 * 创建时间：2014-1-28 上午12:44:39
 */
package cn.nbcc.chap02.snippets;
public class StringDemo {
	public static void main(String[] args) {
		String first = "zheng", last = "zhe";
		String name = first + " " + last;
		System.out.println("Name =" + name);
		double pi = 3.14159;
		String s = "Hello," + first;
		System.out.println(s + pi + 7);// 这里的输出结果是什么？
		System.out.println(pi + 7 + s);// 这里的输出结果又是什么？
	}
}
