/**
 * ��������cn.nbcc.chap02.snippets
 * �ļ�����BreakDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-4 ����12:46:05
 */
package cn.nbcc.chap02.snippets;
public class BreakDemo {
	public static void main(String[] args) {
		// ��ʾbreak��ʹ��
		int count;
		for (count = 1; count <= 10; count++) { // ѭ��10��
			if (count == 5) // ���count����5
				break; // ����ѭ��
			System.out.println(count);
		} // end for
		System.out.println("ʹ��Broke����ѭ��ʱcount = " + count);
	}
}
