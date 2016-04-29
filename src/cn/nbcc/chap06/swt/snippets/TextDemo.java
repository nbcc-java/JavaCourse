/**
 * 所属包：cn.nbcc.chap06.swt.snippets
 * 文件名：TextDemo.java
 * 创建者：郑哲
 * 创建时间：2014-6-3 下午10:06:04
 */
package cn.nbcc.chap06.swt.snippets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;
public class TextDemo {
	public static void main(String[] args) {
		Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("我的窗口");

		shell.setLayout(new FillLayout());
		Text text = new Text(shell, SWT.MULTI);
		text.addVerifyListener(new VerifyListener() {
			@Override
			public void verifyText(VerifyEvent e) {
				e.doit = Character.isDigit(e.text.charAt(0))||e.text.length()==0;
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


