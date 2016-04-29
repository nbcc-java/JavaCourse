/**
 * 所属包：cn.nbcc.chap08.snippets
 * 文件名：ThreadDemo2.java
 * 创建者：郑哲
 * 创建时间：2014-6-4 上午08:48:35
 */
package cn.nbcc.chap08.snippets;
public class ThreadDemo2 implements Runnable {
	
	private int timeout = 1000;
	
	public ThreadDemo2(int timeout) {
		this.timeout = timeout;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(timeout);
				System.out.println(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void main(String[] args) {
			Thread t = new Thread(new ThreadDemo2(1000));
			t.start();
			Thread t1 = new Thread(new ThreadDemo2(500));
			t1.start();
		
	}

}

