/**
 * ��������cn.nbcc.chap04.snippets
 * �ļ�����ArraysSnippets01.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-8 ����12:31:38
 */
package cn.nbcc.chap04.snippets;

import java.util.Arrays;

public class ArraysSnippets01 {
	public static void main(String[] args) {
		int [] a = {1,2,3};
		int [] b = {1,2,3};
		System.out.println(a==b);
		System.out.println(a.equals(b));
		System.out.println(Arrays.equals(a, b));
	}

}

