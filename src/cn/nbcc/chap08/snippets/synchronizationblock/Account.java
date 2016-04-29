/**
 * 所属包：cn.nbcc.chap08.snippets.synchronization
 * 文件名：Account.java
 * 创建者：郑哲
 * 创建时间：2015-5-31 下午08:39:56
 */
package cn.nbcc.chap08.snippets.synchronizationblock;
public class Account {
	private int balance;
	private int accountNumber;
	public Account(int accountNumber,int balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	@Override
	public String toString() {
		return "A/C No."+accountNumber+":$"+balance;
	}
}

