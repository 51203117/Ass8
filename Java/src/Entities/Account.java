package Entities;

public class Account {	

	private String accountID;
	private String accountTypeID;
	private String custID;
	private double balance;
	private String locked;
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public String getAccountTypeID() {
		return accountTypeID;
	}
	public void setAccountTypeID(String accountTypeID) {
		this.accountTypeID = accountTypeID;
	}
	public String getCustID() {
		return custID;
	}
	public void setCustID(String custID) {
		this.custID = custID;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getLocked() {
		return locked;
	}
	public void setLocked(String loked) {
		this.locked = loked;
	}
	
}
