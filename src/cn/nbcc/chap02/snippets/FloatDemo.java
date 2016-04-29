/**
 * 所属包：cn.nbcc.chap02.snippets
 * 文件名：FloatDemo.java
 * 创建者：郑哲
 * 创建时间：2014-1-28 上午12:02:36
 */
package cn.nbcc.chap02.snippets;
public class FloatDemo {
	public static void main(String[] args) {
		double pi = 3.14159;
		float f = 2.7F;// 注意这里指定以float类型存储2.7
		System.out.println("pi = " + pi);
		System.out.println("f = " + f);
		int n = 15, d = 4;
		f = n / d; // f里面存储的值是什么？
		System.out.println("f的值是：" + f);
		int radius = 10;
		double area = pi * radius * radius;// area里面存储的值是什么？
		System.out.println("area = " + area);
	}// end main
}// end class

