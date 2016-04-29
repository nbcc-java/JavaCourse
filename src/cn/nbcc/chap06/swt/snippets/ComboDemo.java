package cn.nbcc.chap06.swt.snippets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;


public class ComboDemo {

	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(234, 115);
		shell.setText("ComboDemo");
		
		
		shell.setLayout(new GridLayout(1,true));
		final Combo combo1 = new Combo(shell, SWT.READ_ONLY);
		combo1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		final Combo combo2 = new Combo(shell, SWT.DROP_DOWN);
		combo2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		final Label label = new Label(shell,SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		combo1.setItems(new String[]{"First","Second","Third"});
		combo1.setText("First");
		combo1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				label.setText("selected:"+combo1.getText());
			}
		});
		combo2.setItems(new String[]{"First","Second","Third"});
		combo2.setText("First");
		combo2.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				label.setText("Entered:"+combo2.getText());
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
