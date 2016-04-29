/**
 * 所属包：cn.nbcc.chap02.snippets
 * 文件名：AndDemo.java
 * 创建者：郑哲
 * 创建时间：2014-2-3 下午11:09:09
 */
package cn.nbcc.chap02.snippets;

public class AndDemo {

	public static void main(String[] args) {
		int n1 = 1, n2 = 2, n3 = 3, n4 = 4;
		boolean x = true, y = true;
		boolean z = (x = n1 > n2) && (y = n3 > n4);
		System.out.println("&&: x=" + x + ",y=" + y + ",z=" + z);
		x = true;
		y = true;
		z = (x = n1 > n2) & (y = n3 > n4);
		System.out.println("&: x=" + x + ",y=" + y + ",z=" + z);
	}

}
