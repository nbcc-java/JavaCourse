/**
 * ��������cn.nbcc.chap02.snippets
 * �ļ�����StringDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-1-28 ����12:44:39
 */
package cn.nbcc.chap02.snippets;
public class StringDemo {
	public static void main(String[] args) {
		String first = "zheng", last = "zhe";
		String name = first + " " + last;
		System.out.println("Name =" + name);
		double pi = 3.14159;
		String s = "Hello," + first;
		System.out.println(s + pi + 7);// �������������ʲô��
		System.out.println(pi + 7 + s);// ���������������ʲô��
	}
}
