/**
 * 所属包：cn.nbcc.chap06.snippets
 * 文件名：UsingFormLayout1.java
 * 创建者：郑哲
 * 创建时间：2014-5-26 上午10:27:19
 */
package cn.nbcc.chap06.snippets;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
public class UsingFormLayout {
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setLayout(new FormLayout());
		shell.setSize(200,200);
		shell.open();
		final Button b1 = new Button(shell,SWT.NONE);
		b1.setText("B1");
		FormData fd1 = new FormData();
		fd1.left = new FormAttachment(20,1);
		fd1.right = new FormAttachment(50);
		fd1.top = new FormAttachment(0);
		fd1.bottom = new FormAttachment(50);
		b1.setLayoutData(fd1);
		final Button b2 = new Button(shell, SWT.NONE);
		final FormData fd2 = new FormData();
		fd2.top = new FormAttachment(b1);
		fd2.left = new FormAttachment(b1,0,SWT.RIGHT);
		fd2.right = new FormAttachment(b1,60,SWT.RIGHT);
		fd2.bottom = new FormAttachment(b1,20,SWT.BOTTOM);
		b2.setLayoutData(fd2);
		b2.setText("B2");
		shell.layout();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch())
				display.sleep();
		}
	}
}

