/**
 * ��������cn.nbcc.chap03.exercise
 * �ļ�����App.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-4 ����11:10:42
 */
package cn.nbcc.chap03.finished;

import java.util.Timer;
import java.util.TimerTask;

public class App {
	public static void main(String[] args) {
		final Time t = new Time();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				t.tick();
				System.out.println(t.toStdString());
				System.out.println(t.toMiliString());
			}
		};
		Timer timer = new Timer();
		timer.schedule(task, 0,1000);
	}
}

