/**
 * 所属包：cn.nbcc.chap10.snippets
 * 文件名：GlassWindow.java
 * 创建者：郑哲
 * 创建时间：2014-5-27 上午09:36:15
 */
package cn.nbcc.chap10.snippets;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
public class GlassWindow extends Composite implements IStatusChangeListener,PaintListener {
	
	static final Color COLOR_DEFAULT = 
		Display.getDefault().getSystemColor(SWT.COLOR_GRAY);
		static final Color COLOR_RUNNING = 
		Display.getDefault().getSystemColor(SWT.COLOR_YELLOW);
		static Image image01 = ImageDescriptor.createFromFile(GlassWindow.class,
		"images/pic01.jpg").createImage();

	public GlassWindow(Composite parent, int style) {
		super(parent, style);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 3);
		setLayoutData(gd);
	}
	
	public void onStatusChange(MicrowaveOven oven) {
		switch (oven.getStatus()) {
		case RUNNING:
			setBackground(COLOR_RUNNING);
			break;
		case FINISHED:
			this.addPaintListener(this);
			
			break;
		default:
			removePaintListener(this);
			setBackground(COLOR_DEFAULT);
			break;
		}
		redraw();
	}
	
	public void paintControl(PaintEvent e) {
		GC gc = e.gc;
		int pWidth = image01.getBounds().width;
		int piHght = image01.getBounds().height;
		int cWidth = GlassWindow.this.getBounds().width;
		int cHight = GlassWindow.this.getBounds().height;
		gc.drawImage(image01, (cWidth - pWidth) / 2, (cHight - piHght) / 2);
	}
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}

