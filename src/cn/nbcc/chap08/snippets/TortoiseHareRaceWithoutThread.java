/**
 * ��������cn.nbcc.chap08.snippets
 * �ļ�����TortoiseHareRaceWithoutThread.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-6 ����03:46:54
 */
package cn.nbcc.chap08.snippets;
public class TortoiseHareRaceWithoutThread {
	public static void main(String[] args) throws InterruptedException {
		boolean[] flags = {true,false};
		int totalStep = 0;
		int tortoiseStep = 0;
		int hareStep = 0;
		System.out.println("�������ܿ�ʼ...");
		while (tortoiseStep<totalStep&&hareStep<tortoiseStep) {
			Thread.sleep(1000);
			tortoiseStep++;
			System.out.printf("�ڹ�����%d��...%n",tortoiseStep);
			boolean isHarseSleep = flags[((int)Math.random()*10)%2];
			if (isHarseSleep) {
				System.out.println("����˯����zzzz");
			}else {
				hareStep+=2;
				System.out.printf("��������%d��...%n",hareStep);
			}
		}
	}
}

