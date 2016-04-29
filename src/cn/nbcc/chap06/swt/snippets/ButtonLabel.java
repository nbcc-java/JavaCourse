package cn.nbcc.chap06.swt.snippets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
public class ButtonLabel {
	public static void main(String[] args) {
		Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("�ҵĴ���");

		shell.setLayout(new RowLayout());
		Label label = new Label(shell, SWT.CENTER);
		label.setText("Welcome to GUI Programming!!!");
		Color red = new Color(display, 255, 0, 0);
		label.setForeground(red);
		final Button button = new Button(shell, SWT.PUSH);
		button.setText("������");
		button.addSelectionListener(new SelectionAdapter(){//����
			@Override
			public void widgetSelected(SelectionEvent e) {
				button.setText("�ұ�������");
				shell.layout();
//				MessageDialog.openError(shell, "��ʾ","�ұ�������");ȡ������ע�Ͳ鿴Ч��
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
