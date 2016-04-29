/**
 * 所属包：cn.nbcc.chap08.snippets.synchronization
 * 文件名：BankApp.java
 * 创建者：郑哲
 * 创建时间：2015-5-31 下午09:03:10
 */
package cn.nbcc.chap08.snippets.synchronizationblock;

import java.util.Random;

import cn.nbcc.chap08.snippets.synchronizationblock.Transaction.TransactionsType;


public class BankApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] initialBalance = {500,800};
		int[] totalCredit = new int[initialBalance.length];
		int[] totalDebits = new int[initialBalance.length];
		int transactionCount = 20;
		
		//Create the account ,the bank ,and the clerks...
		Bank bank = new Bank();
		Clerk clerk1 = new Clerk(bank);
		Clerk clerk2 = new Clerk(bank);
		Account[] accounts = new Account[initialBalance.length];
		for (int i = 0; i < initialBalance.length; i++) {
			accounts[i] = new Account(i+1, initialBalance[i]);
			totalCredit[i]=totalDebits[i]=0;
		}
		
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
		int select = 0;
		for (int i = 0; i < transactionCount; i++) {
			
			select = rand.nextInt(accounts.length);
			amount = 50+rand.nextInt(26);
			transaction = new Transaction(TransactionsType.CREDIT, accounts[select], amount);
			totalCredit[select] += amount;
			
			while (clerk1.isBusy()) {
				try {
					Thread.sleep(25);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			clerk1.doTransaction(transaction);
			
			select = rand.nextInt(accounts.length);
			amount = 30+rand.nextInt(31);
			transaction = new Transaction(TransactionsType.DEBIT, accounts[select], amount);
			totalDebits[select]+=amount;
			
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
		for (int i = 0; i < accounts.length; i++) {
			System.out.println(
					"Original balance:$"+initialBalance+"\n"+
					"Total credits   :$"+totalCredit[i]+"\n"+
					"Total debits    :$"+totalDebits[i]+"\n"+
					"Final balance   :$"+accounts[i].getBalance()+"\n"+
					"Should be       :$"+(initialBalance[i]+totalCredit[i]-totalDebits[i]));
		}
	}
}

