/**
 * 所属包：cn.nbcc.chap08.snippets.synchronization
 * 文件名：BankApp.java
 * 创建者：郑哲
 * 创建时间：2015-5-31 下午09:03:10
 */
package cn.nbcc.chap08.snippets.withoutsynchronization;

import java.util.Random;

import cn.nbcc.chap08.snippets.withoutsynchronization.Transaction.TransactionsType;

public class BankApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int initialBalance = 500;
		int totalCredit = 0;
		int totalDebits = 0;
		int transactionCount = 20;
		
		//Create the account ,the bank ,and the clerks...
		Bank bank = new Bank();
		Clerk clerk1 = new Clerk(bank);
		Clerk clerk2 = new Clerk(bank);
		Account account = new Account(1, initialBalance);
		
		//Create the threads for the clerk as daemon,and start them off
		Thread clerkThread1 = new Thread(clerk1);
		Thread clerkThread2 = new Thread(clerk2);
		clerkThread1.setDaemon(true);
		clerkThread2.setDaemon(true);
		clerkThread1.start();
		clerkThread2.start();
		
		//Generate the transactions of each type and pass to the clerk
		Random rand = new Random();
		Transaction transaction ;
		int amount = 0;
		for (int i = 0; i < transactionCount; i++) {
			amount = 50+rand.nextInt(26);
			transaction = new Transaction(TransactionsType.CREDIT, account, amount);
			totalCredit += amount;
			
			while (clerk1.isBusy()) {
				try {
					Thread.sleep(25);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			clerk1.doTransaction(transaction);
			
			amount = 30+rand.nextInt(31);
			transaction = new Transaction(TransactionsType.DEBIT, account, amount);
			totalDebits+=amount;
			
			while (clerk2.isBusy()) {
				try {
					Thread.sleep(25);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			clerk2.doTransaction(transaction);
			
		}
		
		//wait until both clerks are done
		while (clerk1.isBusy()||clerk2.isBusy()) {
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//Now output the results
		System.out.println(
				"Original balance:$"+initialBalance+"\n"+
				"Total credits   :$"+totalCredit+"\n"+
				"Total debits    :$"+totalDebits+"\n"+
				"Final balance   :$"+account.getBalance()+"\n"+
				"Should be       :$"+(initialBalance+totalCredit-totalDebits));
	}

}

