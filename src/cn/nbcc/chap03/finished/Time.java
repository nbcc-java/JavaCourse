/**
 * ��������cn.nbcc.chap03.exercise
 * �ļ�����Time.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-4 ����10:57:51
 */
package cn.nbcc.chap03.finished;

public class Time {

	private int hour;
	private int minute;
	private int second;
	public Time() {
		this(0,0,0);
	}
	public Time(String timeString ) {
		String t[] = timeString.split(":");
		setHour(Integer.parseInt(t[0]));
		setMinute(Integer.parseInt(t[1]));
		setSecond(Integer.parseInt(t[2]));
	}

	public Time(int hour, int minute) {
		this(hour,minute,0);
	}

	public Time(int h, int m, int s) {
		setTime(h, m, s);
	}
	public void setTime(int h, int m, int s) {
		setHour(h);
		setMinute(m);
		setSecond(s);
	}
	/**
	 * ����Сʱ
	 * @param hour the hour to set
	 */
	public void setHour(int hour) {
		if (hour>=0&&hour<24) {
			this.hour = hour;
		}
	}
	/**
	 * ����Сʱ
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * ��÷���
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * ���÷���
	 * @param minute the minute to set
	 */
	public void setMinute(int minute) {
		if (minute>=0&&minute<60) {
			this.minute = minute;
		}
	}

	/**
	 * �������
	 * @return the second
	 */
	public int getSecond() {
		return second;
	}

	/**
	 * ��������
	 * @param second the second to set
	 */
	public void setSecond(int second) {
		if (second>=0&&second<60) {
			this.second = second;
		}
	}
	
	public void tick() {
		second = (second+1)%60;
		if (second==0) {
			minute=(minute+1)%60;
			if (minute==0) {
				hour=(hour+1)%24;
			}
		}
	}
	public String toStdString() {
		String s = String.format("%02d:%02d:%02d",hour,minute,second);
		return s;
	}
	public String toMiliString() {
		String s = String.format("%02d:%02d:%02d %s",(hour==0||hour==12?12:hour%12),minute,second,hour>=12?"PM":"AM");
		return s ;
	}
}

