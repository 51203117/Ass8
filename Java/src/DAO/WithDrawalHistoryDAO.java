
package DAO;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

import Entities.*;
/*
 * WithDrawalHistoryDAO
 * 1.0
 * 15/04/2012
 * 
 * Copyright notice
 * 
 * Modification Logs:
 * 
 * DATE					AUTHOR				DESCRIPTION
 * -----------------------------------------------------------
 * 15/04/2012			HuongDV1				
 */

public class WithDrawalHistoryDAO {

	/**
	 * Create by HuongDV1
	 * Read text file WithdrawalHistory.txt (WithdrawalHistory.txt contains all information of Withdrawal History)
	 * 
	 * @return List<WithdrawalHistory>
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	public List<WithDrawalHistory> readWithDrawalHistoryData() throws FileNotFoundException, IOException {
		List<WithDrawalHistory> listWithDrawalHistoryData= new ArrayList<WithDrawalHistory>();
		WithDrawalHistory c = null;
		FileReader fr = new FileReader("Data\\WithdrawalHistory.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		while ((line = br.readLine()) != null) {
			String[] tmp = line.split("-");
			c = new WithDrawalHistory();
			c.setATMID(tmp[0]);
			c.setAccountID(tmp[1]);
			c.setAmount(Double.parseDouble(tmp[2]));
			c.setTime(tmp[3]);

			listWithDrawalHistoryData.add(c);
		}
		br.close();
		fr.close();
	
		return listWithDrawalHistoryData;
	}

	/**
	 * Save data from listWithDrawalHistoryDAOparameter to WithDrawalHistoryDAO.txt file
	 * @param listWithDrawalHistoryDAO
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void saveWithDrawalHistoryData(List<WithDrawalHistory> listWithDrawalHistoryData) throws FileNotFoundException,
			IOException {
		FileWriter fw=new FileWriter("Data\\WithdrawalHistory.txt",false);
		BufferedWriter bw=new BufferedWriter(fw);
		WithDrawalHistory c=null;
		for(int i=0;i<listWithDrawalHistoryData.size();++i){
			c= listWithDrawalHistoryData.get(i);
			bw.write(c.getATMID()+"-"+c.getAccountID()+"-"+c.getAmount()+"-"+c.getTime());
			bw.newLine();
		}
		bw.flush();
		fw.flush();
		bw.close();
		fw.close();
	}
}