/**
 * 所属包：cn.nbcc.chap02.snippets
 * 文件名：BooleanDemo.java
 * 创建者：郑哲
 * 创建时间：2014-1-28 上午12:12:47
 */
package cn.nbcc.chap02.snippets;
public class BooleanDemo {
	public static void main(String[] args) {
		boolean t = true;
		System.out.println("t 的值是 " + t);
		int x = 2;
		boolean y = (x > 2);
		System.out.println("y 的值是 " + y);
		x = x + 1;
		y = (x > 2);
		System.out.println("在x加1以后，y是" + y);
		// y = x; // 不能编译!
	}
}
