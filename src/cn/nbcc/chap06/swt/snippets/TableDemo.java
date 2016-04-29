package cn.nbcc.chap06.swt.snippets;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;


public class TableDemo {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		String COLUMN_NAMES[] = {"NAME","AGE","MAJOR"};
		int COLUMN_WIDTHS[]= {100,120,100};
		shell.setLayout(new GridLayout(2, false));
		
		final Table table = new Table(shell, SWT.CHECK|SWT.SINGLE|SWT.BORDER|SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
					MessageDialog.openConfirm(shell, "пео╒",table.getSelection()[0].getText());
				
			}
		});
		
		for (int i = 0; i < COLUMN_WIDTHS.length; i++) {
			TableColumn tableColumn = new TableColumn(table, SWT.NONE);
			tableColumn.setText(COLUMN_NAMES[i]);
			tableColumn.setWidth(COLUMN_WIDTHS[i]);
		}
		{
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(new String[]{"Joe","24","Computer"});
		}
		{
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(new String[]{"Michael","24","Computer"});
		}
		{
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(new String[]{"Eric","24","Computer"});
		}
		{
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(new String[]{"John","24","Computer"});
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					for (TableItem tableItem : table.getItems()) {
						tableItem.setChecked(true);
					}
				}
			});
			button.setText("\u5168\u9009");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					for (TableItem tableItem : table.getItems()) {
						tableItem.setChecked(false);
					}
				}
			});
			button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			button.setText("\u53D6\u6D88\u5168\u9009");
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
