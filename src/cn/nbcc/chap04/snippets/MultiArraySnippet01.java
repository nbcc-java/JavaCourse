/**
 * 所属包：cn.nbcc.chap04.snippets
 * 文件名：MultiArraySnippet01.java
 * 创建者：郑哲
 * 创建时间：2014-2-8 下午12:04:09
 */
package cn.nbcc.chap04.snippets;

public class MultiArraySnippet01 {

	public static void main(String[] args) {
		System.out.println("Instantiating a double array");
		int[][] mutliArray = new int[10][12];
		System.out.println("填充二维数组");
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 12; col++) {
				mutliArray[row][col] = row + col;
			}
		}
		System.out.println("显示每一个数组中的元素");
		for (int row = 0; row < mutliArray.length; row++) {
			for (int col = 0; col < mutliArray[row].length; col++) {
				System.out.print(mutliArray[row][col] + "\t");
			}
			System.out.println();
		}
	}
}
