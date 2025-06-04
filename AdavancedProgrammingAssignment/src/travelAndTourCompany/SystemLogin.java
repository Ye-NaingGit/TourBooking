package travelAndTourCompany;

public class SystemLogin 
{
	Login l;
	PackageLoader pl;
	CustomerLoader cl;
	public SystemLogin() 
	{
		l = Login.getInstance();
		pl = new PackageLoader();
		cl = new CustomerLoader();
	}
	
	public void enter() 
	{
		pl.load();
		cl.load();
		l.login();
	}
}
