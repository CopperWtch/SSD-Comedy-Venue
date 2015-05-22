package model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Event 
 * This class describes the object type 'Event'.
 * 
 * @author Sarah Bulk
 * @version 1.0
 * @since 19.05.2015
 */
@SuppressWarnings("serial")
public class Event implements Serializable{

	 private int id;
	 private String name;
	 private float price;
	 private String desc;
	 private int minAge;
	 private Timestamp date;
	 private int seats;
	 private ArrayList<Comedian> comedians;


		/**
		 * The constructor to create an object
		 * 
		 * @param id
		 *            The ID of the event
		 * @param name
		 *            The name of the event
		 * @param price
		 *            The price of a ticket for this event
		 * @param desc
		 *            A description of the event
		 * @param minAge
		 *            Age restriction of the event
		 * @param date
		 *            The date it takes place
		 * @param seats
		 *            The amount of available seats
		 * @param comedians
		 *            A list of the comedians performing at this event
		 */
	public Event(int id, String name, float price, String desc, int minAge, Timestamp date, int seats, ArrayList<Comedian> comedians)
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

	/**
	 * 
	 * Data accessor methods
	 */
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

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
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

	/**
	 * A method to generate a String representing the most important data.
	 * 
	 * @return A String object containing the data.
	 */
	@Override
	public String toString() {
		
		return name;
	}
	 
	 
}
