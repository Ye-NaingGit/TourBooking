package travelAndTourCompany;

import java.util.Scanner;

public class Login {
	
	static Scanner sc;
	private static Login instance = new Login();
	public static Context c;
		
	private Login() 
	{
		sc = new Scanner(System.in);
		c = new Context();
	}
	
	public static Login getInstance() {
		return instance;
	}

	public void login() 
	{
		System.out.println("Welcome to Travel and Tour Company.");
		System.out.println("Choose the type of users.\n"
				+ "1: Admin\n"
				+ "2: Customer\n"
				+ "3: Exit");
		System.out.print("Enter the type: ");
		int choice = sc.nextInt();
		sc.nextLine();
		
		switch(choice) 
		{
			case 1:
				AdminState as = new AdminState();
				as.setContext(c);
				c.getState().login();
				break;
			case 2:
				CustomerState cs = new CustomerState();
				cs.setContext(c);
				c.getState().login();
				break;
			case 3:
				System.out.println("Exitting the system.");
				System.exit(0);
			default:
				System.out.println("Please enter 1, 2 or 3 ! ");
				login();
		}
	}
}
