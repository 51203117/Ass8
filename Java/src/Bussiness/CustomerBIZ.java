package Bussiness;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import DAO.CustomerDAO;
import Entities.Customer;

public class CustomerBIZ {

	public List<Customer> getCustomerList() throws FileNotFoundException, IOException
	{
		CustomerDAO custDAO=new CustomerDAO();
		return custDAO.readCustomerData();
	}
	public String getCustomerName(String custID) throws FileNotFoundException, IOException
	{
		List<Customer>custList=getCustomerList();
		Customer cust=null;
		String custName="";
		for(int i=0;i<custList.size();++i)
		{
			cust=custList.get(i);
			if(cust.getCustID().equals(custID))
			{
				custName=cust.getFullName();
				break;
			}
		}
		return custName;
	}
}
