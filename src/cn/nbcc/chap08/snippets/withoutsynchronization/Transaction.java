/**
 * ��������cn.nbcc.chap08.snippets.synchronization
 * �ļ�����Transaction.java
 * �����ߣ�֣��
 * ����ʱ�䣺2015-5-31 ����08:40:05
 */
package cn.nbcc.chap08.snippets.withoutsynchronization;
public class Transaction {
	public enum TransactionsType {
		DEBIT,CREDIT;
	}
	
	private TransactionsType type;
	private Account acc; 
	private int amount;
	
	public Account getAccount() {
		return acc;
	}

	public TransactionsType getTransactionType() {
		return type;
	}
	public int getAmount() {
		return amount;
	}

	public Transaction(TransactionsType tt, Account acc, int amount) {
		this.type = tt;
		this.acc = acc;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return type+"A//C:"+acc+":$"+amount;
	}
}

