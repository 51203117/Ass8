package Entities;

public class Card {

	private String cardID;
	private String accountID;
	private String pin;
	private String status;
	private String validFrom;
	private String expiresDate;

	public String getCardID() {
		return cardID;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}

	public String getExpiresDate() {
		return expiresDate;
	}

	public void setExpiresDate(String expiresDate) {
		this.expiresDate = expiresDate;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getAccountID() {
		return accountID;
	}

}
