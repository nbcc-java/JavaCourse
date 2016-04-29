/**
 * 所属包：cn.nbcc.chap02.snippets
 * 文件名：BreakDemo.java
 * 创建者：郑哲
 * 创建时间：2014-2-4 上午12:46:05
 */
package cn.nbcc.chap02.snippets;
public class BreakDemo {
	public static void main(String[] args) {
		// 显示break的使用
		int count;
		for (count = 1; count <= 10; count++) { // 循环10次
			if (count == 5) // 如果count等于5
				break; // 跳出循环
			System.out.println(count);
		} // end for
		System.out.println("使用Broke跳出循环时count = " + count);
	}
}
