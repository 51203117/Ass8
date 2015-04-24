package Bussiness;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Entities.Card;

public class CardReaderBIZ {

	/**
	 * Check expiresDate of Card
	 * 
	 * @param listCard
	 * @param cardID
	 * @return
	 * @throws ParseException
	 */
	public boolean checkExpires(List<Card> listCard, String cardID)
			throws ParseException {

		if (listCard.size() > 0 && cardID != null) {
			DateFormat dfm = new SimpleDateFormat("MM/dd/yyyy");
			String strExpiresDate = null;
			Date expiresDate;

			Calendar cal = Calendar.getInstance();
			// get current datetime with format "MM/dd/yyyy HH:mm:ss"
			Date currentDate = dfm.parse(dfm.format(cal.getTime()));
			Card c;

			for (int i = 0; i < listCard.size(); ++i) {
				c = listCard.get(i);
				if (c.getCardID().equals(cardID)) {
					strExpiresDate = c.getExpiresDate();
					break;
				}
			}
			expiresDate = dfm.parse(strExpiresDate);
			// compare currentDate and expiresDate
			if (currentDate.compareTo(expiresDate) > 0)
				return false;
			else
				return true;
		} else
			return false;

	}

	public boolean checkLocked(List<Card> listCard, String cardID) {
		if (listCard.size() > 0 && cardID != null) {
			Card c = null;
			boolean result = false;
			for (int i = 0; i < listCard.size(); ++i) {
				c = listCard.get(i);
				if (c.getCardID().equals(cardID)
						&& c.getStatus().equals("available")) {
					result = true;
					break;
				}
			}
			return result;
		} else
			return false;
	}

	/**
	 * create by havt2 Check received account is the same bank of "FromAccount"
	 * 
	 * @param accountID
	 * @return True if received account is the same bank of Sender
	 */
	public boolean checkSameBank(String accountID) {
		if (accountID != null) {
			//check length of account
			if (accountID.length() == 13) {
				String str = "9704";// code bank of TienPhongBank
				String codeBankOfAccount = accountID.substring(0, 4);
				if (str.equals(codeBankOfAccount))
					return true;
				else
					return false;
			} else
				return false;
		} else
			return false;
	}

	public boolean checkExists(List<Card> listCard, String cardID) {
		if (listCard.size() > 0 && cardID != null) {
			Card c = null;
			boolean result = false;
			for (int i = 0; i < listCard.size(); ++i) {
				c = listCard.get(i);
				if (c.getCardID().equals(cardID)) {
					result = true;
					break;
				}
			}
			return result;
		} else
			return false;
	}

	public boolean checkPin(List<Card> listCard, String cardID, String pin) {
		if (listCard.size() > 0 && cardID != null && pin != null) {
			Card c = null;
			boolean result = false;
			for (int i = 0; i < listCard.size(); ++i) {
				c = listCard.get(i);
				if (c.getCardID().equals(cardID) && c.getPin().equals(pin)) {
					result = true;
					break;
				}
			}
			return result;
		} else
			return false;
	}
}
