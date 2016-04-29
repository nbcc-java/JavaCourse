/**
 * 所属包：cn.nbcc.chap06.swt.snippets
 * 文件名：PaintEventDemo.java
 * 创建者：郑哲
 * 创建时间：2015-6-8 下午09:42:31
 */
package cn.nbcc.chap06.swt.snippets;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class PaintEventDemo {
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				Shell se = (Shell) e.widget;
				Rectangle bounds = se.getClientArea();
				GC gc = e.gc;
				gc.drawLine(bounds.x, bounds.y, bounds.x + bounds.width,
						bounds.y + bounds.height);
			}
		});
		shell.setSize(450, 300);
		shell.setText("PaintEventDemo");

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
