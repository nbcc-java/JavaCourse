/**
 * ��������cn.nbcc.chap02.snippets
 * �ļ�����ShiftDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-3 ����09:43:04
 */
package cn.nbcc.chap02.snippets;
public class ShiftDemo {

	public static void main(String[] args) {
		byte b = 11;
		System.out.println(b << 1); //����1λ
		System.out.println(b >> 1); //����������1λ
		System.out.println(b >>> 1);//������������1λ
		byte c = -10;
		System.out.println(c << 3); //����3λ
		System.out.println(c >> 1); //����������1λ
		System.out.println(c >>> 1);

	}

}

