package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Event implements Serializable{
//TODO
	 private int id;
	 private String name;
	 private float price;
	 private String desc;
	 private int minAge;
	 private Date date;
	 private int seats;
	 private ArrayList<Comedian> comedians;
	 
	 protected int myAttribute;
	 
	 
	 public void setMyAttribute(int myAttribute) {
	 	this.myAttribute = myAttribute;
	 }

	 public int getMyAttribute() {
	 	return this.myAttribute;
	 }


		/**
		 * @param id
		 * @param name
		 * @param price
		 * @param desc
		 * @param minAge
		 * @param date
		 * @param comedians
		 */
	public Event(int id, String name, float price, String desc, int minAge, Date date, int seats, ArrayList<Comedian> comedians)
	 {
		 super();
		 this.id = id;
		 this.name=name;
		 this.price = price;
		 this.desc=desc;
		 this.minAge=minAge;
		 this.date=date;
		 this.seats=seats;
		 this.comedians=comedians;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	 public ArrayList<Comedian> getComedians() {
		return comedians;
	}

	public void setComedians(ArrayList<Comedian> comedians) {
		this.comedians = comedians;
	}

	public void addComedian(Comedian comedian) {
		this.comedians.add(comedian);
	}

	@Override
	public String toString() {
		
		return name;
	}
	 
	 
}
