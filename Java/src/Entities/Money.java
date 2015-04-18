package Entities;

public class Money {

	private String moneyID;
	private int denomination;
	private int quantity;
	public String getMoneyID() {
		return moneyID;
	}
	public void setMoneyID(String moneyID) {
		this.moneyID = moneyID;
	}
	public int getDenomination() {
		return denomination;
	}
	public void setDenomination(int denomination) {
		this.denomination = denomination;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
