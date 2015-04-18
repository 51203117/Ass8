package Bussiness;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import DAO.AccountDAO;
import Entities.Account;

public class AccountBIZ {
	public List<Account> getListAccount() throws FileNotFoundException,
			IOException {
		AccountDAO accountDAO = new AccountDAO();
		return accountDAO.readBankAccountData();
	}

	/**
	 * 
	 * @param listAcc
	 * @param accID
	 * @return AccountTypeID of Account
	 */
	public String getAccountTypeOfAccount(List<Account> listAcc, String accID) {
		String accountTypeID = "";
		Account account = null;
		for (int i = 0; i < listAcc.size(); ++i) {
			account = listAcc.get(i);
			if (account.getAccountID().equals(accID)) {
				accountTypeID = account.getAccountTypeID();
				break;
			}

		}
		return accountTypeID;
	}
	public String getCustIDOfAccount(List<Account> listAcc, String accountID) {
		String custID = "";
		Account account = null;
		for (int i = 0; i < listAcc.size(); ++i) {
			account = listAcc.get(i);
			if (account.getAccountID().equals(accountID)) {
				custID = account.getCustID() ;
				break;
			}

		}
		return custID;
	}

	/**
	 * 
	 * @param listAcc
	 * @param accID
	 * @return Balance of Account
	 */
	public double getBalance(List<Account> listAcc, String accID) {
		double balance = 0;
		Account account = null;
		for (int i = 0; i < listAcc.size(); ++i) {
			account = listAcc.get(i);
			if (account.getAccountID().equals(accID)) {
				balance = account.getBalance();
				break;
			}
		}
		return balance;
	}
/**
 * 
 * @param listAcc
 * @param accID
 * @return False if Account is available
 */
	public boolean checkLockedAcount(List<Account> listAcc, String accID) {
		boolean result = false;
		Account account = null;
		for (int i = 0; i < listAcc.size(); ++i) {
			account = listAcc.get(i);
			if (account.getAccountID().equals(accID)
					&& account.getLocked().equals("available")) {
				result = true;
				break;
			}
		}
		return result;
	}
	/**
	 * Check Account exists in bank?
	 * @param listAcc
	 * @param accID
	 * @return true if Account exists
	 */
	public boolean checkAccountExists(List<Account> listAcc, String accID)
	{
		boolean result = false;
		Account account = null;
		for (int i = 0; i < listAcc.size(); ++i) {
			account = listAcc.get(i);
			if (account.getAccountID().equals(accID)) {
				result = true;
				break;
			}
		}
		return result;
	}
	/**
	 * Save data from List<Account> listAccount to Account.txt file
	 * @param listAccount
	 * @throws IOException
	 */
	public void saveAccountData(List<Account> listAccount) throws IOException
	{
		AccountDAO accountDAO=new AccountDAO();
		accountDAO.saveAccountData(listAccount);
	}
	/**
	 * Subtract balance of "FromAccount"
	 * @param listAccount
	 * @param senderAccountID
	 * @param transferMoney
	 * @return List account after subtract transfer money
	 * 
	 * 	 */
	public List<Account> subtractMoney(List<Account> listAccount,String senderAccountID, double transferMoney)
	{
		Account account = null;
		for (int i = 0; i < listAccount.size(); ++i) {
			account = listAccount.get(i);
			if (account.getAccountID().equals(senderAccountID)) {
				double oldBalance= account.getBalance();
				double newBalance= oldBalance-transferMoney;
				account.setBalance(newBalance);				
				break;
			}
			
		}
		return listAccount;
	}
	/**
	 * 
	 * @param listAccount
	 * @param receivedAccountID
	 * @param transferMoney
	 * @return List account after add transfer money
	 */
	public List<Account> addMoney(List<Account> listAccount,String receivedAccountID, double transferMoney)
	{
		Account account = null;
		for (int i = 0; i < listAccount.size(); ++i) {
			account = listAccount.get(i);
			if (account.getAccountID().equals(receivedAccountID)) {
				double oldBalance= account.getBalance();
				double newBalance= oldBalance+transferMoney;
				account.setBalance(newBalance);	
				break;
			}			
		}
		return listAccount;
	}
}
