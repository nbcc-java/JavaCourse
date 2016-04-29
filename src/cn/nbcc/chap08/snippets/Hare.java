/**
 * 所属包：cn.nbcc.chap08.snippets
 * 文件名：Hare.java
 * 创建者：郑哲
 * 创建时间：2014-5-6 下午03:56:32
 */
package cn.nbcc.chap08.snippets;

import org.apache.commons.lang3.StringUtils;
public class Hare  extends Role implements Runnable {
	
	public  static final String INFO = "兔子睡着了zzzz";
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
					if (!isHareSleep) {// 如果兔子没有睡觉
						stepForward();
						String output = super.getFootPrint("兔子", StringUtils
								.leftPad("H", getFootPosInProgress()));
						System.out.print(output);
					} else
						printMessage("兔子", INFO);
				} else {
					isFinished = true;
					Thread.currentThread().getThreadGroup().interrupt();

				}
			}
		} catch (InterruptedException e) {
			if (isFinished) {
				System.out.println("比赛结束，兔子赢");
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

