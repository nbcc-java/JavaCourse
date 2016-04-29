/**
 * 所属包：cn.nbcc.chap08.snippets
 * 文件名：TortoiseHareRaceWithoutThread.java
 * 创建者：郑哲
 * 创建时间：2014-5-6 下午03:46:54
 */
package cn.nbcc.chap08.snippets;
public class TortoiseHareRaceWithoutThread {
	public static void main(String[] args) throws InterruptedException {
		boolean[] flags = {true,false};
		int totalStep = 0;
		int tortoiseStep = 0;
		int hareStep = 0;
		System.out.println("龟兔赛跑开始...");
		while (tortoiseStep<totalStep&&hareStep<tortoiseStep) {
			Thread.sleep(1000);
			tortoiseStep++;
			System.out.printf("乌龟跑了%d步...%n",tortoiseStep);
			boolean isHarseSleep = flags[((int)Math.random()*10)%2];
			if (isHarseSleep) {
				System.out.println("兔子睡着了zzzz");
			}else {
				hareStep+=2;
				System.out.printf("兔子跑了%d步...%n",hareStep);
			}
		}
	}
}

