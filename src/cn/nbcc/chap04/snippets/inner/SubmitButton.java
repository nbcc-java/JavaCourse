/**
 * 所属包：cn.nbcc.chap04.snippets.inner
 * 文件名：SubmitButton.java
 * 创建者：郑哲
 * 创建时间：2016年5月8日 下午10:08:01
 */
package cn.nbcc.chap04.snippets.inner;
public class SubmitButton implements ButtonClick{
	@Override
	public void onClick() {
		System.out.println("提交表单");
	}
}

