package com.nagp.adminteam.model;

public class ServiceProvider {

	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String name;
	private String work;
	private String contact;
	private boolean available;
	public boolean getAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public ServiceProvider(String id, String name, String work, String contact, boolean available) {
		super();
		this.id = id;
		this.name = name;
		this.work = work;
		this.contact = contact;
		this.available = available;
	}
}
