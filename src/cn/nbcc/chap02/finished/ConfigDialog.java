package cn.nbcc.chap02.finished;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.swtdesigner.SWTResourceManager;

/**
 * 文档名:ConfigDialog.java 开发时间:2010-6-7
 * 所属项目:Chap03猜价格游戏
 * 作者:郑哲
 * copyright 2010 宁波城市职业技术学院版权所有
 */
public class ConfigDialog extends TitleAreaDialog implements VerifyListener,ModifyListener {

	private Text limitCountText;
	private Text highPriceText;
	private Text lowPriceText;
	public ConfigDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.CLOSE | SWT.RESIZE);
		
	}
	/**
	 * 创建配置对话框
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		{
			final GridLayout gridLayout = new GridLayout(2,false);
			container.setLayout(gridLayout);
		}
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		final Group group = new Group(container, SWT.NONE);
		group.setText("价格范围设定");
		group.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		{
			final GridLayout gridLayout = new GridLayout(2,false);
			group.setLayout(gridLayout);
		}

		final Label lowPriceLabel = new Label(group, SWT.NONE);
		lowPriceLabel.setText("最低价格:");

		lowPriceText = new Text(group, SWT.BORDER);
		lowPriceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label highPriceLabel = new Label(group, SWT.NONE);
		highPriceLabel.setText("最高价格:");

		highPriceText = new Text(group, SWT.BORDER);
		highPriceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label limitLabel = new Label(container, SWT.NONE);
		limitLabel.setText("次数限制:");

		limitCountText = new Text(container, SWT.BORDER);
		limitCountText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		setTitle("猜价格游戏配置");
		setMessage("对猜价格游戏进行基本配置");
		setTitleImage(SWTResourceManager.getImage(ConfigDialog.class, "/wizban/fixdepr_wiz.png"));
		
		init();
		lowPriceText.addVerifyListener(this);
		lowPriceText.addModifyListener(this);
		highPriceText.addVerifyListener(this);
		highPriceText.addModifyListener(this);
		limitCountText.addVerifyListener(this);
		limitCountText.addModifyListener(this);
		return area;
	}

	/**
	 * 初始化对话框中的参数信息
	 */
	private void init() {
		lowPriceText.setText(Helper.getLowPrice()+"");
		highPriceText.setText(Helper.getHighPrice()+"");
		limitCountText.setText(Helper.getLimitCount()+"");
	}

	/**
	 * 创建工具栏按钮
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected Point getInitialSize() {
		return new Point(405, 327);
	}
	protected void configureShell(Shell newShell) {
		newShell.setModified(true);
		newShell.setText("\u914D\u7F6E\u5BF9\u8BDD\u6846");
		super.configureShell(newShell);
		newShell.setImage(SWTResourceManager.getImage(ConfigDialog.class, "/etool16/segment_edit.gif"));
	}
	protected void buttonPressed(int buttonId) {
		if (buttonId == IDialogConstants.OK_ID) {
			Helper.setHighPrice(highPriceText.getText());
			Helper.setLowPrice(lowPriceText.getText());
			Helper.setLimitCount(limitCountText.getText());
			if(Helper.saveToXML())
				MessageDialog.openInformation(getShell(), "消息", "配置信息保存成功");
			else {
				MessageDialog.openError(getShell(), "消息", "配置信息保存失败");
			}
		}
		super.buttonPressed(buttonId);
	}


	private void enableOKButton(boolean enable) {
		getButton(IDialogConstants.OK_ID).setEnabled(enable);
	}
	@Override
	public void verifyText(VerifyEvent e) {
		//只接受数字和回退
		if ("0123456789".indexOf(e.text)>=0||e.text=="") {
			e.doit=true;
		}else
			e.doit=false;
	}

	@Override
	public void modifyText(ModifyEvent e) {
		String message = null;
		if(limitCountText.getText().length()==0)
			message = "次数限制不能为空";
		else if (lowPriceText.getText().length() == 0||highPriceText.getText().length()==0) {
			message = "价格不能为空";
		} else {
			int lowPrice = Integer.parseInt(lowPriceText.getText());
			int highPrice = Integer.parseInt(highPriceText.getText());
			if (lowPrice > highPrice || lowPrice < 0) {
				message = "无效的参数信息,最高/低价格必须是正整数,且最高价格比最高价格高";
			}
		}
		if(message!=null)
			enableOKButton(false);
		else
			enableOKButton(true);
		setErrorMessage(message);
	}
}
