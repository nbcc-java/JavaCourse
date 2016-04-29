package cn.nbcc.chap06.snippets;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
public class App extends SelectionAdapter{
	private static Shell shell;
	public static void main(String[] args) {
		Display display = Display.getDefault();
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		Button button = new Button(shell, SWT.NONE);
		
		//事件源按钮维护了一个监听的清单
		button.addSelectionListener(new SelectionAdapter() {//匿名内类
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openWarning(shell, "标题", "按钮被按下了");
			}
		});//在按钮中添加按钮选择监听人
		button.setBounds(65, 68, 80, 27);
		button.setText("按钮");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//添加按钮处理
				FileDialog dialog = new FileDialog(shell);
				dialog.open();
			}
		});
		button_1.setBounds(46, 138, 80, 27);
		button_1.setText("New Button");
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	@Override
	public void widgetSelected(SelectionEvent e) {
		MessageDialog.openInformation(shell, "提醒", "按钮被触发");
	}
	 
}

