package travelAndTourCompany;

import java.util.*;

public class PackageLoader extends LoaderTemplate
{
	public static List<Package> packageList;
	
	public void create() {
		packageList = new ArrayList<Package>();
	}
	public void add() 
	{
		Package p1 = new Package("Yangon-Mandalay","Bus","10-10-2023","1 week",200000);
		Package p2 = new Package("Yangon-Nay Pyi Taw","Bus","20-10-2023","3 days",80000);
		Package p3 = new Package("Yangon-Taunggyi","Airplane","22-10-2023","1 week",300000);
		packageList.add(p1);
		packageList.add(p2);
		packageList.add(p3);
	}
}
