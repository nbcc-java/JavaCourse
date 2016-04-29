/**
 * 所属包：cn.nbcc.chap08.snippets
 * 文件名：Tortoise.java
 * 创建者：郑哲
 * 创建时间：2014-5-6 下午03:52:55
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
					// System.out.printf("乌龟跑了%d步...%n", step);
					System.out.printf(
							"%s",
							getFootPrint("乌龟", StringUtils.leftPad("T",
									getFootPosInProgress())));

				} else {
					isFinished = true;
					Thread.currentThread().getThreadGroup().interrupt();

				}

			}

		} catch (InterruptedException e) {
			if (isFinished) {
				System.out.println("比赛结束，乌龟赢");
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
