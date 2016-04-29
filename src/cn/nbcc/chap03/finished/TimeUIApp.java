package cn.nbcc.chap03.finished;
import java.text.SimpleDateFormat;
import java.util.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
public class TimeUIApp {
	protected Shell shell;
	private Text hourText;
	private Text minuteText;
	private Text secondText;
	private Text stdText;
	private Text miliText;
	private Time t;
	private Timer timer;
	public static void main(String[] args) {
		try {
			TimeUIApp window = new TimeUIApp();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void open() {
		Display display = Display.getDefault();
		createContents();
		createTime();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	private void createTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		String sysTime = sdf.format(date);
		t = new Time(sysTime);
		timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				t.tick();
				System.out.println(t.toStdString());
				updateSystemTime();
			}
		};
		timer.schedule(task, 0, 1000);
	}
	protected void createContents() {
		shell = new Shell();
		shell.setSize(400, 225);
		shell.setText("ʱ��Ӧ�ó���");
		//����shell�Ĺر��¼�
		shell.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				timer.cancel();//ȡ����ʱ��
			}
		});
		//����3������ָ��ÿ�п��������
		GridLayout gl = new GridLayout(3, false);
		shell.setLayout(gl);
		Label hourLabel = new Label(shell, SWT.NONE);
		{
			GridData gd=new GridData(SWT.RIGHT, SWT.CENTER, false,false,1,1);
			hourLabel.setLayoutData(gd);
		}
		hourLabel.setText("Сʱ:");
		hourText = new Text(shell, SWT.BORDER);
		hourText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		Button hourButton = new Button(shell, SWT.NONE);
		hourButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				t.setHour(Integer.parseInt(hourText.getText()));
				System.out.println(t.toStdString());
				updateSystemTime();
			}
		});
		hourButton.setText("�趨");
		Label minuteLabel = new Label(shell, SWT.NONE);
		{
			GridData gd=new GridData(SWT.RIGHT,SWT.CENTER,false,false,1,1);
			minuteLabel.setLayoutData(gd);
		}
		minuteLabel.setText("����:");
		minuteText = new Text(shell, SWT.BORDER);
		{
			GridData gd=new GridData(SWT.FILL,SWT.CENTER,true,false,1,1);
			minuteText.setLayoutData(gd);
		}
		Button minuteButton = new Button(shell, SWT.NONE);
		minuteButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				t.setMinute(Integer.parseInt(minuteText.getText()));
				updateSystemTime();
			}
		});
		minuteButton.setText("�趨");
		Label secondLabel = new Label(shell, SWT.NONE);
		secondLabel.setText("����:");
		secondText = new Text(shell, SWT.BORDER);
		{
			GridData gd=new GridData(SWT.FILL,SWT.CENTER,true,false,1,1);
			secondText.setLayoutData(gd);
		}
		Button secondButton = new Button(shell, SWT.NONE);
		secondButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				t.setSecond(Integer.parseInt(secondText.getText()));
				updateSystemTime();
			}
		});
		secondButton.setText("�趨");
		Group group = new Group(shell, SWT.NONE);
		group.setText("������ʾ����");
		group.setLayout(new GridLayout(2, false));
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 3, 1));
		Label toStdLabel = new Label(group, SWT.NONE);
		{
			GridData gd=new GridData(SWT.RIGHT,SWT.CENTER,false, false,1,1);
			toStdLabel.setLayoutData(gd);
		}
		toStdLabel.setText("��׼��ʽ:");
		stdText = new Text(group, SWT.BORDER);
		stdText.setEnabled(false);
		{
			GridData gd=new GridData(SWT.FILL, SWT.CENTER, true, false,1,1);
			stdText.setLayoutData(gd);
		}
		Label toMilliLabel = new Label(group, SWT.NONE);
		{
			GridData gd=new GridData(SWT.RIGHT, SWT.CENTER, false,false,1,1);
			toMilliLabel.setLayoutData(gd);
		}
		toMilliLabel.setText("���ø�ʽ:");
		miliText = new Text(group, SWT.BORDER);
		miliText.setEnabled(false);
		{
			GridData gd=new GridData(SWT.FILL,SWT.CENTER,true,false,1,1);
			miliText.setLayoutData(gd);
		}
	}
	/**
	 * ��UI�����ϸ���ʱ����Ϣ
	 */
	public void updateSystemTime() {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				miliText.setText(t.toMiliString());
				stdText.setText(t.toStdString());
			}
		});
	}
}
