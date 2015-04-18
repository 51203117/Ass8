package Entities;

public class TransferHistory {

	private String ATMID;
	private String senderAccount;
	private double amount;
	private String time;
	private String receivedAccount;

	public String getATMID() {
		return ATMID;
	}

	public void setATMID(String aTMID) {
		ATMID = aTMID;
	}

	public String getSenderAccount() {
		return senderAccount;
	}

	public void setSenderAccount(String senderAccountID) {
		this.senderAccount = senderAccountID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getReceivedAccount() {
		return receivedAccount;
	}

	public void setReceivedAccount(String receivedAccount) {
		this.receivedAccount = receivedAccount;
	}

}
