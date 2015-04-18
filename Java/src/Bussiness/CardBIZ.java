package Bussiness;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;

import javax.swing.JOptionPane;

import DAO.CardDAO;
import Entities.Card;
/**
 * @author HaVT2
 *
 */
public class CardBIZ {
	
	public List<Card> getListCard() throws FileNotFoundException, IOException
	{
		CardDAO cardDAO=new CardDAO();
		return cardDAO.readCardData();
	}
	public void saveListCard(List<Card> listCard)throws FileNotFoundException, IOException
	{
		CardDAO cardDAO=new CardDAO();
		cardDAO.saveCardData(listCard);
	}
	
	public String getAccountOfCard(List<Card> listCard,String cardID)
	{
		Card c=null;
		String accountID="";
		for(int i=0;i<listCard.size();++i)
		{
			c=listCard.get(i);
			if(c.getCardID().equals(cardID))
			{
				accountID=c.getAccountID();	
				break;
			}
			
		}		
			return accountID;
	}
}
