/**
 * 所属包：cn.nbcc.chap03.snippets
 * 文件名：MethodDemo.java
 * 创建者：郑哲
 * 创建时间：2014-2-7 下午12:48:00
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

