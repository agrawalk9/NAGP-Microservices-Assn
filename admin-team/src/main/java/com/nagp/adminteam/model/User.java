package com.nagp.adminteam.model;

public class User {

	private int id;
	private String name;
	private String address;
	private String contactNo;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public User(int id, String name, String address, String contactNo) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
	}
}
