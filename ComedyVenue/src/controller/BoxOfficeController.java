package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Booking;
import model.DBBookings;
import model.DBComedian;
import model.DBEvent;
import model.Event;
import model.IBooking;
import model.IComedians;
import model.IEventsList;
import view.GUI_Bookings;
import view.GUI_BoxOffice;


/**
 * BoxOfficeController
 * The controller class for the Box Office side of things
 * manages the communication between view and model classes.
 * 
 * @author Sarah Bulk
 * @version 1.0
 * @since 19.05.2015*/

public class BoxOfficeController {

	private GUI_BoxOffice viewMain;
	
	
	public BoxOfficeController()
	{
		this.viewMain = new GUI_BoxOffice();
		
		addMainListener();
		loadEvents();
	}
	
	public void showView(){
        this.viewMain.setVisible(true);
        this.viewMain.setBtnBookingsEnabled(false);
        this.viewMain.setBtnFeedbackEnabled(false);
    }

	
	/**
	 * View is introduced to the Listeners
	 * to enable communication with controller
     */
	private void addMainListener() {
		// TODO Auto-generated method stub
		
		this.viewMain.setBookingsListener(new BookingsListener());
		this.viewMain.setFeedbackListener(new FeedbackListener());
		this.viewMain.setBookingsSelectionListener(new EventsListener());
		this.viewMain.setComediansSelectionListener(new ComediansListener());
	}
	
	private void loadEvents(){
		
		IEventsList events = new DBEvent();
		
		this.viewMain.setEvents(events.getAllEvents());
	}
	

	
	
	 /**
     *
     * TODO : check for errors
     * 
     */
	
	//Open popup for bookings
	/**
	 * BookingsListener
	 * The Action Listener for the "Bookings" button in the main view.
	 * 
	 * @author Sarah Bulk
	 * @version 1.0
	 * @since 19.05.2015*/
    class BookingsListener implements ActionListener{ 

    	private GUI_Bookings viewBookings;
    	private IBooking modelBookings;
    
        public void actionPerformed(ActionEvent e) {
          //get values from view: value = (_view.getWhatever())
        	// get Event Data from view = _view.getSelectedEvent()
        	//use event Data to load the bookings _model.GetBookingsForEvent(data)
        	//Start Popup
        	modelBookings = new DBBookings();
        	
        	viewBookings= new GUI_Bookings();
        	viewBookings.setVisible(true);
        	addBookingsListener();
        	loadBookings(viewMain.getLstEvents().getSelectedValue());
        	
        	viewBookings.setBtnRemoveEnabled(false);
        }
        
        //Add Listeners to new window
		private void addBookingsListener() {
			
			this.viewBookings.setSaveListener(new SaveListener());
			this.viewBookings.setRemoveListener(new RemoveListener());
			this.viewBookings.setClearListener(new ClearListener());
			this.viewBookings.setReturnListener(new ReturnListener());
			this.viewBookings.setCustomerBookingsListener(new CustomerBookingsListener());
			
		}
		
		private void loadBookings(Event e){
			
			if(e!=null)
			this.viewBookings.setBookings(modelBookings.getBookingsByEvent(e));
		}
		
		
		//Listeners for the bookings
		/**
		 * SaveListener
		 * This class reacts to clicking the "Save" button in the "Bookings" window.
		 * 
		 * @author Sarah Bulk
		 * @version 1.0
		 * @since 19.05.2015*/
		 class SaveListener implements ActionListener{
		        public void actionPerformed(ActionEvent e) {
		         
		        	//If a booking is selected, overwrite
		        	if(viewBookings.getLstBookings().getSelectedValue()!= null)
					{
						//Get the selected booking
						Booking selectedBooking = viewBookings.getLstBookings().getSelectedValue();
						//Remove the selected booking
						modelBookings.removeBooking(selectedBooking);
						
					}
		        	
		        	//Get the new values
					String newName = viewBookings.getName();
					int newSeats= viewBookings.getSeats();
					
					if(!newName.equals("") && newSeats>0)
					{
						//get selected event
						Event currentEvent = viewMain.getLstEvents().getSelectedValue();					
						
						//Save the new values
						modelBookings.addBooking(currentEvent, newSeats, newName);
						
						loadBookings(viewMain.getLstEvents().getSelectedValue());
					}
					else
						viewBookings.setErrorText("Invalid input!");
										        	
		        }
		    }
		    
			/**
			 * RemoveListener
			 * This class reacts to clicking the "Remove" button in the "Bookings" window.
			 * 
			 * @author Sarah Bulk
			 * @version 1.0
			 * @since 19.05.2015*/
		    class RemoveListener implements ActionListener{
		        public void actionPerformed(ActionEvent e) {
		        	
		        	if(viewBookings.getLstBookings().getSelectedValue()!= null)
					{
						//Get the selected booking
						Booking selectedBooking = viewBookings.getLstBookings().getSelectedValue();
						//Remove the selected booking
						modelBookings.removeBooking(selectedBooking);
						
						loadBookings(viewMain.getLstEvents().getSelectedValue());
						
					}
		        }
		    }
		    
			/**
			 * ClearListener
			 * This class reacts to clicking the "Clear" button in the "Bookings" window.
			 * 
			 * @author Sarah Bulk
			 * @version 1.0
			 * @since 19.05.2015*/
		    class ClearListener implements ActionListener{
		        public void actionPerformed(ActionEvent e) {
		        	//clear the view
		        	viewBookings.clearView();
		        }
		    }
		    
			/**
			 * ReturnListener
			 * This class reacts to clicking the "Return" button in the "Bookings" window.
			 * 
			 * @author Sarah Bulk
			 * @version 1.0
			 * @since 19.05.2015*/
		    class ReturnListener implements ActionListener{
		        public void actionPerformed(ActionEvent e) {
		          //close the window
		        	viewBookings.dispose();
		        }
		    }
		
			/**
			 * CustomerBookingsListener
			 * This class reacts to selecting a booking from the list in the "Bookings" window.
			 * 
			 * @author Sarah Bulk
			 * @version 1.0
			 * @since 19.05.2015*/
	    class CustomerBookingsListener implements ListSelectionListener{
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				
				//get selected value
				if(viewBookings.getLstBookings().getSelectedValue()!= null)
				{
					//Set the data in the bookings popup window
					Booking selectedBooking = viewBookings.getLstBookings().getSelectedValue();
					viewBookings.setData(selectedBooking);
					viewBookings.setBtnRemoveEnabled(true);
				}
				else
					viewBookings.setBtnRemoveEnabled(false);
				
			}
	    }
    }
    
    //Open window for feedback
	/**TODO
	 * FeedbackListener
	 * This class reacts to clicking the "Feedback" button in the main window.
	 * 
	 * @author Sarah Bulk
	 * @version 1.0
	 * @since 19.05.2015*/
    class FeedbackListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	
        }
    }
    
    //Click on Event in the list
	/**
	 * EventsListener
	 * This class reacts to selecting an event from the list in the main window.
	 * 
	 * @author Sarah Bulk
	 * @version 1.0
	 * @since 19.05.2015*/
    class EventsListener implements ListSelectionListener{
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			
			//get selected value
			if(viewMain.getLstEvents().getSelectedValue()!= null)
			{
				//get selected value
				Event selectedEvent = viewMain.getLstEvents().getSelectedValue();
			
				//get associated comedians
				IComedians comedians = new DBComedian();
				
				//update data in the view
				viewMain.setComedians(selectedEvent.getComedians());
				viewMain.updateEvendData(selectedEvent);
				
				viewMain.setBtnBookingsEnabled(true);
			}
			else
				viewMain.setBtnBookingsEnabled(false);
		}
    }
    
	/**
	 * ComediansListener
	 * This class reacts to selecting a comedian from the list in the main window.
	 * 
	 * @author Sarah Bulk
	 * @version 1.0
	 * @since 19.05.2015*/
    class ComediansListener implements ListSelectionListener{
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			
			//get selected value
			if(viewMain.getLstComedians().getSelectedValue()!= null)
			{
				viewMain.updateComedianData(viewMain.getLstComedians().getSelectedValue());
			}
			
		}
    }
    

}
