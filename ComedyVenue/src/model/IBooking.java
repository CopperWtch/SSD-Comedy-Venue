package model;

import java.util.ArrayList;

/**
 * IBooking
 * This interface holds all the necessary information for working with
 * data concerning Bookings
 * 
 * @author Sarah Bulk
 */
public interface IBooking {

	public ArrayList<Booking> getBookingsByEvent(Event e);
	public void addBooking(Event e, int numSeats, String customerName);
	public void removeBooking(Booking b);
	
}
