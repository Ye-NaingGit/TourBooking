package travelAndTourCompany;

public abstract class LoaderTemplate 
{
	abstract void create();
	abstract void add();
	
	public final void load() 
	{
		create();
		add();
	}
}
