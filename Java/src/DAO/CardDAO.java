
package DAO;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

import Entities.*;
/*
 * CardDAO
 * 1.0
 * 15/04/2012
 * 
 * Copyright notice
 * 
 * Modification Logs:
 * 
 * DATE					AUTHOR				DESCRIPTION
 * -----------------------------------------------------------
 * 15/04/2012			havt2				
 */

public class CardDAO {

	/**
	 * Create by havt2
	 * Read text file Card.txt (Card.txt contains all information of Cards)
	 * 
	 * @return List<Card>
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	public List<Card> readCardData() throws FileNotFoundException, IOException {
		List<Card> listCard = new ArrayList<Card>();
		Card c = null;
		FileReader fr = new FileReader("Data\\Card.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		while ((line = br.readLine()) != null) {
			String[] tmp = line.split("-");
			c = new Card();
			c.setAccountID(tmp[0]);
			c.setCardID(tmp[1]);
			c.setExpiresDate(tmp[2]);
			c.setPin(tmp[3]);
			c.setStatus(tmp[4]);
			c.setValidFrom(tmp[5]);

			listCard.add(c);
		}
		br.close();
		fr.close();

		return listCard;
	}

	/**
	 * Save data from listCard parameter to Card.txt file
	 * @param listCard
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void saveCardData(List<Card> listCard) throws FileNotFoundException,
			IOException {
		FileWriter fw=new FileWriter("Data\\Card.txt",false);
		BufferedWriter bw=new BufferedWriter(fw);
		Card c=null;
		for(int i=0;i<listCard.size();++i){
			c= listCard.get(i);
			bw.write(c.getAccountID()+"-"+c.getCardID()+"-"+c.getExpiresDate()+"-"+c.getPin()+"-"+c.getStatus()+"-"+c.getValidFrom());
			bw.newLine();
		}
		bw.flush();
		fw.flush();
		bw.close();
		fw.close();
	}

}