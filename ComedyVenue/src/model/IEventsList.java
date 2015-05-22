package model;


import java.util.ArrayList;

/**
 * IEventsList
 * This interface holds all the necessary information
 * for working with data concerning Events
 * 
 * @author Sarah Bulk
 */
public interface IEventsList {
	public ArrayList<Event> getAllEvents();
	public void addEvent(Event e);
	public void removeEvent(Event e);
}
