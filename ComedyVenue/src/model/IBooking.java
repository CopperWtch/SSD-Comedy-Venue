package model;

import java.util.ArrayList;

public interface IBooking {

	public ArrayList<Booking> getAllBookings();
	public ArrayList<Booking> getBookingsByEvent();
	public ArrayList<Booking> getBookingsByCustomer();
	
	public void addBooking(Customer c, Event e, int numSeats);
	public void removeBooking(Booking b);
	
}
