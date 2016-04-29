/**
 * 所属包：cn.nbcc.chap06.swt.snippets
 * 文件名：ButtonClickDemo.java
 * 创建者：郑哲
 * 创建时间：2015-6-8 下午06:56:09
 */
package cn.nbcc.chap06.swt.snippets;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.*;

public class ButtonClickAnonymousDemo {
	public static void main(String[] args) {
		Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(177, 89);
		shell.setText("ButtonClickDemo");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Button button = new Button(shell, SWT.NONE);
		button.setText("按钮");
//		button.addSelectionListener(new SelectionListener() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				MessageDialog.openConfirm(null, "Info", "Button Clicked!");
//			}
//			@Override
//			public void widgetDefaultSelected(SelectionEvent e) {
//				// TODO Auto-generated method stub
//			}
//		});
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openConfirm(shell, "Info", "Button Clicked");
			}
		});
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}

