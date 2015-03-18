package model;

import java.io.Serializable;

public class Customer implements Serializable{

	private int id;
	private String name;
	private String email;
	private String phoneNr;
	
	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param phone number
	 */
	public Customer(int id, String name, String email, String phoneNr)
	{
		this.id=id;
		this.name=name;
		this.email=email;
		this.phoneNr=phoneNr;
	}

	//GETTER & SETTER
	//TODO CHECK VALUES	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	
	
	
}
