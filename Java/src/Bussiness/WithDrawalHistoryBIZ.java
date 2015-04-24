package Bussiness;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import DAO.WithDrawalHistoryDAO;
import Entities.ATM;
import Entities.Account;
import Entities.Card;
import Entities.WithDrawalHistory;

/**
 * WithDrawalHistoryBIZ
 * 
 * @author HuongDV1
 * 
 */

public class WithDrawalHistoryBIZ {
	public List<WithDrawalHistory> getListWithdrawalHistory() throws FileNotFoundException, IOException
	{
		WithDrawalHistoryDAO withdrawalHistory=new WithDrawalHistoryDAO();
		return withdrawalHistory.readWithDrawalHistoryData();
	}
	public boolean withDrawOfChecking(String CarID, String accountID, double mount ) throws Exception
	{
		AccountBIZ accountBIZ = new AccountBIZ();
		List<Account> listAccount = accountBIZ.getListAccount();
		if(accountBIZ.getBalance(listAccount, accountID)>=(mount-100000) && (mount % 10000 ==0))
		{
			listAccount = accountBIZ.subtractMoney(listAccount, accountID, mount);
			accountBIZ.saveAccountData(listAccount);
			WithDrawalHistory withdrawal = new WithDrawalHistory();
			DateFormat dfm = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			withdrawal.setAmount(mount);
			withdrawal.setATMID(ATM.ATMID);
			withdrawal.setAccountID(accountID);
			Calendar cal = Calendar.getInstance();
			
			Date currentDateTime = dfm
			.parse(dfm.format(cal.getTime()));
			withdrawal.setTime(dfm.format(currentDateTime));
			addWithdrawalHistory(withdrawal);		
			return true;
		}
		else
			return false;
	}
	
	public boolean withDrawOfSaving(String CarID, String accountID, double mount )throws Exception
	{
		int number;
		double totalmoney;
		WithDrawalHistoryBIZ withd = new WithDrawalHistoryBIZ();
		List<WithDrawalHistory> listWithdrawal = withd.getListWithdrawalHistory();
		number = withd.getNumberWithdrawalofAccount(listWithdrawal, accountID);
		totalmoney = withd.getAmountMoneyWithdrawalofAccount(listWithdrawal, accountID);
		AccountBIZ accountBIZ = new AccountBIZ();
		List<Account> listAccount = accountBIZ.getListAccount();
		if(accountBIZ.getBalance(listAccount, accountID)>=mount && (mount % 10000 ==0)&&number<5&&(totalmoney+mount)<=25000000)
		{
			listAccount = accountBIZ.subtractMoney(listAccount, accountID, mount);
			accountBIZ.saveAccountData(listAccount);
			WithDrawalHistory withdrawal = new WithDrawalHistory();
			DateFormat dfm = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			withdrawal.setAmount(mount);
			withdrawal.setATMID(ATM.ATMID);
			withdrawal.setAccountID(accountID);
			Calendar cal = Calendar.getInstance();
			Date currentDateTime = dfm
			.parse(dfm.format(cal.getTime()));
			withdrawal.setTime(dfm.format(currentDateTime));
			addWithdrawalHistory(withdrawal);		
			return true;
		}
		else
			return false;
	}
	
	public void addWithdrawalHistory(WithDrawalHistory withdrawal)throws FileNotFoundException, IOException {
		WithDrawalHistoryDAO withdrawalHistoryDAO = new WithDrawalHistoryDAO();
		List<WithDrawalHistory> listWithdrawalHistory = withdrawalHistoryDAO.readWithDrawalHistoryData();
		listWithdrawalHistory.add(withdrawal);
		withdrawalHistoryDAO.saveWithDrawalHistoryData(listWithdrawalHistory);
	}
	public int getNumberWithdrawalofAccount(List<WithDrawalHistory> listWithdrawal,String accountID) throws ParseException, FileNotFoundException, IOException
	{
		WithDrawalHistory w=null;
				
		Calendar cal= Calendar.getInstance();
		//date
		DateFormat dfm = new SimpleDateFormat(
		"MM/dd/yyyy HH:mm:ss");
		 Date currentDateTime = dfm.parse(dfm.format(cal.getTime()));
			int count=0;	 
		 //
		 Date withdrawalDate=null;
		for(int i=0;i<listWithdrawal.size();++i)
		{
			w=listWithdrawal.get(i);
	
			withdrawalDate=dfm.parse(w.getTime());	
				
			if(w.getAccountID().equals(accountID)&& currentDateTime.getDate()==withdrawalDate.getDate()
					&& currentDateTime.getYear()==withdrawalDate.getYear()&&currentDateTime.getMonth()==withdrawalDate.getMonth())
			{
				count++; 
			}
		}
		return count;
	}
	/**
	 * 
	 * @param listWithdrawal
	 * @param accountID
	 * @return amount money per day of account
	 * @throws ParseException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public double getAmountMoneyWithdrawalofAccount(List<WithDrawalHistory> listWithdrawal,String accountID) throws ParseException, FileNotFoundException, IOException
	{
		WithDrawalHistory w=null;
				
		Calendar cal= Calendar.getInstance();
		//date
		DateFormat dfm = new SimpleDateFormat(
		"MM/dd/yyyy HH:mm:ss");
		 Date currentDateTime = dfm.parse(dfm.format(cal.getTime()));
			double amountWithdrawal=0;
		 //
		 Date withdrawalDate=null;
		for(int i=0;i<listWithdrawal.size();++i)
		{
			w=listWithdrawal.get(i);
	
			withdrawalDate=dfm.parse(w.getTime());	
				
			if(w.getAccountID().equals(accountID)&& currentDateTime.getDate()==withdrawalDate.getDate()
					&& currentDateTime.getYear()==withdrawalDate.getYear()&&currentDateTime.getMonth()==withdrawalDate.getMonth())
			{
				amountWithdrawal +=w.getAmount();
			}
		}
		return amountWithdrawal;
	}
}
