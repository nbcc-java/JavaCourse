/**
 * ��������cn.nbcc.chap04.snippets
 * �ļ�����MultiArraySnippet01.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-8 ����12:04:09
 */
package cn.nbcc.chap04.snippets;

public class MultiArraySnippet01 {

	public static void main(String[] args) {
		System.out.println("Instantiating a double array");
		int[][] mutliArray = new int[10][12];
		System.out.println("����ά����");
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 12; col++) {
				mutliArray[row][col] = row + col;
			}
		}
		System.out.println("��ʾÿһ�������е�Ԫ��");
		for (int row = 0; row < mutliArray.length; row++) {
			for (int col = 0; col < mutliArray[row].length; col++) {
				System.out.print(mutliArray[row][col] + "\t");
			}
			System.out.println();
		}
	}
}
