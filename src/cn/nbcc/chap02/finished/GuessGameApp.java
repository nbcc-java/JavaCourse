package cn.nbcc.chap02.finished;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import com.swtdesigner.ResourceManager;
import com.swtdesigner.SWTResourceManager;
/**
 * 文档名:GuessGameApp.java 开发时间:2010-6-2
 * 所属项目:Chap03猜价格游戏
 * 作者:郑哲
 * copyright 2010 宁波城市职业技术学院版权所有
 */
public class GuessGameApp extends ApplicationWindow {
	private List historyList;	//猜测历史记录列表
	private Text priceText;		//猜测价格文本框
	private Action settingAction;//配置菜单项动作
	private Action newGameAction;//新游戏菜单项动作
	private int randomPrice;	//随机价格
	private int count;			//当前猜测次数
	private Button confirmButton;		
	public static int highPrice;
	public static int lowPrice;
	public static int limitCount;
	/**
	 * 创建应用程序窗口
	 */
	public GuessGameApp() {
		super(null);
		loadData();
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
	}
	/**
	 * 初始化配置数据
	 */
	private void loadData() {
		Helper.loadData();
		highPrice =Helper.getHighPrice();
		lowPrice = Helper.getLowPrice();
		limitCount= Helper.getLimitCount();
		
	}
	/**
	 * 创建窗口内容元素
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		final GridLayout gridLayout = new GridLayout();//创建gridLayout对象
		gridLayout.numColumns = 3;		//设置3列布局
		container.setLayout(gridLayout);//当前容器应用grid布局

		final Label newPriceLable = new Label(container, SWT.NONE);
		newPriceLable.setText("输入新价格:");
		priceText = new Text(container, SWT.BORDER);
		priceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		confirmButton = new Button(container, SWT.NONE);
		confirmButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				int guessPrice = 0;
				boolean isContinue = true;

				try {
					//读入文本框的值,转换成整数类型，并保存到guessPrice中
					guessPrice = Integer.parseInt(priceText.getText());
				} catch (NumberFormatException nfe) {
					MessageDialog.openConfirm(getShell(), "格式错误", "输入的数字格式不正确，请重试");
					return;
				}
				count++;//自增猜测次数
				//判断是否游戏超过预设限制
				if (count>=limitCount) {
					isContinue=false;
				}
				//比对价格，输出相应信息
				String msg ;
				if (guessPrice == randomPrice) {
					msg = "恭喜你猜对了";
					isContinue = false;
				} else if (!isContinue) {
					msg = "游戏失败,正确答案是"+randomPrice;
				} else {
					if (guessPrice < randomPrice) {
						msg = "低了，请再试一次";
					} else {
						msg = "高了，请再试一次";
					}
				}
				getStatusLineManager().setMessage(msg);
				enableInput(isContinue);
				//向list列表框中添加历史信息
				historyList.add(guessPrice+"");
			}
		});
		confirmButton.setText("确定");
		final Label historyLabel = new Label(container, SWT.NONE);
		historyLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		historyLabel.setText("猜测价格历史记录:");
		historyList = new List(container, SWT.BORDER);
		historyList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 3, 1));
		enableInput(false);
		return container;
	}
	/**
	 * 根据游戏状态禁用/启用相关组件
	 * @param enable
	 */
	private void enableInput(boolean enable) {
		priceText.setEnabled(enable);
		confirmButton.setEnabled(enable);
	}
	/**
	 * 创建相关动作
	 */
	private void createActions() {
		newGameAction = new Action("新游戏") {
			public void run() {
				loadData();
				//用Math.random生成随机价格，保存到randomPrice中
				randomPrice = (int)(Math.random()*(highPrice-lowPrice)+lowPrice);
				getStatusLineManager().setMessage(randomPrice+"");
				//开启文本框和按钮
				enableInput(true);
				//清除列表框和文本框
				historyList.removeAll();
				priceText.setText("");
				//重置count
				count = 0;
			}
		};
		newGameAction.setAccelerator(SWT.CTRL | 'N');
		newGameAction.setToolTipText("创建一个新游戏");
		newGameAction.setImageDescriptor(ResourceManager.getImageDescriptor(GuessGameApp.class, "/etool16/newjworkingSet_wiz.gif"));
		settingAction = new Action("游戏配置") {
			public void run() {
				new ConfigDialog(getShell()).open();
			}
		};
		settingAction.setAccelerator(SWT.CTRL | SWT.SHIFT | 'C');
		settingAction.setToolTipText("进行游戏参数配置");
		settingAction.setImageDescriptor(ResourceManager.getImageDescriptor(GuessGameApp.class, "/etool16/segment_edit.gif"));
	}
	/**
	 *创建菜单管理器
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager("menu");

		final MenuManager opMenuManager = new MenuManager("操作");
		menuManager.add(opMenuManager);

		opMenuManager.add(newGameAction);

		opMenuManager.add(settingAction);
		return menuManager;
	}

	/**
	 * 创建工具栏管理器
	 * @return the toolbar manager
	 */
	@Override
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		toolBarManager.add(newGameAction);
		toolBarManager.add(settingAction);
		return toolBarManager;
	}
	/**
	 * 创建状态栏管理器
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		statusLineManager.setMessage(null, "");
		return statusLineManager;
	}

	/**
	 * 启动应用程序
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			GuessGameApp window = new GuessGameApp();
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 配置主窗口
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("猜价格游戏");
		newShell.setImage(SWTResourceManager.getImage(GuessGameApp.class, "/etool16/newjworkingSet_wiz.gif"));
		newShell.setSize(215,327);
	}
	/**
	 * 获得游戏主窗口初始化大小
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(215, 327);
	}
}
