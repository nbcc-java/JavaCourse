/**
 * 所属包：cn.nbcc.chap08.snippets.synchronization
 * 文件名：Bank.java
 * 创建者：郑哲
 * 创建时间：2015-5-31 下午08:39:51
 */
package cn.nbcc.chap08.snippets.withoutsynchronization;
public class Bank {
	public void doTransaction(Transaction transaction) {
		int balance = transaction.getAccount().getBalance();
		switch (transaction.getTransactionType()) {
		case CREDIT:
			//Credits require a lot of checks...
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			balance+=transaction.getAmount();
			
			break;
		case DEBIT:
			//Debits require even more checks...
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			balance-=transaction.getAmount();
			break;

		default:
			System.out.println("Invalid transaction");
			break;
		}
		System.out.println("Do Transaction:"+transaction);
		transaction.getAccount().setBalance(balance);
	}
}

