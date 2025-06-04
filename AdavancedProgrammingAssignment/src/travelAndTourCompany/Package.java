package travelAndTourCompany;

public class Package 
{
public static int idcount = 1;
	private int id;
	private String name;
	private String transportation;
	private String date;
	private String duration;
	private double cost;
	
	public Package(String name, String transportation, String date, String duration, double cost) {
		this.id = idcount;
		idcount++;
		this.name = name;
		this.transportation = transportation;
		this.date = date;
		this.duration = duration;
		this.cost = cost;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTransportation() {
		return transportation;
	}
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	
}
