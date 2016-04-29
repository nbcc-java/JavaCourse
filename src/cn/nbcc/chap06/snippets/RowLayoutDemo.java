/**
 * 所属包：cn.nbcc.chap06.snippets
 * 文件名：FillLayoutDemo.java
 * 创建者：郑哲
 * 创建时间：Mar 13, 2014 11:28:05 AM
 */
package cn.nbcc.chap06.snippets;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class RowLayoutDemo {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Row Layout");
		RowLayout rowLayout = new RowLayout();
		rowLayout.type = SWT.VERTICAL;
		shell.setLayout(rowLayout);
		for (int i = 0; i < 15; i++) {
			Button b = new Button(shell,SWT.NONE);
			b.setText(""+i);
		}
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}

