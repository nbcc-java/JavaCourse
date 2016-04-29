/**
 * ��������cn.nbcc.chap10.snippets
 * �ļ�����ControlPanel.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-27 ����10:24:33
 */
package cn.nbcc.chap10.snippets;

import java.util.Timer;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class ControlPanel extends Composite implements IStatusChangeListener {
	private Button startBtn;
	private Button clearBtn;
	protected MicrowaveOven oven;
	protected CookTimer cookTimer;
	public ControlPanel(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, true));
		setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		startBtn = new Button(this, SWT.NONE);
		startBtn.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		startBtn.setText("\u5F00\u59CB");
		startBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				oven.setStatus(MicrowaveOvenStatus.RUNNING);
				cookTimer = new CookTimer(oven.getTimeString(),oven);
				cookTimer.start();
				oven.fireStatusChange();
			}
		});

		
		clearBtn = new Button(this, SWT.NONE);
		clearBtn.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		clearBtn.setText("\u6E05\u9664");
		clearBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (clearBtn.getText().equals("���")) {
					oven.clear();
					startBtn.setEnabled(false); 	//�����ʼ��ťΪ����״̬
				}else{
					boolean isConfirm = MessageDialog.openConfirm(oven.shell, "ȷ��", 
										"���Ҫֹͣ������?");
					if (isConfirm) {
						cookTimer.stop();
						oven.setStatus(MicrowaveOvenStatus.CANCEL);
						oven.fireStatusChange();
					}
				}
			}
		});

		
	}
	@Override
	protected void checkSubclass() {
	}
	/**
	 * @param isValid
	 */
	public void setStartButtonEnabled(boolean isValid) {
		startBtn.setEnabled(isValid);
	}
	@Override
	public void onStatusChange(MicrowaveOven oven) {
		this.oven = oven;
		switch (oven.getStatus()) {
		case SETTING:
			clearBtn.setEnabled(true);
			clearBtn.setText("���");
			break;
		case RUNNING:
			clearBtn.setText("ֹͣ");
			startBtn.setEnabled(false);
			break;
		default:
			startBtn.setEnabled(false);
			clearBtn.setEnabled(false);
			break;
		}
	}

}

