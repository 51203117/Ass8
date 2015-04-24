
package DAO;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

import Entities.*;
/*
 * AccountTypeDAO
 * 1.0
 * 16/04/2012
 * 
 * Copyright notice
 * 
 * Modification Logs:
 * 
 * DATE					AUTHOR				DESCRIPTION
 * -----------------------------------------------------------
 * 16/04/2012			hanhld				
 */

public class AccountTypeDAO {
	/**
	 * Create by hanhld
	 * Read text file AccountType.txt (AccountType.txt contains all information of AccountTypes)
	 * 
	 * @return List<AccountType>
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	public List<AccountType> readAccountTypeData() throws FileNotFoundException, IOException {
		List<AccountType> listAccountType = new ArrayList<AccountType>();
		AccountType at = null;
		FileReader fr = new FileReader("Data\\AccountType.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		while ((line = br.readLine()) != null) {
			String[] tmp = line.split("-");
			at = new AccountType();
			at.setAccountTypeID(tmp[0]);
			at.setAccountTypeName(tmp[1]);
			at.setOverDraft(Float.parseFloat((tmp[2])));
			at.setNumberOfWithdrawal(Integer.parseInt((tmp[3])));
			at.setNumberOfWithdrawCash(Float.parseFloat((tmp[4])));

			listAccountType.add(at);
		}
		br.close();
		fr.close();

		return listAccountType;
	}

	/**
	 * Save data from listAccountType parameter to AccountType.txt file
	 * @param listAccountType
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void saveAccountTypeData(List<AccountType> listAccountType) throws FileNotFoundException,
			IOException {
		FileWriter fw=new FileWriter("Data\\AccountType.txt",false);
		BufferedWriter bw=new BufferedWriter(fw);
		AccountType at=null;
		for(int i=0;i<listAccountType.size();++i){
			at= listAccountType.get(i);
			bw.write(at.getAccountTypeID()+"-"+at.getAccountTypeName()+"-"+at.getOverDraft()+"-"+at.getNumberOfWithdrawal()+"-"+at.getNumberOfWithdrawCash());
			bw.newLine();
		}
		bw.flush();
		fw.flush();
		bw.close();
		fw.close();
	}
}
