/**
 * 所属包：cn.nbcc.chap04.snippets
 * 文件名：American.java
 * 创建者：郑哲
 * 创建时间：2014-5-5 上午10:38:37
 */
package cn.nbcc.chap04.snippets;
public class American implements ISpeakable {

	/* (non-Javadoc)
	 * @see cn.nbcc.chap04.snippets.ISpeakable#speak()
	 */
	@Override
	public void speak() {
		System.out.println("美国人说英语");

	}

}

