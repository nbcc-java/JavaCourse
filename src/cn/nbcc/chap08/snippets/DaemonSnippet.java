/**
 * 所属包：cn.nbcc.chap08.snippets
 * 文件名：DaemonSnippet.java
 * 创建者：郑哲
 * 创建时间：2014-5-13 下午09:56:34
 */
package cn.nbcc.chap08.snippets;
import java.util.Scanner;
public class DaemonSnippet {
	static class DaemonRunner implements Runnable {
		public void run() {
			while (true) {
				for (int count = 1; count <= 3; count++) {
					System.out.println("守护线程:" + count);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Thread daemonThread = new Thread(new DaemonRunner());
		// 设置为守护进程
		daemonThread.setDaemon(true);
		daemonThread.start();
		System.out.println("isDaemon = " + daemonThread.isDaemon());
		Scanner scanner = new Scanner(System.in);
		// 接受输入，使程序在此停顿，一旦接受到用户输入,main线程结束，JVM退出!
		scanner.next();
		// AddShutdownHook方法增加JVM停止时要做处理事件：
		// 当JVM退出时，打印JVM Exit语句.
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println("JVM Exit!");
			}
		});
	}
}
