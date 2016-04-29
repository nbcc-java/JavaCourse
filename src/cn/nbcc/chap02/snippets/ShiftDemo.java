/**
 * 所属包：cn.nbcc.chap02.snippets
 * 文件名：ShiftDemo.java
 * 创建者：郑哲
 * 创建时间：2014-2-3 下午09:43:04
 */
package cn.nbcc.chap02.snippets;
public class ShiftDemo {

	public static void main(String[] args) {
		byte b = 11;
		System.out.println(b << 1); //左移1位
		System.out.println(b >> 1); //带符号右移1位
		System.out.println(b >>> 1);//不带符号右移1位
		byte c = -10;
		System.out.println(c << 3); //左移3位
		System.out.println(c >> 1); //带符号右移1位
		System.out.println(c >>> 1);

	}

}

