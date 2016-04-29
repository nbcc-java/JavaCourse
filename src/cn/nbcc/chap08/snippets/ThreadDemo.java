/**
 * ��������cn.nbcc.chap08.snippets
 * �ļ�����ThreadDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-6-4 ����08:40:37
 */
package cn.nbcc.chap08.snippets;
public class ThreadDemo extends Thread {
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Thread main...before start");
		ThreadDemo t1 = new ThreadDemo();
		t1.start();
		System.out.println("Thread main... after start");

	}

}

