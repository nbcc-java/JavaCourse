/**
 * ��������cn.nbcc.chap08.snippets
 * �ļ�����Share.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-22 ����10:12:22
 */
package cn.nbcc.chap08.snippets;
class Variable1{
	static int i=0,j=0;
	static  Object lock = new Object();
	static  void increment(){
		synchronized(lock)
		{
			i++;j++;
		}
	}
	static synchronized void print(){
		synchronized (lock) {
			System.out.printf("i=%d,j=%d%n", i,j);
		}
	}
}
public class Share {
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			public void run() {
				while (true) {
						Variable1.increment();
				}
			}
		};
		Thread t2 =new Thread(){
			public void run() {
				while (true) {
						Variable1.print();
				}
			}
		};
		t1.start();
		t2.start();
	}
}

