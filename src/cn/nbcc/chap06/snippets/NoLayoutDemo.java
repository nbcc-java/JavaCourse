/**
 * 所属包：cn.nbcc.chap06.snippets
 * 文件名：NoLayoutDemp.java
 * 创建者：郑哲
 * 创建时间：2016年5月22日 下午3:57:33
 */
package cn.nbcc.chap06.snippets;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;

public class NoLayoutDemo {
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("NoLayoutDemo");
		
		Button btnButton = new Button(shell, SWT.NONE);
		btnButton.setBounds(26, 20, 98, 30);
		btnButton.setText("button1");
		
		Button btnButton_1 = new Button(shell, SWT.NONE);
		btnButton_1.setText("button2");
		btnButton_1.setBounds(73, 40, 98, 30);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}

