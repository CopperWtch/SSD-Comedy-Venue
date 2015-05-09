package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Booking;

public class GUI_Bookings extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8346375180721960355L;

	private JPanel contentPane;
	
	private JPanel pnlRight;
	private JPanel pnlDetails;
	private JPanel pnlButtons;

	private JList<Booking> lstBookings;
	
	private JLabel lblBookingDate;
	private JTextField txtName;
	private JTextField txtNumSeats;
	private JTextField txtPhoneNr;
	private JTextField txtEmail;
	
	private JButton btnRemove;
	private JButton btnSave;
	private JButton btnClear;
	private JButton btnReturn;
	
	
	/**
	 * Create the frame.
	 */
	public GUI_Bookings() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(
				contentPane, BoxLayout.X_AXIS ));
		setContentPane(contentPane);
		
		lstBookings =  new JList<Booking>();
		JScrollPane spBookings = new JScrollPane(lstBookings);
		spBookings.setMaximumSize(new Dimension(200,600));
		spBookings.setBorder(BorderFactory.createTitledBorder("Bookings for this Event"));
		
		
		pnlRight = new JPanel();
		pnlRight.setLayout(new BoxLayout(pnlRight, BoxLayout.Y_AXIS));
		
		
		//DETAILS
		pnlDetails = new JPanel();
		pnlDetails.setLayout(new GridLayout(0, 2, 10, 10));
		pnlDetails.setBorder(BorderFactory.createTitledBorder("Details for this booking"));
		
		lblBookingDate = new JLabel("DATE");
		txtName = new JTextField("NAME");
		txtNumSeats = new JTextField("NUM SEATS");
		txtPhoneNr = new JTextField("PHONE");
		txtEmail = new JTextField("EMAIL");
		
		pnlDetails.add(lblBookingDate);
		pnlDetails.add(txtName);
		pnlDetails.add(txtNumSeats);
		pnlDetails.add(txtPhoneNr);
		pnlDetails.add(txtEmail);
		
		//BUTTONS
		pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridLayout(0, 2, 10, 10));
		
		btnRemove = new JButton("Remove");
		btnSave = new JButton("Save");
		btnClear = new JButton("Clear");
		btnReturn = new JButton("Return");
		
		pnlButtons.add(btnRemove);
		pnlButtons.add(btnSave);
		pnlButtons.add(btnClear);
		pnlButtons.add(btnReturn);
		
		pnlRight.add(pnlDetails);
		pnlRight.add(pnlButtons);
		
		contentPane.add(spBookings);
		contentPane.add(pnlRight);
	}
	
    public void setSaveListener(ActionListener l){
        this.btnSave.addActionListener(l);
    }
    
    public void setRemoveListener(ActionListener l){
        this.btnRemove.addActionListener(l);
    }
    public void setClearListener(ActionListener l){
        this.btnClear.addActionListener(l);
    }
    
    public void setReturnListener(ActionListener l){
        this.btnReturn.addActionListener(l);
    }
    
//  public void resetView(){
//  }
//
//  public String getEingabe(){
//  	return "";
//  }
//

}
