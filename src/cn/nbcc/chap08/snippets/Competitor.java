/**
 * ��������cn.nbcc.chap08.snippets
 * �ļ�����Competitor.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-20 ����08:59:41
 */
package cn.nbcc.chap08.snippets;
public abstract class Competitor extends Thread {
	enum ResultStatus {
		WIN,LOSE
	}
	//������ʾǰ���ַ������ڹ�:������:
	private static final String Prefix = "����:";
	protected int stepLen;	//ÿ�����
	protected int fieldLen;	//���ؿ��
	protected int curStep;	//��ǰ��λ��
	protected String name;
	protected ResultStatus status;//�������
	protected int displayWidth = fieldLen+Prefix.length();
	protected static volatile boolean isFinished = false;//����������ʶ
	
	public abstract void goForward();

	public Competitor(String name,int stepLen, int fieldLen) {
		super();
		this.stepLen = stepLen;
		this.fieldLen = fieldLen;
		this.name = name;
		this.displayWidth = fieldLen+String.format("%s:", name).length();
	}
	public int getCurStep() {
		return curStep;
	}
	@Override
	public void run() {
		while (!isFinished) {
			if (curStep<fieldLen) {
				try {
					Thread.sleep(1000);
					goForward();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				isFinished = true;
				status = ResultStatus.WIN;
			}
		}
	}
	public ResultStatus getResultStatus() {
		return status;
	}
}

