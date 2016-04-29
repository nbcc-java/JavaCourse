/**
 * 所属包：cn.nbcc.chap10.snippets
 * 文件名：CookTimer.java
 * 创建者：郑哲
 * 创建时间：2014-5-27 下午12:35:08
 */
package cn.nbcc.chap10.snippets;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;
import org.eclipse.swt.widgets.Display;

public class CookTimer {
	private int minute;
	private int second;
	private Timer timer;
	private MicrowaveOven oven;

	public CookTimer(String timeString, MicrowaveOven oven) {
		String tokens[] = timeString.split(":");
		minute = Integer.parseInt(tokens[0]);
		second = Integer.parseInt(tokens[1]);
		this.oven = oven;
	}

	public CookTimer(int minute, int second, MicrowaveOven oven) {
		super();
		this.minute = minute;
		this.second = second;
		this.oven = oven;
	}

	public void tick() {
		second = (second - 1 + 60) % 60; // second = 0 => second = 59
		if (second == 59)
			minute = minute - 1;
	}

	public void start() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				tick();
				final DecimalFormat twoDigit = new DecimalFormat("00");
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						oven.setTimeString(twoDigit.format(minute) + ":"
								+ twoDigit.format(second));
						if (isDone()) {
							stop();
							oven.setStatus(MicrowaveOvenStatus.FINISHED);
						}
						oven.fireStatusChange();
					}
				});
			}
		}, 0, 1000);
	}
	public void stop() {
		timer.cancel();
	}
	public boolean isDone() {
		if (minute == 0 && second == 0) {
			return true;
		}
		return false;
	}
}
