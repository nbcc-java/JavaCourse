/**
 * 所属包：cn.nbcc.chap04.snippets
 * 文件名：Apple.java
 * 创建者：郑哲
 * 创建时间：2014-5-5 上午10:59:16
 */
package cn.nbcc.chap04.snippets;
public class Apple implements IEatable {

	/* (non-Javadoc)
	 * @see cn.nbcc.chap04.snippets.IEatable#eatMethod()
	 */
	@Override
	public String eatMethod() {
		return "削皮了吃";

	}

}

