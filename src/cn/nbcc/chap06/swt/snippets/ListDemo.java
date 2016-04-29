/**
 * 所属包：cn.nbcc.chap06.swt.snippets
 * 文件名：ListDemo.java
 * 创建者：郑哲
 * 创建时间：2014-6-3 下午10:37:25
 */
package cn.nbcc.chap06.swt.snippets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

public class ListDemo {
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("List Demo");
		shell.setLayout(new FillLayout());
		final List list = new List(shell, SWT.SINGLE);
		list.setItems(new String[]{"First","Second","Third"});
		list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] selected = list.getSelection();
				if (selected.length>0) {
					System.out.println("Selected:"+selected[0]);
				}
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

