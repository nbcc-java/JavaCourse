/**
 * ��������cn.nbcc.chap04.snippets
 * �ļ�����App4.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-5 ����09:23:38
 */
package cn.nbcc.chap04.snippets;
public class App4 {
	
	public static int sum(int... numbers){
		int sum = 0;
		
		for (int number : numbers) {
			sum+=number;
		}
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(App4.sum(1,2,3));

	}

}

