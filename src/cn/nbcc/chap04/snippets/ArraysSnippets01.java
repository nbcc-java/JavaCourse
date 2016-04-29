/**
 * 所属包：cn.nbcc.chap04.snippets
 * 文件名：ArraysSnippets01.java
 * 创建者：郑哲
 * 创建时间：2014-2-8 下午12:31:38
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

