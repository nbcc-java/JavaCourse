/**
 * 所属包：cn.nbcc.chap05.snippets
 * 文件名：Scorer.java
 * 创建者：郑哲
 * 创建时间：2014-2-11 下午08:09:46
 */
package cn.nbcc.chap05.snippets;
public class Scorer {
	public int score(String input) {
		return Integer.parseInt(input);
	}
	public static void main(String[] args) {
		Scorer scorer = new Scorer();
		int ret=0;
		try {
			ret = scorer.score("12");
			System.out.println(ret);
			ret = scorer.score("aa");
			System.out.println(ret);
		} catch (NumberFormatException e) {
			System.out.println("无效输入"+e.getMessage());
		}		
	}
}

