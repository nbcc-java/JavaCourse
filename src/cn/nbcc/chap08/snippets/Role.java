/**
 * ��������cn.nbcc.chap08.snippets
 * �ļ�����Role.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-6 ����08:48:25
 */
package cn.nbcc.chap08.snippets;

import org.apache.commons.lang3.StringUtils;


public abstract  class Role {

	protected int totalStep;
	protected int step;
	protected final static int NAME_LEN = "�ڹ�:".length();
	public static  int RACE_RANGE = 20;
	public static  int SCREEN_WIDTH = RACE_RANGE*2+Role.NAME_LEN;
	protected boolean isFinished = false;

	public Role(int totalStep) {
		this.totalStep = totalStep;
	}

	public int getFootPosInProgress() {
		return (int)((double)step/totalStep*(getFinishingLinePos()-NAME_LEN));
	}

	public int getFinishingLinePos() {
		return SCREEN_WIDTH;
	}

	public void printMessage(String role,String msg){
		String output = String.format("%s:%s", role,msg);
		System.out.printf("%s%n",output);
		
	}
	public String getFootPrint(String role, String footPrint) {
		String output = String.format("%s:%s", role,footPrint);
		return String.format("%s%s%n",StringUtils.rightPad(output, getFinishingLinePos()),"|");
	}

	public abstract void stepForward();
	public boolean isFinished(){
		return getFootPosInProgress()>=getFinishingLinePos();
	}
}

