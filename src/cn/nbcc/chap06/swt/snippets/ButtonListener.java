/**
 * 所属包：cn.nbcc.chap06.swt.snippets
 * 文件名：ButtonListener.java
 * 创建者：郑哲
 * 创建时间：2015-6-8 下午06:58:28
 */
package cn.nbcc.chap06.swt.snippets;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class ButtonListener implements SelectionListener {
	@Override
	public void widgetSelected(SelectionEvent e) {
		MessageDialog.openConfirm(null, "Info", "Button Clicked!");
	}
	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
	}
}

