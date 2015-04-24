
package DAO;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

import Entities.*;
/*
 * AccountDAO
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

public class AccountDAO {

	/**
	 * Create by hanhld
	 * Read text file BankAccount.txt (BankAccount.txt contains all information of BankAccounts)
	 * 
	 * @return List<BankAccount>
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List<Account> readBankAccountData() throws FileNotFoundException, IOException {
		List<Account> listBankAccount = new ArrayList<Account>();
		Account a = null;
		FileReader fr = new FileReader("Data\\BankAccount.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		while ((line = br.readLine()) != null) {
			String[] tmp = line.split("-");
			a = new Account();
			a.setAccountID(tmp[0]);
			a.setAccountTypeID(tmp[1]);
			a.setBalance(Double.valueOf(tmp[2]));
			a.setCustID(tmp[3]);
			a.setLocked(tmp[4]);
			

			listBankAccount.add(a);
		}
		br.close();
		fr.close();

		return listBankAccount;
	}

	/**
	 * Save data from listBankAccount parameter to BankAccount.txt file
	 * @param listAccount
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void saveAccountData(List<Account> listAccount) throws FileNotFoundException,
			IOException {
		FileWriter fw=new FileWriter("Data\\BankAccount.txt",false);
		BufferedWriter bw=new BufferedWriter(fw);
		Account a=null;
		for(int i=0;i<listAccount.size();++i){
			a= listAccount.get(i);
			bw.write(a.getAccountID()+"-"+a.getAccountTypeID()+"-"+a.getBalance()+"-"+a.getCustID()+"-"+a.getLocked());
			bw.newLine();
		}
		bw.flush();
		fw.flush();
		bw.close();
		fw.close();
	}
}
