package Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

import Bussiness.WithDrawalHistoryBIZ;
import DAO.WithDrawalHistoryDAO;
import Entities.ATM;
import Entities.WithDrawalHistory;

/**
 
 * @create by HuongDV1
 * 
 */
public class HuongDV1_Testing extends TestCase {

	@Before
	public void setUp() throws Exception {
		WithDrawalHistory withdrawal=new WithDrawalHistory();
		withdrawal.setAmount(5000000);
		withdrawal.setATMID(ATM.ATMID);
		withdrawal.setAccountID("9704321456987");
		withdrawal.setTime("2/4/2013 15:30:00");
		listWithdrawal.add(withdrawal);
		
		withdrawal=new WithDrawalHistory();
		withdrawal.setAmount(10000000);
		withdrawal.setATMID(ATM.ATMID);
		withdrawal.setAccountID("9704321456981");
		withdrawal.setTime("3/8/2013 8:00:00");
		listWithdrawal.add(withdrawal);
	}

	@After
	public void tearDown() throws Exception {
	}
	List<WithDrawalHistory>listWithdrawal=new ArrayList<WithDrawalHistory>();
	WithDrawalHistoryBIZ withDrawalBIZ=new WithDrawalHistoryBIZ();
	/**
	 * Test methods void saveWithDrawalHistoryData(List<WithDrawalHistory> listWithDrawal) of WithDrawalHistoryDAO class
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void testSaveWithDrawalHistoryData() throws FileNotFoundException, IOException {
		WithDrawalHistoryDAO withdrawalDAO=new WithDrawalHistoryDAO();
		withdrawalDAO.saveWithDrawalHistoryData(listWithdrawal);
		
		//get data from file WithdrawalHistory.txt and compare to listWithdrawal
		List<WithDrawalHistory> actualList =withdrawalDAO.readWithDrawalHistoryData();
		
		//check size		
		assertEquals(listWithdrawal.size(), actualList.size());
		//check items
		for(int i=0;i<listWithdrawal.size();++i)
		{
			WithDrawalHistory expectedWithDrawal=listWithdrawal.get(i);
			WithDrawalHistory actualWithDrawal = actualList.get(i);
			assertEquals(expectedWithDrawal.getAmount(), actualWithDrawal.getAmount());
			assertEquals(expectedWithDrawal.getATMID(), actualWithDrawal.getATMID());
			assertEquals(expectedWithDrawal.getTime(), actualWithDrawal.getTime());
		}
	}
	
	/**
	 * Test methods withDrawOfChecking testwithDrawOfChecking(String CarID, String accountID, double mount )
	 * of WithDrawalHistoryBIZ
	 * @throws Exception 
	 */
	public void testwithDrawOfChecking_Input_CarID_Null_Return_false() throws Exception
	{
		String CarID=null;
		String accountID="9704230011069013";
		double mount=3000000;	
		
		boolean expected=false;
		boolean actual=withDrawalBIZ.withDrawOfChecking(CarID, accountID,mount );
		assertEquals(expected, actual);
	}
	
	public void testwithDrawOfChecking_Input_AccountID_Null_Return_false() throws Exception
	{
		String CarID="9704321456987";
		String accountID="null";
		double mount=3000000;	
		
		boolean expected=false;
		boolean actual=withDrawalBIZ.withDrawOfChecking(CarID, accountID,mount );
		assertEquals(expected, actual);
		
	}
	
	public void testwithDrawOfChecking_Input_Mount_divice_10000_not_equa_0_Return_false() throws Exception
	{
		String CarID="9704321456987";
		String accountID="9704230011069013";
		double mount=8000;	
		
		boolean expected=false;
		boolean actual=withDrawalBIZ.withDrawOfChecking(CarID, accountID,mount );
		assertEquals(expected, actual);
	}
	
	public void testwithDrawOfChecking_Input_True_Return_True() throws Exception
	{
		String CarID="9704321456987";
		String accountID="9704230011069013";
		double mount=80000;	
		
		boolean expected=true;
		boolean actual=withDrawalBIZ.withDrawOfChecking(CarID, accountID,mount );
		assertEquals(expected, actual);	
	}
	
	public void testwithDrawOfChecking_Input_Mount_greater_5000000_Return_true() throws Exception
	{
		String CarID="9704321456987";
		String accountID="9704230011069013";
		double mount=10000000;	
		
		boolean expected=false;
		boolean actual=withDrawalBIZ.withDrawOfChecking(CarID, accountID,mount );
		assertEquals(expected, actual);	
	}
	
	//chay ham nay 5 lan sau do kiem tra xem rut tiep dc nua ko?
	public void testwithDrawOfChecking_Input_Mount_Withdrawal_biger_5_Return_true() throws Exception
	{
		String CarID="9704321456987";
		String accountID="9704230011069013";
		double mount=1000000;	
		
		boolean expected=false;
		boolean actual=withDrawalBIZ.withDrawOfChecking(CarID, accountID,mount );
		assertEquals(expected, actual);
	}
	
	/**
	 * Test methods withDrawOfSaving testwithDrawOfSaving(String CarID, String accountID, double mount )
	 * of WithDrawalHistoryBIZ
	 * @throws Exception 
	 */
	
	public void testwithDrawOfSaving_Input_CarID_Null_Return_false() throws Exception
	{
		String CarID=null;
		String accountID="9704230011069013";
		double mount=3000000;	
		
		boolean expected=false;
		boolean actual=withDrawalBIZ.withDrawOfSaving(CarID, accountID,mount );
		assertEquals(expected, actual);
	}
	
	public void testwithDrawOfSaving_Input_AccountID_Null_Return_false() throws Exception
	{
		String CarID="9704321456987";
		String accountID="null";
		double mount=3000000;	
		
		boolean expected=false;
		boolean actual=withDrawalBIZ.withDrawOfSaving(CarID, accountID,mount );
		assertEquals(expected, actual);	
	}
	
	public void testwithDrawOfSaving_Input_Mount_divice_10000_not_equa_0_Return_false() throws Exception
	{
		String CarID="9704321456987";
		String accountID="9704230011069013";
		double mount=8000;	
		
		boolean expected=false;
		boolean actual=withDrawalBIZ.withDrawOfSaving(CarID, accountID,mount );
		assertEquals(expected, actual);
	}
	
	public void testwithDrawOfSaving_Input_True_Return_True() throws Exception
	{
		String CarID="9704321456987";
		String accountID="9704230011069013";
		double mount=3000000;	
		
		boolean expected=false;
		boolean actual=withDrawalBIZ.withDrawOfSaving(CarID, accountID,mount );
		assertEquals(expected, actual);
	}
	
	public void testwithDrawOfSaving_Input_Mount_greater_5000000_Return_false() throws Exception
	{
		String CarID="9704321456987";
		String accountID="9704230011069013";
		double mount=10000000;	
		
		boolean expected=false;
		boolean actual=withDrawalBIZ.withDrawOfChecking(CarID, accountID,mount );
		assertEquals(expected, actual);	
	}
	
	//chay ham nay 5 lan sau do kiem tra xem rut tiep dc nua ko?
	public void testwithDrawOfSaving_Input_Mount_Withdrawal_biger_5_Return_false() throws Exception
	{
		String CarID="9704321456987";
		String accountID="9704230011069013";
		double mount=1000000;	
		
		boolean expected=false;
		boolean actual=withDrawalBIZ.withDrawOfChecking(CarID, accountID,mount );
		assertEquals(expected, actual);	
	}
	
	public void testgetAmountMoneyWithdrawalofAccount_Input_accountID_Null_Return_0() throws Exception
	{
		String accountID="";
		double expected=0;
		double actual = withDrawalBIZ.getAmountMoneyWithdrawalofAccount(listWithdrawal, accountID);
		assertEquals(expected, actual);
	}
	
	public void testgetNumberWithdrawalofAccount_Input_accountID_Null_Return_0() throws Exception
	{
		String accountID="";
		double expected=0;
		double actual = withDrawalBIZ.getAmountMoneyWithdrawalofAccount(listWithdrawal, accountID);
		assertEquals(expected, actual);
	}
}
