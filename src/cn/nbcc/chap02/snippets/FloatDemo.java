/**
 * ��������cn.nbcc.chap02.snippets
 * �ļ�����FloatDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-1-28 ����12:02:36
 */
package cn.nbcc.chap02.snippets;
public class FloatDemo {
	public static void main(String[] args) {
		double pi = 3.14159;
		float f = 2.7F;// ע������ָ����float���ʹ洢2.7
		System.out.println("pi = " + pi);
		System.out.println("f = " + f);
		int n = 15, d = 4;
		f = n / d; // f����洢��ֵ��ʲô��
		System.out.println("f��ֵ�ǣ�" + f);
		int radius = 10;
		double area = pi * radius * radius;// area����洢��ֵ��ʲô��
		System.out.println("area = " + area);
	}// end main
}// end class

