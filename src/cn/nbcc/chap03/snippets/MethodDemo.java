/**
 * ��������cn.nbcc.chap03.snippets
 * �ļ�����MethodDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-7 ����12:48:00
 */
package cn.nbcc.chap03.snippets;
public class MethodDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int ret=0;
		ret = max(1,3);
		System.out.println(ret);
	}

	public static int max(int num1, int num2) {
		int result;
		if (num1 > num2)
			result = num1;
		else
			result = num2;
		return result;
	}
}

