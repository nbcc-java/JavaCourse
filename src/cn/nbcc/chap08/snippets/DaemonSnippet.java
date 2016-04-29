/**
 * ��������cn.nbcc.chap08.snippets
 * �ļ�����DaemonSnippet.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-13 ����09:56:34
 */
package cn.nbcc.chap08.snippets;
import java.util.Scanner;
public class DaemonSnippet {
	static class DaemonRunner implements Runnable {
		public void run() {
			while (true) {
				for (int count = 1; count <= 3; count++) {
					System.out.println("�ػ��߳�:" + count);
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
		// ����Ϊ�ػ�����
		daemonThread.setDaemon(true);
		daemonThread.start();
		System.out.println("isDaemon = " + daemonThread.isDaemon());
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
	}
}
