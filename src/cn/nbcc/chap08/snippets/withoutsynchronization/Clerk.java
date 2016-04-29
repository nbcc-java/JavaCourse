/**
 * 所属包：cn.nbcc.chap08.snippets.synchronization
 * 文件名：Clerk.java
 * 创建者：郑哲
 * 创建时间：2015-5-31 下午08:39:09
 */
package cn.nbcc.chap08.snippets.withoutsynchronization;
public class Clerk implements Runnable{
	
	private Bank bank;
	private Transaction inTray;

	/**
	 * 
	 */
	public Clerk(Bank bank) {
		this.bank = bank;
		inTray = null;
	}

	public void doTransaction(Transaction transaction) {
		inTray = transaction;
	}
	
	@Override
	public void run() {
		while (true) {
			while (inTray==null) {
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			bank.doTransaction(inTray);
			inTray=null;
		}
	}
	public boolean isBusy() {
		return inTray!=null;
	}
	
}

