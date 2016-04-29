/**
 * 所属包：cn.nbcc.chap10.snippets
 * 文件名：MicrowaveOven1.java
 * 创建者：郑哲
 * 创建时间：2015-6-9 下午01:30:13
 */
package cn.nbcc.chap10.snippets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class MicrowaveOven1 {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MicrowaveOven1 window = new MicrowaveOven1();
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
		shell.setSize(450, 273);
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout(2, false));
		
		Composite glassWindow = new Composite(shell, SWT.BORDER);
		glassWindow.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 3));
		
		Composite displayPanel = new Composite(shell, SWT.BORDER);
		GridData gd = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd.widthHint = 87;
		gd.heightHint = 28;
		displayPanel.setLayoutData(gd);
		displayPanel.setLayout(new GridLayout(1, false));
		
		Label displayLabel = new Label(displayPanel, SWT.NONE);
		displayLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		displayLabel.setText("欢迎使用微波炉");
		
		Composite keyboadPanel = new Composite(shell, SWT.BORDER);
		keyboadPanel.setLayout(new GridLayout(3, true));
		keyboadPanel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		
		for (int i = 0; i < 10; i++) {
			
			Button button = new Button(keyboadPanel, SWT.NONE);
			button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
			button.setText(i+"");
		}
		
		
		Composite controlPanel = new Composite(shell, SWT.BORDER);
		controlPanel.setLayout(new GridLayout(2, false));
		gd = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd.heightHint = 37;
		controlPanel.setLayoutData(gd);
		
		Button startButton = new Button(controlPanel, SWT.NONE);
		startButton.setText("\u5F00\u59CB");
		
		Button clearButton = new Button(controlPanel, SWT.NONE);
		clearButton.setText("\u6E05\u9664");

	}
}

