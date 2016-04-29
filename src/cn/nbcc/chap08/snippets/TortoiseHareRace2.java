/**
 * 所属包：cn.nbcc.chap08.snippets
 * 文件名：TortoiseHareRace.java
 * 创建者：郑哲
 * 创建时间：2014-5-6 下午03:59:56
 */
package cn.nbcc.chap08.snippets;

import org.apache.commons.lang3.StringUtils;
import cn.nbcc.chap08.snippets.Competitor.ResultStatus;

public class TortoiseHareRace2 {
	public static void main(String[] args) {
		int fieldLen = 40;
		Competitor tortoise = new Competitor("乌龟", 1, fieldLen) {
			@Override
			public void goForward() {
				curStep += stepLen;
				String output = String.format("%s:%s", name,
						StringUtils.leftPad("T", getCurStep()));
				output = StringUtils.rightPad(output, displayWidth);
				System.out.printf("%s%s%n", output, "|");
			}
		};
		Competitor monkey= new Competitor("猴子",3,fieldLen){
			public void goForward() {
				String output = null;
				if ((int) (Math.random() * 10) % 3 == 0) {
					curStep += stepLen;
					output = String.format("%s:%s", name,
							StringUtils.leftPad("M", getCurStep()));
				} else
					output = String.format("%s:%s", name, "play...");
				output = StringUtils.rightPad(output, displayWidth);
				System.out.printf("%s%s%n", output, "|");
			}
		};
		Competitor hare = new Competitor("兔子", 2, fieldLen) {
			@Override
			public void goForward() {
				String output = null;
				if ((int) (Math.random() * 10) % 2 == 0) {
					curStep += stepLen;
					output = String.format("%s:%s", name,
							StringUtils.leftPad("H", getCurStep()));
				} else
					output = String.format("%s:%s", name, "zZZZZ");
				output = StringUtils.rightPad(output, displayWidth);
				System.out.printf("%s%s%n", output, "|");
			}
		};
		Competitor competitors[] = new Competitor[]{tortoise,monkey,hare};
		for (Competitor competitor : competitors) {
			competitor.start();
		}
		for (Competitor competitor : competitors) {
			try {
				competitor.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for (Competitor competitor : competitors) {
			if (competitor.getResultStatus() == ResultStatus.WIN) {
				System.out.printf("比赛结束，%s赢！",competitor.name);
			} 
		}
	}
}
