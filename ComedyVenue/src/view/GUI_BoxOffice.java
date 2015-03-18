package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Comedian;
import model.Event;

import java.awt.GridLayout;
import java.awt.event.ActionListener;



public class GUI_BoxOffice extends JFrame {

	//GUI elements
	//put all those here 
	private JPanel contentPane;
	private JList<Event> lstEvents;
	private JList<Comedian> lstComedians;
	private JButton btnBookings;

	/**
	 *
	 * Create the frame.
	 */
	public GUI_BoxOffice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		BorderLayout borderlayout = new BorderLayout();
		contentPane.setLayout(borderlayout);
	
		
		//create Headline
		JLabel lblHead = new JLabel("Box Office",SwingConstants.CENTER);
		lblHead.setFont(new Font("Arial", Font.BOLD, 16));

		//add Headline
		contentPane.add(lblHead,BorderLayout.NORTH);
		
		//-----------------------
		//Left side:
		
		//create Layout & Panel
		JPanel pnlLeft=new JPanel();
		BoxLayout layoutLeft = new BoxLayout(pnlLeft, BoxLayout.Y_AXIS);
		pnlLeft.setLayout(layoutLeft);
		
		//Label for events
		JLabel lblEvents = new JLabel("Events");
		lblEvents.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		lblEvents.setFont(new Font("Arial", Font.BOLD, 16));
		pnlLeft.add(lblEvents);
		
		//List of Events
		lstEvents = new JList<Event>(); //data has type Object[]
		lstEvents.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstEvents.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		lstEvents.setVisibleRowCount(-1);
		//lstEvents.setBounds(new Rectangle(400,400));
		JScrollPane eventsScroller = new JScrollPane(lstEvents);
		eventsScroller.setPreferredSize(new Dimension(400, 200));
		
		pnlLeft.add(eventsScroller);
		
		//Label for events
		JLabel lblComedians = new JLabel("Comedians");
		lblComedians.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		lblComedians.setFont(new Font("Arial", Font.BOLD, 16));
		pnlLeft.add(lblComedians);
		
		//List of Comedians
		lstComedians = new JList<Comedian>(); //data has type Object[]
		lstComedians.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstComedians.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		lstComedians.setVisibleRowCount(-1);
		//lstEvents.setBounds(new Rectangle(400,400));
		JScrollPane comediansScroller = new JScrollPane(lstEvents);
		comediansScroller.setPreferredSize(new Dimension(400, 200));
		
		pnlLeft.add(comediansScroller);
		
		//add to Layout
		contentPane.add(pnlLeft,BorderLayout.WEST);
		
		
		
		//Right side:
		JPanel pnlRight=new JPanel();
		BoxLayout layoutRight = new BoxLayout(pnlRight, BoxLayout.Y_AXIS);
		pnlRight.setLayout(layoutRight);
		
		//Label for event details
		JLabel lblEventDetails = new JLabel("Event Details");
		lblEventDetails.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		lblEventDetails.setFont(new Font("Arial", Font.BOLD, 16));
		pnlRight.add(lblEventDetails);
		
		//TODO: Labels for event details
		
		btnBookings = new JButton("Bookings");
		pnlRight.add(btnBookings);
		
		//Label for comedian details
		JLabel lblComedianDetails = new JLabel("Comedian Details");
		lblComedianDetails.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		lblComedianDetails.setFont(new Font("Arial", Font.BOLD, 16));
		pnlRight.add(lblComedianDetails);
		
		//TODO: Labels for event details
		
		
		//add to layout
		contentPane.add(pnlRight,BorderLayout.EAST);	
	}
	
// Add these some time	
//    public void resetView(){
//    }
//
//    public String getEingabe(){
//    	return "";
//    }
//
//    public void setErgebnis(String erg){
//    }

    /**
     * Functions to add ActionListeners
     * 
     */
    
    public void setBookingsListener(ActionListener l){
        this.btnBookings.addActionListener(l);
    }


}
