package travelAndTourCompany;

public class Booking 
{
	
	public static int idcount = 1;
	
	private int id;
	private Package pack;
	private Customer c;
	
	public Booking(Package pack, Customer c) {
		this.id = idcount;
		this.pack = pack;
		this.c = c;
		idcount++;
	}
	
	public int getId() {
		return id;
	}
	public Package getPack() {
		return pack;
	}
	public void setPack(Package pack) {
		this.pack = pack;
	}
	public Customer getC() {
		return c;
	}
	public void setC(Customer c) {
		this.c = c;
	}
	
	
}
