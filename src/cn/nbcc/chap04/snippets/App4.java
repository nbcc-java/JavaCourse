/**
 * 所属包：cn.nbcc.chap04.snippets
 * 文件名：App4.java
 * 创建者：郑哲
 * 创建时间：2014-5-5 上午09:23:38
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

