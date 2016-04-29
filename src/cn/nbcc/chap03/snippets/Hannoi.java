/**
 * ��������cn.nbcc.chap03.snippets
 * �ļ�����Hannoi.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-7 ����02:17:43
 */
package cn.nbcc.chap03.snippets;
public class Hannoi {
	public static void main(String[] args) {
		int count = 4;
		tower(count,"A","B","C");
	}

	/**
	 * @param count:������Ŀ
	 * @param pole1:ԭʼλ��
	 * @param pole2���ƶ���������
	 * @param pole3��Ŀ������
	 */
	public static void tower(int count, String pole1, String pole2, String pole3) {

		if (count == 1)
			System.out.println("��" + pole1 + "�ᶯ��" + pole3 );
		else {
			tower(count - 1, pole1, pole3, pole2);
			System.out.println("��" + pole1 + "�ᶯ��" + pole3 );
			tower(count - 1, pole2, pole1, pole3);
		}
	}

}

