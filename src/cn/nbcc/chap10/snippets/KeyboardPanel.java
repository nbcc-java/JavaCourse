/**
 * 所属包：cn.nbcc.chap10.snippets
 * 文件名：KeyboardPanel.java
 * 创建者：郑哲
 * 创建时间：2014-5-27 上午10:06:53
 */
package cn.nbcc.chap10.snippets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class KeyboardPanel extends Composite implements IStatusChangeListener {
	private Button buttons[]=new Button[10];
	private MicrowaveOven oven;
	protected String addedDigit;
	public KeyboardPanel(Composite parent, int style) {
		super(parent, style);
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		setLayout(new GridLayout(3, true));
		for (int i = 0; i < buttons.length; i++) {
			Button button = new Button(this, SWT.NONE);
			button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			button.setText(i+"");
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
						//第一次按下数字键
						if (oven.getStatus() == MicrowaveOvenStatus.UNSETTING||
								oven.getStatus()==MicrowaveOvenStatus.CANCEL||
								oven.getStatus()==MicrowaveOvenStatus.FINISHED) {
							oven.setStatus(MicrowaveOvenStatus.SETTING);
						}
						addedDigit = ((Button)e.getSource()).getText();//获得用户按下的数字信息
						oven.fireStatusChange();
				}
			});
			buttons[i]=button;
			
		}
	}
	@Override
	protected void checkSubclass() {
	}
	@Override
	public void onStatusChange(MicrowaveOven oven) {
		this.oven = oven;
		switch (oven.getStatus()) {
		case SETTING:
			oven.checkValid(addedDigit);             //请求oven进行数字检查
			break;
		case RUNNING:
			enableKeyboard(false);
			break;
		default:
			enableKeyboard(true);
		}
		
	}

	private void enableKeyboard(boolean b) {
		for (Button button : buttons) {
			button.setEnabled(b);
		}
	}
}

