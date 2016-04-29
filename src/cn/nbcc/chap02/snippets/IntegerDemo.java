/**
 * 所属包：cn.nbcc.chap02.snippets
 * 文件名：IntegerDemo.java
 * 创建者：郑哲
 * 创建时间：2014-1-27 下午10:56:45
 */
package cn.nbcc.chap02.snippets;
public class IntegerDemo {
	public static void main(String[] args) {
		int a=18; // 声明并初始化变量
		short x, y = 10, z = 20; // 同时声明多个变量
		x = (short) (y + z); // 这里为什么要强制转换?
		System.out.println("x的值是:" + x);
		long b = 12345678987654321L; // 常量数值后为何要加'L'字符?
		System.out.println("b的值是:" + b);
		b = a; // 自动提升现象
		byte c;
		c = (byte) a; // 强制转换
		System.out.println("c的值是:" + c);
	}// end main
}// end class

