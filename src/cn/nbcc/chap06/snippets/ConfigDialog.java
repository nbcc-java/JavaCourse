/**
 * 所属包：cn.nbcc.chap06.snippets
 * 文件名：ConfigDialog.java
 * 创建者：郑哲
 * 创建时间：2015-5-12 下午02:53:53
 */
package cn.nbcc.chap06.snippets;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.layout.GridLayout;

public class ConfigDialog extends TitleAreaDialog {
	private Text text;
	private Text text_1;
	private Text text_2;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public ConfigDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.CLOSE | SWT.RESIZE);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitleImage(SWTResourceManager.getImage(ConfigDialog.class, "/wizban/fixdepr_wiz.png"));
		setTitle("\u731C\u4EF7\u683C\u6E38\u620F\u914D\u7F6E");
		setMessage("\u5BF9\u731C\u4EF7\u683C\u6E38\u620F\u8FDB\u884C\u57FA\u672C\u914D\u7F6E");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Group group = new Group(container, SWT.NONE);
		group.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		group.setText("\u4EF7\u683C\u8303\u56F4\u8BBE\u5B9A");
		group.setLayout(new GridLayout(2, false));
		
		Label label = new Label(group, SWT.NONE);
		label.setBounds(0, 0, 61, 17);
		label.setText("\u6700\u4F4E\u4EF7\u683C:");
		
		text = new Text(group, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		text.setBounds(0, 0, 71, 23);
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_1.setText("\u6700\u9AD8\u4EF7\u683C:");
		
		text_1 = new Text(group, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label label_2 = new Label(container, SWT.NONE);
		label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, false, 1, 1));
		label_2.setText("\u6B21\u6570\u9650\u5236;");
		
		text_2 = new Text(container, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

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
		return new Point(450, 442);
	}
}

