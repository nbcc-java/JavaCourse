/**
 * ��������cn.nbcc.chap02.snippets
 * �ļ�����NestedLoopDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-4 ����12:50:34
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
