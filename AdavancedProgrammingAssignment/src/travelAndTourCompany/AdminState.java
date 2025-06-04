package travelAndTourCompany;

import java.util.*;


public class AdminState implements UserState
{
	static Scanner sc = new Scanner(System.in);
	
    @Override
	public void setContext(Context context) {
		context.setState(this);
	}
	
	@Override
	public void login() 
	{
		System.out.print("Enter username: ");
		String usn = sc.nextLine();
		System.out.print("Enter password: ");
		String pw = sc.nextLine();
		check(usn,pw);
	}
	
	@Override
	public void check(String usn, String pw) 
	{
		if(usn.equals("Admin") && pw.equals("Admin!@#"))
			showOperations();
		else 
		{
			System.out.println("Incorrect username or password");
			login();
		}
	}

    @Override
	public void showOperations() 
	{
		String c;
		do {
			System.out.println("""
                                           Welcome to Admin Operations
                                           --------------------------
                                           1. Create Tour Package.
                                           2. Update Tour Package.
                                           3. Delete Tour Package.
                                           4. View Tour Packages.
                                           5. Create Customer information.
                                           6. Update Customer information.
                                           7. Delete Customer information.
                                           8. View Customers.
                                           9. View Booking list.
                                           10. Logout""");
			System.out.print("Enter an operation: ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) 
			{
				case 1: createPackage();break;
				case 2: updatePackage();break;
				case 3: deletePackage();break;
				case 4: viewPackage();break;
				case 5: createCustomer();break;
				case 6: updateCustomer();break;
				case 7: deleteCustomer();break;
				case 8: viewCustomer();break;
				case 9: viewBooking();break;
				case 10: logout();break;
				default: System.out.println("Please enter the options between 1 and 10!"); 
						showOperations();break;
			}
			System.out.print("Do another operation? (Y/N): ");
			c = sc.nextLine();
		}
		while(c.equalsIgnoreCase("y"));
		logout();	
	}

	public void createPackage() 
	{
		String c;
		do {
			System.out.println("Creating a tour package\n--------------------");
			System.out.print("Enter name: ");
			String name = sc.nextLine();
			System.out.print("Enter transportation type: ");
			String tran = sc.nextLine();
			System.out.print("Enter date: ");
			String date = sc.nextLine();
			System.out.print("Enter duration: ");
			String dura = sc.nextLine();
			System.out.print("Enter cost: ");
			Double cost = sc.nextDouble();
			sc.nextLine();
			PackageLoader.packageList.add(new Package(name,tran,date,dura,cost));
			System.out.println("Package succcessfully created");
			System.out.println("Create another tour package? (Y/N)");
			c = sc.nextLine();
		}while(c.equalsIgnoreCase("y"));
	}
	
	public void updatePackage() 
	{
		System.out.println("Update a tour package\n--------------------------");
		int up = 0;
		if(PackageLoader.packageList.isEmpty())
			System.out.println("The packages list is empty.");
		else 
		{
			System.out.print("Enter the ID of the package to update: ");
			up = sc.nextInt();
			sc.nextLine();	
			for(int i=0; i<PackageLoader.packageList.size(); i++) 
			{
				if(up == PackageLoader.packageList.get(i).getId()) 
				{
					System.out.print("Enter new name: ");
					PackageLoader.packageList.get(i).setName(sc.nextLine());
					System.out.print("Enter new transportation type: ");
					PackageLoader.packageList.get(i).setTransportation(sc.nextLine());
					System.out.print("Enter new date: ");
					PackageLoader.packageList.get(i).setDate(sc.nextLine());
					System.out.print("Enter new duration: ");
					PackageLoader.packageList.get(i).setDuration(sc.nextLine());
					System.out.print("Enter new cost: ");
					PackageLoader.packageList.get(i).setCost(sc.nextDouble());
					sc.nextLine();
					System.out.println("Package successfully updated");
					break;
				}
				else 
					System.out.println("The ID doesn't exist.");	
			}
		}
	}
	
	public void deletePackage() 
	{
		System.out.println("Deleting a tour package\n---------------------");
		int del = 0;
		if(PackageLoader.packageList.isEmpty())
			System.out.println("The packages list is empty.");
		else 
		{
			System.out.print("Enter the ID of the package to delete: ");
			del = sc.nextInt();
			sc.nextLine();
				
			int check =0;
			for(int i=0; i<PackageLoader.packageList.size(); i++) 
			{
				if(del == PackageLoader.packageList.get(i).getId()) {
					check = 1;
					PackageLoader.packageList.remove(i);
					System.out.println("Package successfully removed");
					break;
				}
			}
			if(check == 0)
				System.out.println("ID does not exist.");
		}
	}
	
	public static void viewPackage() 
	{
		if(PackageLoader.packageList.isEmpty())
			System.out.println("The package list is empty");
		else {
			System.out.println("Packages\n===================");
			String format = "%-10s%-25s%-20s%-20s%-18s%-20s%n";
			System.out.printf(format, "ID","Name","Transportation","Date","Duration","Cost");
			for(Package t: PackageLoader.packageList)
				System.out.printf(format,String.valueOf(t.getId()),
						t.getName(),
						t.getTransportation(),
						t.getDate(),
						t.getDuration(),
						String.valueOf(t.getCost()));
				
		}	
	}
	
	public void createCustomer() 
	{
		System.out.println("Creating a customer information\n------------------------");
		System.out.print("Enter customer ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter customer name: ");
		String name = sc.nextLine();
		System.out.print("Enter password: ");
		String pw = sc.nextLine();
		System.out.print("Enter customer phone number [09-9numbers]: ");
		String phno = sc.nextLine();
		System.out.print("Enter customer address: ");
		String add = sc.nextLine();
		Customer c = new Customer(id,name,pw,phno,add);
		CustomerLoader.customerList.add(c);
		System.out.println("Customer Successfully created.");
	}
	
	public void updateCustomer() 
	{
		System.out.println("Updating a customer information\n------------------------");
		System.out.print("Enter customer ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		int check = 0;
		for(Customer c: CustomerLoader.customerList) {
			if(c.getId()==id) {
				check = 1;
				System.out.print("Enter new ID: ");
				c.setId(sc.nextInt());
				sc.nextLine();
				System.out.print("Enter new name: ");
				c.setName(sc.nextLine());
				System.out.print("Enter new password: ");
				c.setPassword(sc.nextLine());
				System.out.print("Enter new phone number [09-9numbers]: ");
				c.setPhoneNo(sc.nextLine());
				System.out.print("Enter new address: ");
				c.setAddress(sc.nextLine());
				System.out.println("Customer Information successfully updated.");
				break;
			}
		}
		if(check == 0)
			System.out.println("ID does not exist.");	
	}
	
	public void deleteCustomer() {
		System.out.println("Deleting a customer information\n-------------------------");
		System.out.print("Enter customer ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		int check = 0;
		for(Customer c: CustomerLoader.customerList) {
			if(c.getId()==id) {
				check = 1;
				CustomerLoader.customerList.remove(c);
				System.out.println("Customer deleted successfully");
				break;
			}
		}
		if(check == 0)
			System.out.println("ID does not exist.");
	}
	
	public void viewCustomer() 
	{
		if(CustomerLoader.customerList.isEmpty())
			System.out.println("The customer list is empty");
		else {
			System.out.println("Customer List\n===================");
			String format = "%-10s%-18s%-20s%-20s%-20s%n";
			System.out.printf(format, "ID","Name","Password","Phone number","Address");
			for(Customer t: CustomerLoader.customerList)
				System.out.printf(format,String.valueOf(t.getId()),
						t.getName(),
						t.getPassword(),
						t.getPhoneNo(),
						t.getAddress());			
		}	
	}
	
	public void viewBooking() 
	{
		
		List<Booking> vb = new ArrayList<Booking>();
		
		for(Customer c: CustomerLoader.customerList) 
		{
			for(int i=0; i<c.getBookingList().size(); i++)
				vb.add(c.getBookingList().get(i));
		}
		Comparator<Booking> cmp = Comparator.comparing(Booking::getId);
		Collections.sort(vb,cmp);
		if(vb.isEmpty()) {
			System.out.println("There is no booking in the list");
		}
		else {
			System.out.println("Booking List\n-----------------");
			String format = "%-18s%-22s%-20s%n";
			System.out.printf(format,"Booking Number","Package Name","Customer name");
			for(int i=0; i<vb.size();i++) {
				System.out.printf(format,String.valueOf(vb.get(i).getId()),
						vb.get(i).getPack().getName(),
						vb.get(i).getC().getName());
			}
		}
	}
	
	public void logout() 
	{
		System.out.println("Logging out from Admin Operations");
		Login.getInstance().login();
	}
}
