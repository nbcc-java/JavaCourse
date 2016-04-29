package cn.nbcc.chap06.swt.snippets;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class MenuDemo {

	public static void main(String[] args) {
		Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("MenuDemo");

		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		MenuItem fileMenu = new MenuItem(menu, SWT.CASCADE);
		fileMenu.setText("&File");//&的作用是添加菜单栏快捷键<Alt+F>调用该菜单

		Menu subMenu = new Menu(shell, SWT.DROP_DOWN);
		fileMenu.setMenu(subMenu);

		MenuItem selectItem = new MenuItem(subMenu, SWT.NONE);
		selectItem.setText("Selected Item");
		selectItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("I was Clicked");
			}
		});

		// 创建右键菜单
		Menu popMenu = new Menu(shell, SWT.POP_UP);
		shell.setMenu(popMenu);
		for (int i = 1; i <= 3; i++) {
			MenuItem item = new MenuItem(popMenu, SWT.PUSH);
			item.setText("item" + i);
			item.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					MessageDialog.openInformation(shell, "info",
							((MenuItem) e.getSource()).getText());
				}

			});
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
