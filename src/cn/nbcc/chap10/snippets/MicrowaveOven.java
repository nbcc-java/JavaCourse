/**
 * 所属包：cn.nbcc.chap10.snippets
 * 文件名：MicrowaveOven.java
 * 创建者：郑哲
 * 创建时间：2014-5-27 上午09:10:32
 */
package cn.nbcc.chap10.snippets;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MicrowaveOven {
	protected Shell shell;
	private GlassWindow glassWindow;
	private DisplayPanel displayPanel;
	private KeyboardPanel keyboardPanel;
	private ControlPanel controlPanel;
	private MicrowaveOvenStatus status;
	private ArrayList<IStatusChangeListener> listeners = new ArrayList<IStatusChangeListener>();
	private SoundManager soundManager;

	public static void main(String[] args) {
		try {
			MicrowaveOven window = new MicrowaveOven();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		Display display = Display.getDefault();
		createContents();
		init();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private void init() {
		addStatusChangeListener(glassWindow);
		addStatusChangeListener(keyboardPanel);
		addStatusChangeListener(displayPanel);
		addStatusChangeListener(controlPanel);
		addStatusChangeListener(soundManager);
		status = MicrowaveOvenStatus.UNSETTING;
		fireStatusChange();
	}

	public void fireStatusChange() {
		for (IStatusChangeListener listener : listeners) {
			listener.onStatusChange(this);
		}
		
	}

	protected void createContents() {
		shell = new Shell();
		shell.setSize(511, 270);
		shell.setText("\u5FAE\u6CE2\u7089\u6A21\u62DF\u7A0B\u5E8F");
		shell.setLayout(new GridLayout(2, false));
		glassWindow = new GlassWindow(shell, SWT.BORDER);
		displayPanel = new DisplayPanel(shell, SWT.BORDER);
		keyboardPanel = new KeyboardPanel(shell, SWT.BORDER);
		controlPanel = new ControlPanel(shell, SWT.BORDER);
		soundManager = new SoundManager(shell, SWT.NONE);
	}
	
	public void addStatusChangeListener(IStatusChangeListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}
	public void removeStatusChangeListener(IStatusChangeListener listener) {
		if (listeners.contains(listener)) {
			listeners.remove(listener);
		}
	}
	public MicrowaveOvenStatus getStatus() {
		return status;
	}

	public void setStatus(MicrowaveOvenStatus newStatus) {
		status = newStatus;
	}

	/**
	 * @param addedDigit
	 */
	public void checkValid(String addedDigit) {
		boolean isValid = displayPanel.isValid(addedDigit);
		controlPanel.setStartButtonEnabled(isValid);
	}

	public void clear() {
		displayPanel.clear();
	}

	public void setTimeString(String timString) {
		displayPanel.setTimeString(timString);
	}

	/**
	 * @return
	 */
	public String getTimeString() {
		return displayPanel.getTimeString();
	}
}
