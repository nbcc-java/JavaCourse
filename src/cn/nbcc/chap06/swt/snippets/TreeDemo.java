package cn.nbcc.chap06.swt.snippets;

import java.util.Iterator;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;


public class TreeDemo {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TreeDemo window = new TreeDemo();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		shell.setLayout(new FillLayout());
		final Tree tree = new Tree(shell, SWT.SINGLE|SWT.CHECK);
		
		tree.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				TreeItem[] selected = tree.getSelection();
				MessageDialog.openConfirm(shell, "пео╒", selected[0].getText());
				
			}
		});
		tree.setLinesVisible(true);
		for (int i = 1; i < 4; i++) {
			TreeItem grandItem   = new TreeItem(tree, SWT.NONE);
			grandItem.setText("Grand Parent"+i);
			for (int j = 1; j < 4; j++) {
				TreeItem parent = new TreeItem(grandItem,SWT.NONE);
				parent.setText("Parent"+j);
				for (int k = 1; k < 4; k++) {
					TreeItem child = new TreeItem(parent,SWT.NONE);
					child.setText("child"+k);
				}
			}
			
		}

	}

}
