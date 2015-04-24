package Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Bussiness.AccountBIZ;
import Bussiness.CardReaderBIZ;
import Bussiness.TransferHistoryBIZ;
import DAO.TransferHistoryDAO;
import Entities.ATM;
import Entities.Account;
import Entities.TransferHistory;

/**
 * 
 * @create by havt2
 * 
 */
public class HaVT2_Testing extends TestCase {

	@Before
	public void setUp() throws Exception {
		TransferHistory trans = new TransferHistory();
		trans.setAmount(5000000);
		trans.setATMID(ATM.ATMID);
		trans.setReceivedAccount("9704321456981");
		trans.setSenderAccount("9704321456987");
		trans.setTime("1/1/2013 15:30:00");
		listTrans.add(trans);

		trans = new TransferHistory();
		trans.setAmount(2000000);
		trans.setATMID(ATM.ATMID);
		trans.setReceivedAccount("9704321456987");
		trans.setSenderAccount("9704321456981");
		trans.setTime("2/1/2012 16:30:00");

		listTrans.add(trans);

	}

	@After
	public void tearDown() throws Exception {
	}

	List<TransferHistory> listTrans = new ArrayList<TransferHistory>();
	TransferHistoryBIZ transBIZ = new TransferHistoryBIZ();

	/**
	 * Test method boolean checkSameBank(String accountID) of CardReaderBIZ
	 * class
	 */
	public void testCheckSameBank_Input_Account_Null_Return_False() {
		// check null
		String accountID = null;
		CardReaderBIZ cardReaderBIZ = new CardReaderBIZ();
		boolean actual = cardReaderBIZ.checkSameBank(accountID);
		assertFalse(actual);
	}

	public void testCheckSameBank_Input_Account_Return_False() {
		// check null
		String accountID = "9770123454323";// true length but not the same bank
		CardReaderBIZ cardReaderBIZ = new CardReaderBIZ();
		boolean actual = cardReaderBIZ.checkSameBank(accountID);
		assertFalse(actual);

	}

	public void testCheckSameBank_Input_Account_Length_Less_Than_13_Return_False() {
		// check null
		String accountID = "9704123";
		CardReaderBIZ cardReaderBIZ = new CardReaderBIZ();
		boolean actual = cardReaderBIZ.checkSameBank(accountID);
		assertFalse(actual);

	}

	public void testCheckSameBank_Input_Account_Length_Large_Than_13_Return_False() {
		// check null
		String accountID = "970412332321456541";
		CardReaderBIZ cardReaderBIZ = new CardReaderBIZ();
		boolean actual = cardReaderBIZ.checkSameBank(accountID);
		assertFalse(actual);

	}

	public void testCheckSameBank_Input_Account_Return_True() {
		String accountID = "9704123321234";

		CardReaderBIZ cardReaderBIZ = new CardReaderBIZ();
		boolean actual = cardReaderBIZ.checkSameBank(accountID);
		assertTrue(actual);
	}

	/**
	 * Test methods void saveTransferHistoryData(List<TransferHistory>
	 * listTrans) of TransferHistoryDAO class
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void testSaveTransferHistoryData_Input_ListTransferHistory_HasItems()
			throws FileNotFoundException, IOException {
		TransferHistoryDAO transDAO = new TransferHistoryDAO();
		transDAO.saveTransferHistoryData(listTrans);

		// get data from file TransferHistory.txt and compare to listTrans
		List<TransferHistory> actualList = transDAO.readTransferHistoryData();

		// check size
		assertEquals(listTrans.size(), actualList.size());
		// check items
		for (int i = 0; i < listTrans.size(); ++i) {
			TransferHistory expectedTrans = listTrans.get(i);
			TransferHistory actualTrans = actualList.get(i);
			assertTrue(equalsTransferHistory(expectedTrans, actualTrans));
		}
	}

	public void testSaveTransferHistoryData_NotFoundFile()
			throws FileNotFoundException, IOException {
		try{
		TransferHistoryDAO transDAO = new TransferHistoryDAO();
		transDAO.saveTransferHistoryData(listTrans);

		// get data from file TransferHistory.txt and compare to listTrans
		List<TransferHistory> actualList = transDAO.readTransferHistoryData();

		// check size
		assertEquals(listTrans.size(), actualList.size());
		// check items
		for (int i = 0; i < listTrans.size(); ++i) {
			TransferHistory expectedTrans = listTrans.get(i);
			TransferHistory actualTrans = actualList.get(i);
			assertTrue(equalsTransferHistory(expectedTrans, actualTrans));
		}
		}catch (Exception e) {
		assertEquals(e.getClass(), FileNotFoundException.class);
		}
	}

	public void testSaveTransferHistoryData_Input_ListTransferHistory_Empty()
			throws FileNotFoundException, IOException {
		List<TransferHistory> inputList = new ArrayList<TransferHistory>();

		TransferHistoryDAO transDAO = new TransferHistoryDAO();
		transDAO.saveTransferHistoryData(inputList);

		// get data from file TransferHistory.txt and compare to listTrans
		List<TransferHistory> actualList = transDAO.readTransferHistoryData();

		// check size
		assertNotSame(inputList, actualList.size());
	}

	boolean equalsTransferHistory(TransferHistory trans1, TransferHistory trans2) {
		if ((trans1.getAmount() == trans2.getAmount())
				&& trans1.getATMID().equals(trans2.getATMID())
				&& trans1.getReceivedAccount().equals(
						trans2.getReceivedAccount())
				&& trans1.getSenderAccount().equals(trans2.getSenderAccount())
				&& trans1.getTime().equals(trans2.getTime())
				&& trans1.getAmount() == trans2.getAmount())
			return true;
		else
			return false;
	}

	/**
	 * Test methods isValidReceivedAccount(String senderAccountID, String
	 * receivedAccountID) of TransferHistoryBIZ
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */

	public void testisValidReceivedAccount_Input_ReceivedAccountID_null_Return_Exception()
			throws FileNotFoundException, IOException {
		try {
			String inputReceivedAccountID = null;
			(new TransferHistoryBIZ()).isValidReceivedAccount("9704321456987",
					inputReceivedAccountID);
		} catch (NullPointerException ex) {
			assertEquals(ex.getClass(), NullPointerException.class);
		}
	}

	public void testisValidReceivedAccount_Input_SenderAccountID_null_Return_Exception()
			throws FileNotFoundException, IOException {
		try {
			String input = null;
			(new TransferHistoryBIZ()).isValidReceivedAccount(input,
					"9704321456987");
		} catch (NullPointerException ex) {
			assertEquals(ex.getClass(), NullPointerException.class);
		}
	}

	public void testisValidReceivedAccount_Input_SenderAccount_Equals_ReceivedAccount_Return_False()
			throws FileNotFoundException, IOException {

		boolean actual = (new TransferHistoryBIZ()).isValidReceivedAccount(
				"9704321456987", "9704321456987");
		assertFalse(actual);
	}

	public void testisValidReceivedAccount_Input_IsNot_TheSameBank_Return_False()
			throws FileNotFoundException, IOException {
		// if the same bank, they have prefix "9704"
		boolean actual = (new TransferHistoryBIZ()).isValidReceivedAccount(
				"9704321456987", "0004321456987");
		assertFalse(actual);
	}

	// best case -->true
	public void testisValidReceivedAccount_Input_Is_TheSameBank_Return_False()
			throws FileNotFoundException, IOException {
		// if the same bank, they have prefix "9704"
		boolean actual = (new TransferHistoryBIZ()).isValidReceivedAccount(
				"9704321456987", "9704321456981");
		assertTrue(actual);
	}

	public void testisValidReceivedAccount_Input_ReceivedAccount_NotExists_Return_False()
			throws FileNotFoundException, IOException {
		// if the same bank, but ReceivedAccount is not provided to customer
		boolean actual = (new TransferHistoryBIZ()).isValidReceivedAccount(
				"9704321456987", "9704000000000");
		assertFalse(actual);
	}

	public void testisValidReceivedAccount_Input_ReceivedAccount_Locked_Return_False()
			throws FileNotFoundException, IOException {

		boolean actual = (new TransferHistoryBIZ()).isValidReceivedAccount(
				"9704321456987", "9704321456980");
		assertFalse(actual);
	}

	/**
	 * ------------------------------------------------------------------------
	 * --- Test methods transferMoney(String senderAccountID, String
	 * receivedAccountID, double amountTransferMoney) of TransferHistoryBIZ
	 * 
	 * @throws Exception
	 */
	public void testTransferMoney_Input_TransferMoney_0_Return_Return_False()
			throws FileNotFoundException, IOException, ParseException {
		String senderAccountID = "9704321456981";
		String receivedAccountID = "9704321456987";
		double transferMoney = 0;

		TransferHistoryBIZ transBIZ = new TransferHistoryBIZ();

		boolean actual = transBIZ.transferMoney(senderAccountID,
				receivedAccountID, transferMoney);
		assertFalse(actual);
	}

	public void testTransferMoney_Input_TransferMoney_LargerThanBalance_Return_False()
			throws FileNotFoundException, IOException, ParseException {
		String senderAccountID = "9704321456981";
		String receivedAccountID = "9704321456987";
		double transferMoney = 999999999;

		TransferHistoryBIZ transBIZ = new TransferHistoryBIZ();

		boolean actual = transBIZ.transferMoney(senderAccountID,
				receivedAccountID, transferMoney);
		assertFalse(actual);
	}

	public void testTransferMoney_Input_Correct_Return_True()
			throws FileNotFoundException, IOException, ParseException {
		String senderAccountID = "9704321456981";
		String receivedAccountID = "9704321456987";
		double transferMoney = 90000;

		TransferHistoryBIZ transBIZ = new TransferHistoryBIZ();

		boolean actual = transBIZ.transferMoney(senderAccountID,
				receivedAccountID, transferMoney);
		assertTrue(actual);
	}

	public void testTransferMoney_Input_SenderAccountID_Null_Return_False()
			throws FileNotFoundException, IOException, ParseException {
		String senderAccountID = null;
		String receivedAccountID = "9704321456987";
		double transferMoney = 90000;

		TransferHistoryBIZ transBIZ = new TransferHistoryBIZ();

		boolean actual = transBIZ.transferMoney(senderAccountID,
				receivedAccountID, transferMoney);
		assertFalse(actual);
	}

	public void testTransferMoney_Input_ReceivedAccountID_Null_Return_False()
			throws FileNotFoundException, IOException, ParseException {
		try {
			String senderAccountID = "9704321456981";
			String receivedAccountID = null;
			double transferMoney = 90000;

			TransferHistoryBIZ transBIZ = new TransferHistoryBIZ();

			transBIZ.transferMoney(senderAccountID, receivedAccountID,
					transferMoney);

		} catch (Exception ex) {
			assertEquals(ex.getClass(), NullPointerException.class);
		}
	}

}
