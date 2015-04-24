package Entities;

public class WithDrawalHistory {
	private String ATMID;
	private String accountID;
	private double Amount;
	private String Time;
	public String getATMID() {
		return ATMID;
	}
	public void setATMID(String aTMID) {
		ATMID = aTMID;
	}
	
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
}
