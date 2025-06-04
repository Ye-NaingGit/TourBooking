package travelAndTourCompany;

import java.util.Scanner;

public class CustomerState implements UserState {

	Scanner sc = new Scanner(System.in);
	@Override
	public void setContext(Context context) 
	{
		context.setState(this);
	}

	@Override
	public void login() {
		System.out.println("Welcome to Customer Login");
		System.out.print("Enter username: ");
		String usn = sc.nextLine();
		System.out.print("Enter password: ");
		String pw = sc.nextLine();
		check(usn,pw);

	}

	@Override
	public void check(String usn, String pw) 
	{
		for(Customer c: CustomerLoader.customerList) {
			if(usn.equals(c.getName())) {
				if(c.getPassword().equals(pw)) {
					showOperations();
				}
				else {
					System.out.println("Incorrect Password");
					login();
				}
			}
		}
		System.out.println("Incorrect Username");
		login();
	}

    @Override
	public void showOperations() 
	{
		String c;
		do 
		{
			System.out.println("""
                                           Welcome to Customer Operations
                                           ------------------------------
                                           1. View tour packages
                                           2. Create booking
                                           3. Update booking
                                           4. Cancel booking
                                           5. View bookings
                                           6. View total cost of bookings
                                           7. Logout""");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) 
			{
				case 1: AdminState.viewPackage(); break;
				case 2: createBooking();break;
				case 3: updateBooking();break;
				case 4: deleteBooking();break;
				case 5: viewBooked();break;
				case 6: viewTotal();break;
				case 7: logout(); break;
				default: System.out.println("Please enter a number from the given options");showOperations();break;
			}
			System.out.print("Do another operation? (Y/N): ");
			c = sc.nextLine();
		}while(c.equalsIgnoreCase("y"));
		logout();
	}
	
	public void createBooking() 
	{
		System.out.println("Creating a booking\n--------------------");
		System.out.print("Enter username: ");
		String usn = sc.nextLine();
		
		int check = 0; // to check whether customer exists in the list
		for(Customer c: CustomerLoader.customerList) 
		{
			if(c.getName().equalsIgnoreCase(usn)) 
			{
				check = 1;
				String loop = "Y";
				do 
				{
					System.out.print("Enter the ID of the package to book: ");
					int id = sc.nextInt();
					sc.nextLine();
					int packageCheck = 0;
					for(Package p: PackageLoader.packageList) 
					{
						if(p.getId() == id) {
							packageCheck = 1;	
							Booking b = new Booking(p,c);
							c.getBookingList().add(b);
							break;
						}
					}
					if(packageCheck == 0)
						System.out.println("Package doesn't exist.");
					System.out.println("Add another booking? (Y/N)");
					loop = sc.nextLine();
				}while(loop.equalsIgnoreCase("y"));
			}
		}	
		if(check == 0)
			System.out.println("Customer doesn't exist in the list.");
	}
	
	public void updateBooking() {
		System.out.println("Updating a booking\n-----------------");
		System.out.print("Enter username: ");
		String name = sc.nextLine();
		int checkName = 0;
		
		for(Customer c: CustomerLoader.customerList) 
		{
			if(c.getName().equalsIgnoreCase(name)) 
			{
				checkName = 1;
				System.out.print("Enter booking number to update :");
				int num = sc.nextInt();
				sc.nextLine();
				int numCheck = 0;
				for(Booking b : c.getBookingList()) {
					if(b.getId() == num) {
						numCheck =1;
						System.out.print("Enter the ID of the package to book: ");
						int id = sc.nextInt();
						sc.nextLine();
						int packageCheck = 0;
						for(Package p: PackageLoader.packageList) {
							if(p.getId() == id) {
								packageCheck = 1;
								b.setPack(p);
								break;
							}
						}
						if(packageCheck == 0)
							System.out.println("Package doesn't exist.");
					}
				}
				if(numCheck == 0)
					System.out.println("Booking does not exist.");
				break;
			}
			if(checkName == 0)
				System.out.println("Customer does not exist in the list.");
		}
	}
	
	public void deleteBooking() 
	{
		System.out.println("Deleting a booking\n----------------");
		System.out.print("Enter username: ");
		String name = sc.nextLine();
		
		int checkName = 0;
		
		for(Customer c: CustomerLoader.customerList) {
			if(c.getName().equalsIgnoreCase(name)) {
				checkName = 1;
				System.out.print("Enter booking number to delete:");
				int num = sc.nextInt();
				sc.nextLine();
				int numCheck = 0;
				for(Booking b : c.getBookingList()) {
					if(b.getId() == num) {
						numCheck =1;
						c.getBookingList().remove(b);
						break;
						}
				}
				if(numCheck == 0)
					System.out.println("Booking does not exist.");
				break;
			}
		}
		
		if(checkName == 0) {
			System.out.println("Customer does not exist in the list.");
		}
	}
	
	public void viewBooked() 
	{
		System.out.print("Enter username: ");
		String name = sc.nextLine();
		
		int checkName = 0;
		
		for(Customer c: CustomerLoader.customerList) {
			
			if(c.getName().equalsIgnoreCase(name)) {
				checkName = 1;
				if(c.getBookingList().size()==0)
					System.out.println("There is no booking.");
				else 
				{
					System.out.println("Booking  list\n-------------------------");
					String format = "%-10s%-20s%-20s%-20s%n";
					System.out.printf(format,"Number","Package Name","Cost","Customer name");
					for(int i=0; i<c.getBookingList().size(); i++) 
					{
						System.out.printf(format,String.valueOf(c.getBookingList().get(i).getId()),
								c.getBookingList().get(i).getPack().getName(),
								String.valueOf(c.getBookingList().get(i).getPack().getCost()),
								c.getBookingList().get(i).getC().getName() );
					}
				}	
				break;
			}
		}	
		if(checkName == 0) {
			System.out.println("Customer does not exist in the list.");
		}
	}
	
	public void viewTotal() 
	{
		System.out.print("Enter username: ");
		String name = sc.nextLine();
		
		int checkName = 0;
		
		for(Customer c: CustomerLoader.customerList) {
			if(c.getName().equalsIgnoreCase(name)) {
				checkName = 1;
				if(c.getBookingList().size()==0)
					System.out.println("There is no booking.");
				else {
					double total = 0.0;
					int count = 0;
					for(int i=0; i<c.getBookingList().size(); i++) {
						total += c.getBookingList().get(i).getPack().getCost();
						count++;
					}
					System.out.println("Number of bookings: "+count);
					System.out.println("Total booking cost: "+total);
				}
				break;
			}
		}		
		if(checkName == 0)
			System.out.println("Customer does not exist in the list.");
	}
	
	public void logout() 
	{
		System.out.println("Logging out from Customer Operations");
		Login.getInstance().login();
	}
}
