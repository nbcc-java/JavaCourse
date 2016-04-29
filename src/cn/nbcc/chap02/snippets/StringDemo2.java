/**
 * 所属包：cn.nbcc.chap02.snippets
 * 文件名：StringDemo2.java
 * 创建者：郑哲
 * 创建时间：2014-1-28 上午12:58:49
 */
package cn.nbcc.chap02.snippets;

public class StringDemo2 {

	public static void main(String[] args) {
		//字符串使用示例
		String s1, s2;
		s1 = s2 = "helloworld";
		System.out.println("改变前S1:" + s1);
		System.out.println("改变前S2:" + s2);
		s1 += "this is";
		System.out.println("改变后S1:" + s1);
		System.out.println("改变后S2:" + s2);
	}

}
