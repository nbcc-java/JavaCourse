/**
 * 所属包：cn.nbcc.chap08.snippets
 * 文件名：DaemonSnippet.java
 * 创建者：郑哲
 * 创建时间：2014-5-13 下午09:56:34
 */
package cn.nbcc.chap08.snippets;
import java.util.Scanner;
public class UserThreadSnippet {
	static class UserThread implements Runnable {
		public void run() {
			for (int i=0;i<5;i++) {
				for (int count = 1; count <= 3; count++) {
					System.out.println("用户线程:" + count);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	static class DaemonThread implements Runnable{
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
					System.out.println("Daemon is running....");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
	}
	public static void main(String[] args) {
		Thread userThread = new Thread(new UserThread());
		userThread.start();
		Thread daemonThread = new Thread(new DaemonThread());
		daemonThread.setDaemon(true);
		daemonThread.start();
		System.out.println("isDaemon = " + userThread.isDaemon());
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
		System.out.println("End Of Main");
	}
}
