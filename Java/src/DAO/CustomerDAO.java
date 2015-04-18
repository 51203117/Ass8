package DAO;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entities.Customer;

/*
 * CustomerDAO
 * 1.0
 * 15/04/2012
 * 
 * Copyright notice
 * 
 * Modification Logs:
 * 
 * DATE					AUTHOR				DESCRIPTION
 * -----------------------------------------------------------
 * 16/04/2012			HuongDV1				
 */

public class CustomerDAO {
	/**
	 * Create by HuongDV1
	 * Read text file Customer.txt (Customer.txt contains all information of Customer)
	 * 
	 * @return List<Customer>
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List<Customer> readCustomerData() throws FileNotFoundException, IOException {
		List<Customer> listCustomer = new ArrayList<Customer>();
		Customer c = null;
		FileReader fr = new FileReader("Data\\Customer.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		while ((line = br.readLine()) != null) {
			String[] tmp = line.split("-");
			c = new Customer();
			c.setCustID(tmp[0]);
			c.setFullName(tmp[1]);
			c.setPhone(tmp[2]);
			c.setAddress(tmp[3]);

			listCustomer.add(c);
		}
		br.close();
		fr.close();

		return listCustomer;
	}

	/**
	 * Save data from listCustomer parameter to Customer.txt file
	 * @param listCustomer
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
}