package model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Booking 
 * This class describes the object type 'Booking'.
 * 
 * @author Sarah Bulk
 */
@SuppressWarnings("serial")
public class Booking implements Serializable {

	private int id;
	private Event event;
	private Timestamp bookingTime;
	private int numSeats;
	private String customerName;

	/**
	 * The constructor to create an object
	 * 
	 * @param id
	 *            The ID of the booking
	 * @param event
	 *            The associated Event
	 * @param bookingTime
	 *            The time the booking was made
	 * @param numSeats
	 *            The amount of seats that were booked for this booking
	 * @param customerName
	 *            The name of the customer
	 */
	public Booking(int id, Event event, Timestamp bookingTime, int numSeats,
			String customerName) {
		this.id = id;
		this.event = event;
		this.customerName = customerName;
		this.bookingTime = bookingTime;
		this.numSeats = numSeats;
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

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Timestamp getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Timestamp bookingTime) {
		this.bookingTime = bookingTime;
	}

	public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	/**
	 * A method to generate a String representing the most important data.
	 * 
	 * @return A String object containing the data.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return event.toString() + " " + customerName;
	}

}
