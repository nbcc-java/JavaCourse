/**
 * ��������cn.nbcc.chap08.snippets
 * �ļ�����DaemonSnippet.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-13 ����09:56:34
 */
package cn.nbcc.chap08.snippets;
import java.util.Scanner;
public class UserThreadSnippet {
	static class UserThread implements Runnable {
		public void run() {
			for (int i=0;i<5;i++) {
				for (int count = 1; count <= 3; count++) {
					System.out.println("�û��߳�:" + count);
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
		// �������룬ʹ�����ڴ�ͣ�٣�һ�����ܵ��û�����,main�߳̽�����JVM�˳�!
		scanner.next();
		// AddShutdownHook��������JVMֹͣʱҪ�������¼���
		// ��JVM�˳�ʱ����ӡJVM Exit���.
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println("JVM Exit!");
			}
		});
		System.out.println("End Of Main");
	}
}
