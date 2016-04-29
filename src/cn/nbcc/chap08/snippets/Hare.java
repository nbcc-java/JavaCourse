/**
 * ��������cn.nbcc.chap08.snippets
 * �ļ�����Hare.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-6 ����03:56:32
 */
package cn.nbcc.chap08.snippets;

import org.apache.commons.lang3.StringUtils;
public class Hare  extends Role implements Runnable {
	
	public  static final String INFO = "����˯����zzzz";
	private boolean isHareSleep;
	public Hare(int totalStep) {
		super(totalStep);
	}
	@Override
	public void run() {
		try {
			while (true) {
				if (step < totalStep) {
					Thread.sleep(1000);
					isHareSleep = (int) (Math.random() * 10) % 2 == 0 ? true
							: false;
					if (!isHareSleep) {// �������û��˯��
						stepForward();
						String output = super.getFootPrint("����", StringUtils
								.leftPad("H", getFootPosInProgress()));
						System.out.print(output);
					} else
						printMessage("����", INFO);
				} else {
					isFinished = true;
					Thread.currentThread().getThreadGroup().interrupt();

				}
			}
		} catch (InterruptedException e) {
			if (isFinished) {
				System.out.println("��������������Ӯ");
			}
		}
	}
	public void stepForward() {
		step+=2;
	}
	public void setHareSleep(boolean b) {
		isHareSleep = b;
	}
}

