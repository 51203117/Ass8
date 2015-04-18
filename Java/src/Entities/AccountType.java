package Entities;

public class AccountType {
	private String accountTypeID;
	private String accountTypeName;
	private float overDraft;
	private int numberOfWithdrawal; // limit number of withdrawal a day
	private double numberOfWithdrawCash;// limit amount money withdrawal a day
	public String getAccountTypeID() {
		return accountTypeID;
	}
	public void setAccountTypeID(String accountTypeID) {
		this.accountTypeID = accountTypeID;
	}
	public String getAccountTypeName() {
		return accountTypeName;
	}
	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}
	public float getOverDraft() {
		return overDraft;
	}
	public void setOverDraft(float overDraft) {
		this.overDraft = overDraft;
	}
	public int getNumberOfWithdrawal() {
		return numberOfWithdrawal;
	}
	public void setNumberOfWithdrawal(int numberOfWithdrawal) {
		this.numberOfWithdrawal = numberOfWithdrawal;
	}
	public double getNumberOfWithdrawCash() {
		return numberOfWithdrawCash;
	}
	public void setNumberOfWithdrawCash( double  numberOfWithdrawCash) {
		this.numberOfWithdrawCash = numberOfWithdrawCash;
	}
}
