/**
 * 所属包：cn.nbcc.chap06.snippets
 * 文件名：FillLayoutDemo.java
 * 创建者：郑哲
 * 创建时间：Mar 13, 2014 11:28:05 AM
 */
package cn.nbcc.chap06.snippets;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class FillLayoutDemo {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Fill Layout");
		FillLayout fillLayout = new FillLayout();
//		fillLayout.type = SWT.VERTICAL;
		shell.setLayout(fillLayout);
		
		
		for (int i = 0; i < 10; i++) {
			Button b = new Button(shell,SWT.PUSH);
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

