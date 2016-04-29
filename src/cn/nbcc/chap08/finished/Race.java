/**
 * ��������cn.nbcc.chap08.snippets
 * �ļ�����TortoiseHareRace.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-6 ����03:59:56
 */
package cn.nbcc.chap08.finished;
import org.apache.commons.lang3.StringUtils;
import cn.nbcc.chap08.finished.Competitor.ResultStatus;

public class Race {
	protected int fieldLen;	//���ؿ��
	//������ʾǰ���ַ������ڹ�:������:
	private static final String Prefix = "����:";
	protected int displayWidth=0;
	public Race(int fieldLen) {
		this.fieldLen = fieldLen;
		 displayWidth= fieldLen+Prefix.length();
	}
	public static void main(String[] args) {
		final Race race = new Race(40);
		Competitor tortoise = new Competitor("�ڹ�", 1, race.fieldLen) {
			@Override
			public void goForward() {
				curStep += stepLen;
				String output = String.format("%s:%s", name,
						StringUtils.leftPad("T", getCurStep()));
				output = StringUtils.rightPad(output, race.displayWidth);
				System.out.printf("%s%s%n", output, "|");
			}
		};
		Competitor hare = new Competitor("����", 2, race.fieldLen) {
			@Override
			public void goForward() {
				String output = null;
				if ((int) (Math.random() * 10) % 2 == 0) {
					curStep += stepLen;
					output = String.format("%s:%s", name,
							StringUtils.leftPad("H", getCurStep()));
				} else
					output = String.format("%s:%s", name, "zZZZZ");
				output = StringUtils.rightPad(output, race.displayWidth);
				System.out.printf("%s%s%n", output, "|");
			}
		};
		Competitor monkey = new Competitor("����", 3, race.fieldLen) {
			public void goForward() {
				String output = null;
				if ((int) (Math.random() * 10) % 3 == 0) {
					curStep += stepLen;
					output = String.format("%s:%s", name,
							StringUtils.leftPad("M", getCurStep()));
				} else
					output = String.format("%s:%s", name, "play...");
				output = StringUtils.rightPad(output, race.displayWidth);
				System.out.printf("%s%s%n", output, "|");
			}
		};
		Competitor competitors[] = new Competitor[]{tortoise,hare,monkey};

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
				System.out.printf("����������%sӮ��",competitor.name);
			} 
		}
	}
}



