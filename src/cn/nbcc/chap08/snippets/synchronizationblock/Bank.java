/**
 * 所属包：cn.nbcc.chap08.snippets.synchronization
 * 文件名：Bank.java
 * 创建者：郑哲
 * 创建时间：2015-5-31 下午08:39:51
 */
package cn.nbcc.chap08.snippets.synchronizationblock;
public class Bank {
	public void doTransaction(Transaction transaction) {
		
		switch (transaction.getTransactionType()) {
		case CREDIT:
			//Credits require a lot of checks...
			synchronized (transaction.getAccount()) {
				int balance = transaction.getAccount().getBalance();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
				balance+=transaction.getAmount();
				transaction.getAccount().setBalance(balance);
			}
			
			break;
		case DEBIT:
			synchronized (transaction.getAccount()) {
				//Debits require even more checks...
				int balance = transaction.getAccount().getBalance();
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
				balance -= transaction.getAmount();
				transaction.getAccount().setBalance(balance);
			}
			break;

		default:
			System.out.println("Invalid transaction");
			break;
		}
		System.out.println("Do Transaction:"+transaction);
		
	}
}

