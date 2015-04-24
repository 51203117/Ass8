package Test;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;



import Bussiness.CardBIZ;
import Bussiness.CardReaderBIZ;

import Entities.Card;


/**
 
 * @create by hanhld
 * 
 */
public class Hanhld_Testing extends TestCase {
	@Before
	public void setUp() throws Exception {
		CardBIZ cardB=new CardBIZ();
		listCard= cardB.getListCard();
		cardBIZ=new CardReaderBIZ();
	}

	@After
	public void tearDown() throws Exception {
	}
	List<Card>listCard=new ArrayList<Card>();
	CardReaderBIZ cardBIZ;
	
	public void testCheckExpires_ListCard_Empty_Return_False() throws ParseException
	{
		boolean actual=cardBIZ.checkExpires(listCard, null);
		assertFalse(actual);
	}
	
	public void testCheckExpires_Expires_Date_Larger_Than_Current_Date_Return_True() throws ParseException
	{
		boolean actual=cardBIZ.checkExpires(listCard, "9704230011069014");
		assertTrue(actual);
	}
	
	public void testCheckExpires_Expires_Date_Less_Than_Current_Date_Return_False() throws ParseException
	{
		boolean actual=cardBIZ.checkExpires(listCard, "9704230011069010");
		assertFalse(actual);
	}
	
	public void testCheckExpires_Expires_Date_Equal_Current_Date_Return_False() throws ParseException
	{
		boolean actual=cardBIZ.checkExpires(listCard, "9704230011069010");
		assertFalse(actual);
	}
	
	public void testCheckExists_ListCard_Empty_Return_False()
	{
		boolean actual=cardBIZ.checkExists(listCard, null);
		assertFalse(actual);
	}
	
	public void testCheckExists_ListCard_Not_Empty_Return_True()
	{
		boolean actual=cardBIZ.checkExists(listCard, "9704230011069015");
		assertTrue(actual);
	}
	
	public void testCheckExists_ListCard_Wrong_CardID_Return_False()
	{
		boolean actual=cardBIZ.checkExists(listCard, "111111111111111111111");
		assertFalse(actual);
	}
	
	public void testCheckExists_ListCard_CardID_Owned_Bank_But_Not_In_DB_Return_False()
	{
		boolean actual=cardBIZ.checkExists(listCard, "9704111111111111");
		assertFalse(actual);
	}
	
	public void testCheckLocked_ListCard_Empty_Return_False()
	{
		boolean actual=cardBIZ.checkLocked(listCard, null);
		assertFalse(actual);
	}
	
	public void testCheckLocked_Card_Is_Available_Return_False()
	{
		boolean actual=cardBIZ.checkLocked(listCard, "9704230011069010");
		assertFalse(actual);
	}
	
	public void testCheckLocked_Card_Is_Locked_Return_True()
	{
		boolean actual=cardBIZ.checkLocked(listCard, "9704230011069016");
		assertTrue(actual);
	}
	
	public void testCheckLocked_Card_Wrong_Status_Return_False()
	{
		boolean actual=cardBIZ.checkLocked(listCard, "9704230011069777");
		assertFalse(actual);
	}
	
	public void testCheckPIN_ListCard_Empty_Return_False()
	{
		boolean actual=cardBIZ.checkPin(listCard, null, null);
		assertFalse(actual);
	}
	
	public void testCheckPIN_Exists_In_Database_Return_True()
	{
		boolean actual=cardBIZ.checkPin(listCard, "9704230011069016", "123456");
		assertTrue(actual);
	}
	
	public void testCheckPin_Right_CardID_Wrong_Pin_Return_False()
	{
		boolean actual=cardBIZ.checkPin(listCard, "9704230011069016", "123446");
		assertFalse(actual);
	}
	
	public void testCheckPin_Right_CardID_Wrong_Pin_Length_Return_False()
	{
		boolean actual=cardBIZ.checkPin(listCard, "9704230011069016", "1");
		assertFalse(actual);
	}
	
	public void testCheckPin_Empty_CardID_Right_Pin_Return_False()
	{
		boolean actual=cardBIZ.checkPin(listCard, null, "123456");
		assertFalse(actual);
	}
}