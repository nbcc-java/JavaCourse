/**
 * 所属包：cn.nbcc.chap06.snippets
 * 文件名：NewClassDialog.java
 * 创建者：郑哲
 * 创建时间：2015-5-12 下午04:03:01
 */
package cn.nbcc.chap06.snippets;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;

public class NewClassDialog extends TitleAreaDialog {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public NewClassDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.CLOSE | SWT.RESIZE);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(3, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label label = new Label(container, SWT.NONE);
		label.setText("New Label");
		
		text = new Text(container, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button button = new Button(container, SWT.NONE);
		button.setText("New Button");
		
		Label label_1 = new Label(container, SWT.NONE);
		label_1.setText("New Label");
		
		text_1 = new Text(container, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button button_1 = new Button(container, SWT.NONE);
		button_1.setText("New Button");
		
		Button button_2 = new Button(container, SWT.CHECK);
		button_2.setText("Check Button");
		
		text_2 = new Text(container, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button button_3 = new Button(container, SWT.NONE);
		button_3.setText("New Button");
		
		Label label_2 = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		label_2.setText("New Label");
		
		Label label_3 = new Label(container, SWT.NONE);
		label_3.setText("New Label");
		
		text_3 = new Text(container, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
		
		Label label_4 = new Label(container, SWT.NONE);
		label_4.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		label_4.setText("New Label");
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayout(new RowLayout(SWT.HORIZONTAL));
		GridData gd_composite = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_composite.widthHint = 243;
		gd_composite.heightHint = 84;
		composite.setLayoutData(gd_composite);
		
		Button button_4 = new Button(composite, SWT.RADIO);
		button_4.setText("Radio Button");
		
		Button button_5 = new Button(composite, SWT.RADIO);
		button_5.setText("Radio Button");
		
		Button button_6 = new Button(composite, SWT.RADIO);
		button_6.setText("Radio Button");
		
		Button button_7 = new Button(composite, SWT.RADIO);
		button_7.setText("Radio Button");
		
		Button button_8 = new Button(composite, SWT.CHECK);
		button_8.setText("Check Button");
		
		Button button_9 = new Button(composite, SWT.CHECK);
		button_9.setText("Check Button");
		
		Button button_10 = new Button(composite, SWT.CHECK);
		button_10.setText("Check Button");
		new Label(container, SWT.NONE);
		
		Label label_5 = new Label(container, SWT.NONE);
		label_5.setText("New Label");
		
		text_4 = new Text(container, SWT.BORDER);
		text_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button button_11 = new Button(container, SWT.NONE);
		button_11.setText("New Button");
		
		Label label_6 = new Label(container, SWT.NONE);
		label_6.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		label_6.setText("New Label");
		
		List list = new List(container, SWT.BORDER);
		GridData gd_list = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 2);
		gd_list.heightHint = 78;
		list.setLayoutData(gd_list);
		
		Button button_12 = new Button(container, SWT.NONE);
		button_12.setText("New Button");
		new Label(container, SWT.NONE);
		
		Button button_13 = new Button(container, SWT.NONE);
		button_13.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		button_13.setText("New Button");
		
		Label label_7 = new Label(container, SWT.NONE);
		label_7.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		label_7.setText("New Label");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Button button_14 = new Button(container, SWT.CHECK);
		button_14.setText("Check Button");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Button button_15 = new Button(container, SWT.CHECK);
		button_15.setText("Check Button");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Button button_16 = new Button(container, SWT.CHECK);
		button_16.setText("Check Button");
		new Label(container, SWT.NONE);
		
		Label label_8 = new Label(container, SWT.NONE);
		label_8.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		label_8.setText("New Label");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Button button_17 = new Button(container, SWT.CHECK);
		button_17.setText("Check Button");
		new Label(container, SWT.NONE);

		return area;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 738);
	}

}

