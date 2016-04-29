/**
 * 所属包：cn.nbcc.chap06.snippets
 * 文件名：StudentListener.java
 * 创建者：郑哲
 * 创建时间：2014-5-19 上午11:25:10
 */
package cn.nbcc.chap06.snippets;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class StudentListener implements SelectionListener {

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {
		
		System.out.println("学生听得按钮被按下时，吓了一跳");

	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetDefaultSelected(SelectionEvent e) {

	}

}

