/**
 * 所属包：cn.nbcc.chap04.snippets
 * 文件名：Banana.java
 * 创建者：郑哲
 * 创建时间：2014-5-5 上午10:59:44
 */
package cn.nbcc.chap04.snippets;
public class Banana implements IEatable {

	/* (non-Javadoc)
	 * @see cn.nbcc.chap04.snippets.IEatable#eatMethod()
	 */
	@Override
	public String eatMethod() {
		
		return "剥开了吃";

	}

}

