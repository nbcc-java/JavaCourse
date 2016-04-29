/**
 * ��������cn.nbcc.chap06.swt.snippets
 * �ļ�����ButtonClickDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2015-6-8 ����06:56:09
 */
package cn.nbcc.chap06.swt.snippets;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ButtonClickDemo {
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(177, 89);
		shell.setText("ButtonClickDemo");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Button button = new Button(shell, SWT.NONE);
		button.setText("��ť");
		button.addSelectionListener(new ButtonListener());

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}

