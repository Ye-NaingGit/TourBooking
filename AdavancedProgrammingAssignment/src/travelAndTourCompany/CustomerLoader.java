package travelAndTourCompany;

import java.util.*;

public class CustomerLoader extends LoaderTemplate 
{
	public static List<Customer> customerList;
	
	public void create() {
		customerList = new ArrayList<Customer>();
	}
	
	public void add() 
	{
		Customer c1 = new Customer(1,"Ye Naing","YN2001","09-123456789","Yangon");
		Customer c2 = new Customer(2,"Kyle","Kyle2002","09-251798123","Yangon");
		Customer c3 = new Customer(3,"John","John2003","09-999122302","Mandalay");
		customerList.add(c1);
		customerList.add(c2);
		customerList.add(c3);
	}
}
