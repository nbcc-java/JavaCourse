/**
 * ��������cn.nbcc.chap02.snippets
 * �ļ�����ContinueDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-4 ����12:48:12
 */
package cn.nbcc.chap02.snippets;
public class ContinueDemo {
	public static void main(String[] args) {
		// continueʹ��ʾ��.
		for (int count = 1; count <= 10; count++) { // ѭ��10��
			if (count == 5)// ���count����5
				continue;// ����ѭ���е�ʣ����룬ֱ��ת����һ�θ�������
			System.out.println(count);
		}// end for
	}
}
