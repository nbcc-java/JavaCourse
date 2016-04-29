/**
 * 所属包：cn.nbcc.chap02.snippets
 * 文件名：NestedLoopDemo.java
 * 创建者：郑哲
 * 创建时间：2014-2-4 上午12:50:34
 */
package cn.nbcc.chap02.snippets;

public class NestedLoopDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char current = 'a';
		for (int row = 1; row <= 3; row++) {
			for (int column = 1; column <= 10; column++) {
				System.out.print(current + " ");
				current++;
			}
			System.out.println();
		}

	}

}
