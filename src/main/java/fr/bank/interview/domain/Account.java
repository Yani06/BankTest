package fr.bank.interview.domain;

import java.util.Date;

/**
 * Bank Account model
 * 
 * @author yidoughi
 *
 */
public class Account {
	
	private int id;
	private Date creationDate;
	private Date lastOperationDate;
	private double balance;
	private int maxWithdrawAmount;
	private int minWithdrawAmount;

	public Account(int id, Date creationDate, Date lastOperationDate, double balance, int maxWithdrawAmount,
			int minWithdrawAmount) {

		this.id = id;
		this.creationDate = creationDate;
		this.lastOperationDate = lastOperationDate;
		this.balance = balance;
		this.maxWithdrawAmount = maxWithdrawAmount;
		this.minWithdrawAmount = minWithdrawAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastOperationDate() {
		return lastOperationDate;
	}

	public void setLastOperationDate(Date lastOperationDate) {
		this.lastOperationDate = lastOperationDate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getMaxWithdrawAmount() {
		return maxWithdrawAmount;
	}

	public void setMaxWithdrawAmount(int maxWithdrawAmount) {
		this.maxWithdrawAmount = maxWithdrawAmount;
	}

	public int getMinWithdrawAmount() {
		return minWithdrawAmount;
	}

	public void setMinWithdrawAmount(int minWithdrawAmount) {
		this.minWithdrawAmount = minWithdrawAmount;
	}

	public String toString() {
		return "Account [id=" + id + ", creationDate=" + creationDate + ", lastOperationDate=" + lastOperationDate
				+ ", balance=" + balance + ", maxWithdrawAmount=" + maxWithdrawAmount + ", minWithdrawAmount="
				+ minWithdrawAmount + "]";
	}

}
