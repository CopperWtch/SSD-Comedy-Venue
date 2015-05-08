package model;

import java.util.ArrayList;

public interface IBooking {

	public ArrayList<Booking> getAllBookings();
	public ArrayList<Booking> getBookingsByEvent();
	public ArrayList<Booking> getBookingsByCustomer();
	
	public void addBooking(Event e, int numSeats, String customerName);
	public void removeBooking(Booking b);
	
}
