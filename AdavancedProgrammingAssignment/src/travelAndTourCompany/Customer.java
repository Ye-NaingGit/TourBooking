package travelAndTourCompany;

import java.util.*;

public class Customer 
{
	private int id;
	private String name;
	private String password;
	private String phoneNo;
	private String address;
	private List<Booking> bookingList;
	
	public Customer(int id, String name, String password, String phoneNo, String address) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.phoneNo = phoneNo;
		this.address = address;
		this.bookingList = new ArrayList<Booking>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Booking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}
}
