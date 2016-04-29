/**
 * ��������cn.nbcc.chap08.snippets
 * �ļ�����Tortoise.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-6 ����03:52:55
 */
package cn.nbcc.chap08.snippets;

import org.apache.commons.lang3.StringUtils;

public class Tortoise extends Role implements Runnable {
	public Tortoise(int totalStep) {
		super(totalStep);
	}

	@Override
	public void run() {
		try {
			while (true) {
				if (step < totalStep) {
					Thread.sleep(1000);
					stepForward();
					// System.out.printf("�ڹ�����%d��...%n", step);
					System.out.printf(
							"%s",
							getFootPrint("�ڹ�", StringUtils.leftPad("T",
									getFootPosInProgress())));

				} else {
					isFinished = true;
					Thread.currentThread().getThreadGroup().interrupt();

				}

			}

		} catch (InterruptedException e) {
			if (isFinished) {
				System.out.println("�����������ڹ�Ӯ");
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.nbcc.chap08.snippets.Role#goForward()
	 */
	@Override
	public void stepForward() {
		step += 1;
	}

}
