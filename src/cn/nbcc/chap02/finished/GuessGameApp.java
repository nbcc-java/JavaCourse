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
 * �ĵ���:GuessGameApp.java ����ʱ��:2010-6-2
 * ������Ŀ:Chap03�¼۸���Ϸ
 * ����:֣��
 * copyright 2010 ��������ְҵ����ѧԺ��Ȩ����
 */
public class GuessGameApp extends ApplicationWindow {
	private List historyList;	//�²���ʷ��¼�б�
	private Text priceText;		//�²�۸��ı���
	private Action settingAction;//���ò˵����
	private Action newGameAction;//����Ϸ�˵����
	private int randomPrice;	//����۸�
	private int count;			//��ǰ�²����
	private Button confirmButton;		
	public static int highPrice;
	public static int lowPrice;
	public static int limitCount;
	/**
	 * ����Ӧ�ó��򴰿�
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
	 * ��ʼ����������
	 */
	private void loadData() {
		Helper.loadData();
		highPrice =Helper.getHighPrice();
		lowPrice = Helper.getLowPrice();
		limitCount= Helper.getLimitCount();
		
	}
	/**
	 * ������������Ԫ��
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		final GridLayout gridLayout = new GridLayout();//����gridLayout����
		gridLayout.numColumns = 3;		//����3�в���
		container.setLayout(gridLayout);//��ǰ����Ӧ��grid����

		final Label newPriceLable = new Label(container, SWT.NONE);
		newPriceLable.setText("�����¼۸�:");
		priceText = new Text(container, SWT.BORDER);
		priceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		confirmButton = new Button(container, SWT.NONE);
		confirmButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				int guessPrice = 0;
				boolean isContinue = true;

				try {
					//�����ı����ֵ,ת�����������ͣ������浽guessPrice��
					guessPrice = Integer.parseInt(priceText.getText());
				} catch (NumberFormatException nfe) {
					MessageDialog.openConfirm(getShell(), "��ʽ����", "��������ָ�ʽ����ȷ��������");
					return;
				}
				count++;//�����²����
				//�ж��Ƿ���Ϸ����Ԥ������
				if (count>=limitCount) {
					isContinue=false;
				}
				//�ȶԼ۸������Ӧ��Ϣ
				String msg ;
				if (guessPrice == randomPrice) {
					msg = "��ϲ��¶���";
					isContinue = false;
				} else if (!isContinue) {
					msg = "��Ϸʧ��,��ȷ����"+randomPrice;
				} else {
					if (guessPrice < randomPrice) {
						msg = "���ˣ�������һ��";
					} else {
						msg = "���ˣ�������һ��";
					}
				}
				getStatusLineManager().setMessage(msg);
				enableInput(isContinue);
				//��list�б���������ʷ��Ϣ
				historyList.add(guessPrice+"");
			}
		});
		confirmButton.setText("ȷ��");
		final Label historyLabel = new Label(container, SWT.NONE);
		historyLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		historyLabel.setText("�²�۸���ʷ��¼:");
		historyList = new List(container, SWT.BORDER);
		historyList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 3, 1));
		enableInput(false);
		return container;
	}
	/**
	 * ������Ϸ״̬����/����������
	 * @param enable
	 */
	private void enableInput(boolean enable) {
		priceText.setEnabled(enable);
		confirmButton.setEnabled(enable);
	}
	/**
	 * ������ض���
	 */
	private void createActions() {
		newGameAction = new Action("����Ϸ") {
			public void run() {
				loadData();
				//��Math.random��������۸񣬱��浽randomPrice��
				randomPrice = (int)(Math.random()*(highPrice-lowPrice)+lowPrice);
				getStatusLineManager().setMessage(randomPrice+"");
				//�����ı���Ͱ�ť
				enableInput(true);
				//����б����ı���
				historyList.removeAll();
				priceText.setText("");
				//����count
				count = 0;
			}
		};
		newGameAction.setAccelerator(SWT.CTRL | 'N');
		newGameAction.setToolTipText("����һ������Ϸ");
		newGameAction.setImageDescriptor(ResourceManager.getImageDescriptor(GuessGameApp.class, "/etool16/newjworkingSet_wiz.gif"));
		settingAction = new Action("��Ϸ����") {
			public void run() {
				new ConfigDialog(getShell()).open();
			}
		};
		settingAction.setAccelerator(SWT.CTRL | SWT.SHIFT | 'C');
		settingAction.setToolTipText("������Ϸ��������");
		settingAction.setImageDescriptor(ResourceManager.getImageDescriptor(GuessGameApp.class, "/etool16/segment_edit.gif"));
	}
	/**
	 *�����˵�������
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager("menu");

		final MenuManager opMenuManager = new MenuManager("����");
		menuManager.add(opMenuManager);

		opMenuManager.add(newGameAction);

		opMenuManager.add(settingAction);
		return menuManager;
	}

	/**
	 * ����������������
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
	 * ����״̬��������
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		statusLineManager.setMessage(null, "");
		return statusLineManager;
	}

	/**
	 * ����Ӧ�ó���
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
	 * ����������
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("�¼۸���Ϸ");
		newShell.setImage(SWTResourceManager.getImage(GuessGameApp.class, "/etool16/newjworkingSet_wiz.gif"));
		newShell.setSize(215,327);
	}
	/**
	 * �����Ϸ�����ڳ�ʼ����С
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(215, 327);
	}
}
