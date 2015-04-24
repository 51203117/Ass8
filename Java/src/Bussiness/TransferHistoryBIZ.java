package Bussiness;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import Commons.UIMessage;
import DAO.TransferHistoryDAO;
import Entities.ATM;
import Entities.Account;
import Entities.TransferHistory;

/**
 * TransferHistoryBIZ
 * 
 * @author havt2
 * 
 */
public class TransferHistoryBIZ {

	/**
	 * transfer money from SenderAccount to ReceivedAccount
	 * 
	 * @param senderAccountID
	 * @param receivedAccountID
	 * @param amountTransferMoney
	 * @return TransferHistory Object contains transfer information
	 * @throws Exception
	 */
	private String message;

	public String getMessage() {
		return message;
	}

	private TransferHistory transferHistory;

	public TransferHistory getTransferHistory() {
		return transferHistory;
	}

	public boolean transferMoney(String senderAccountID,
			String receivedAccountID, double amountTransferMoney)
			throws FileNotFoundException, IOException, ParseException {

		AccountBIZ accountBIZ = new AccountBIZ();
		List<Account> accountList = accountBIZ.getListAccount();

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		if (isValidReceivedAccount(senderAccountID, receivedAccountID)) {
			// check balance of fromAccount
			if (amountTransferMoney > 0) {
				if (accountBIZ.getBalance(accountList, senderAccountID) >= amountTransferMoney) {

					transferHistory = new TransferHistory();
					transferHistory.setReceivedAccount(receivedAccountID);
					transferHistory.setAmount(amountTransferMoney);

					Calendar cal = Calendar.getInstance();
					// get current datetime with format
					// "MM/dd/yyyy HH:mm:ss"
					Date currentDateTime = dateFormat.parse(dateFormat
							.format(cal.getTime()));

					transferHistory.setTime(dateFormat.format(currentDateTime));
					transferHistory.setSenderAccount(senderAccountID);
					transferHistory.setATMID(ATM.ATMID);
					transferHistory.setAmount(amountTransferMoney);
					// add transaction information to data
					saveTransferInfo(senderAccountID, receivedAccountID,
							amountTransferMoney, accountBIZ, accountList,
							transferHistory);

					return true;
				} else {
					message = UIMessage.ERR_MONEY_NOT_ENOUGH;
					return false;
				}
			} else {
				message = UIMessage.ERR_TRANSFERMONEY;
				return false;
			}
		} else {
			return false;
		}
	}

	private void saveTransferInfo(String senderAccountID,
			String receivedAccountID, double amountTransferMoney,
			AccountBIZ accountBIZ, List<Account> accountList,
			TransferHistory trans) throws IOException, FileNotFoundException {
		// subtract balance of fromAccount
		accountList = accountBIZ.subtractMoney(accountList, senderAccountID,
				amountTransferMoney);

		// add transfer amount money to receivedAccount
		accountList = accountBIZ.addMoney(accountList, receivedAccountID,
				amountTransferMoney);

		// Save data to text file
		accountBIZ.saveAccountData(accountList);

		// add transaction history
		addTransferHistory(trans);
	}

	/**
	 * Check received Account
	 * 
	 * @param senderAccountID
	 * @param receivedAccountID
	 * @return true if received account id is valid
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean isValidReceivedAccount(String senderAccountID,
			String receivedAccountID) throws NullPointerException,
			FileNotFoundException, IOException {
		CardReaderBIZ cardReaderBIZ = new CardReaderBIZ();
		AccountBIZ accountBIZ = new AccountBIZ();

		List<Account> accountList = accountBIZ.getListAccount();

		// if senderAccount = received Account ==> false
		if (receivedAccountID.equals(senderAccountID)) {
			message = UIMessage.ERR_REACCOUNT;
			return false;
		}
		// check receivedAccount and fromAccount are the same bank
		if (!cardReaderBIZ.checkSameBank(receivedAccountID)) {
			message = UIMessage.ERR_REACCOUNT;
			return false;
		}
		// check receivedAccount is the same bank but it don't exists?
		if (!accountBIZ.checkAccountExists(accountList, receivedAccountID)) {
			message = UIMessage.ERR_REACCOUNT;
			return false;
		}
		// check receivedAccount is available (not locked)
		if (!accountBIZ.checkLockedAcount(accountList, receivedAccountID)) {
			message = UIMessage.ERR_REACCOUNT;
			return false;
		}

		return true;
	}

	/**
	 * Add transfer information to TransferHistory.txt file
	 * 
	 * @param a
	 *            transferHistory object
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void addTransferHistory(TransferHistory trans)
			throws FileNotFoundException, IOException {

		TransferHistoryDAO transHistoryDAO = new TransferHistoryDAO();

		List<TransferHistory> transHistoryList = transHistoryDAO
				.readTransferHistoryData();

		transHistoryList.add(trans);
		transHistoryDAO.saveTransferHistoryData(transHistoryList);
	}
}
