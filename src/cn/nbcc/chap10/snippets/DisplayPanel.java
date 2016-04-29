/**
 * 所属包：cn.nbcc.chap10.snippets
 * 文件名：DisplayPanel.java
 * 创建者：郑哲
 * 创建时间：2014-5-27 上午09:48:16
 */
package cn.nbcc.chap10.snippets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class DisplayPanel extends Composite implements IStatusChangeListener {
	private String message;
	private static final String FINISHED_MESSAGE = "烹煮完成,请取出";
	private static final String CANCEL_MESSAGE = "操作已成功取消";
	private static final String DEFAULT_TIME_MESSAGE = "00:00";
	private static final String WELCOME_MESSAGE = "欢迎使用微波炉程序";
	private Label displayLabel;
	private String timeString = DEFAULT_TIME_MESSAGE;
	public DisplayPanel(Composite parent, int style) {
		super(parent, style);
		GridData gd = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		setLayoutData(gd);
		setLayout(new FillLayout());
		displayLabel = new Label(this, SWT.NONE);
		displayLabel.setText(WELCOME_MESSAGE);
		displayLabel.setAlignment(SWT.CENTER);
	}
	@Override
	public void onStatusChange(MicrowaveOven oven) {
		switch (oven.getStatus()) {
		case UNSETTING:
			message = WELCOME_MESSAGE;
			break;
		case SETTING:
		case RUNNING:
			message = timeString;
			break;
		case CANCEL:
			message = CANCEL_MESSAGE;
			clear();
			break;
		case FINISHED:
			message = FINISHED_MESSAGE;
			clear();
			break;
		default:
			break;
		}
		displayLabel.setText(message);
	}

	@Override
	protected void checkSubclass() {
	}
	/**
	 * @param addedDigit
	 * @return
	 */
	public boolean isValid(String addedDigit) {
		addDigit(addedDigit);
		String tokens[] = timeString.split(":");
		int m = Integer.parseInt(tokens[0]);
		int s = Integer.parseInt(tokens[1]);
		return m >= 0 && m < 60 && s >= 0 && s < 60;
	}

	private void addDigit(String addedDigit) {
		String tokens[] = timeString.split(":");
		StringBuilder sBuilder = new StringBuilder();
		timeString = sBuilder.append(tokens[0]).append(tokens[1]).append(addedDigit)
				.insert(3, ":").substring(1);
	}
	
	public void clear() {
		timeString = DEFAULT_TIME_MESSAGE;
		setTimeString(timeString);
	}
	public void setTimeString(String timString) {
		this.timeString = timString;
		displayLabel.setText(timeString);
	}
	/**
	 * @return
	 */
	public String getTimeString() {
		return timeString;
	}

}
