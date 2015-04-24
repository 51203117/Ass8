package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import Entities.*;

/*
 * TransferHistoryDAO
 * 1.0
 * 15/04/2012
 * 
 * Copyright notice
 * 
 * Modification Logs:
 * 
 * DATE					AUTHOR				DESCRIPTION
 * -----------------------------------------------------------
 * 16/04/2012			havt2				
 */
public class TransferHistoryDAO {
	/**
	 * get all data from TransferHistory.txt
	 * 
	 * @return List of all TransferHistory
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List<TransferHistory> readTransferHistoryData()
			throws FileNotFoundException, IOException {
		{
			List<TransferHistory> transferHistoryList = new ArrayList<TransferHistory>();
			TransferHistory trans = null;
			FileReader fileReader = new FileReader("Data\\TransferHistory.txt");
			BufferedReader bufferReader = new BufferedReader(fileReader);
			String line = "";
			while ((line = bufferReader.readLine()) != null) {
				String[] tmp = line.split("-");
				trans = new TransferHistory();
				trans.setATMID(tmp[0]);
				trans.setSenderAccount(tmp[1]);
				trans.setAmount(Double.parseDouble(tmp[2]));
				trans.setTime(tmp[3]);
				trans.setReceivedAccount(tmp[4]);
				transferHistoryList.add(trans);
			}
			bufferReader.close();
			fileReader.close();

			return transferHistoryList;
		}

	}

	public void saveTransferHistoryData(
			List<TransferHistory> transferHistoryList)
			throws FileNotFoundException, IOException {
		
		if (transferHistoryList.size() > 0) {
			FileWriter fileWriter = new FileWriter("Data\\TransferHistory.txt",false);
		
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			TransferHistory trans = null;
			for (int i = 0; i < transferHistoryList.size(); ++i) {
				trans = transferHistoryList.get(i);
				bufferWriter.write(trans.getATMID() + "-"
						+ trans.getSenderAccount() + "-"
						+ (new DecimalFormat("#")).format(trans.getAmount())
						+ "-" + trans.getTime() + "-"
						+ trans.getReceivedAccount());
				bufferWriter.newLine();
			}
			bufferWriter.flush();
			fileWriter.flush();
			bufferWriter.close();
			fileWriter.close();
		}
	}

}
