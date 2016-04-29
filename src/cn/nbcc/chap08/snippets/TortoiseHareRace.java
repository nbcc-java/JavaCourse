/**
 * ��������cn.nbcc.chap08.snippets
 * �ļ�����TortoiseHareRace.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-6 ����03:59:56
 */
package cn.nbcc.chap08.snippets;
public class TortoiseHareRace {
	
	
	public static void main(String[] args) {
		Tortoise tortoise = new Tortoise(Role.RACE_RANGE);
		Hare hare = new Hare(Role.RACE_RANGE);
		ThreadGroup tr = new ThreadGroup("Game");
		Thread tortoiseThread = new Thread(tr,tortoise);
		Thread hareThread = new Thread(tr,hare);
		tortoiseThread.start();
		hareThread.start();
	}
}

