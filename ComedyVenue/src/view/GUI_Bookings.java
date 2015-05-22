package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
import javax.swing.event.ListSelectionListener;

import model.Booking;
import model.Event;

/**
 * GUI_Bookings This class represents the view for the bookings. It contains a
 * JList with all the bookings for an event and text fields and labels for the
 * details of a booking.
 * 
 * @author Sarah Bulk
 * @version 1.0
 * @since 19.05.2015
 */
public class GUI_Bookings extends JFrame {

	/**
	 * declatations
	 */

	private static final long serialVersionUID = -8346375180721960355L;

	// date format to display the dates
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	private JPanel contentPane;

	private JPanel pnlRight;
	private JPanel pnlDetails;
	private JPanel pnlButtons;

	private JList<Booking> lstBookings;

	private JLabel lblEventName;
	private JLabel lblBookingTime;
	private JLabel lblErrorText;
	private JTextField txtName;
	private JTextField txtNumSeats;

	private JButton btnRemove;
	private JButton btnSave;
	private JButton btnClear;
	private JButton btnReturn;

	/**
	 * This method is used to create the frame.
	 */
	public GUI_Bookings() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		setContentPane(contentPane);

		lstBookings = new JList<Booking>();
		JScrollPane spBookings = new JScrollPane(lstBookings);
		spBookings.setMaximumSize(new Dimension(200, 600));
		spBookings.setMinimumSize(new Dimension(200, 100));
		spBookings.setBorder(BorderFactory
				.createTitledBorder("Bookings for this Event"));

		pnlRight = new JPanel();
		pnlRight.setLayout(new BoxLayout(pnlRight, BoxLayout.Y_AXIS));

		// DETAILS
		pnlDetails = new JPanel();
		pnlDetails.setLayout(new GridLayout(0, 2, 10, 10));
		pnlDetails.setBorder(BorderFactory
				.createTitledBorder("Details for this booking"));

		lblEventName = new JLabel("EVENT NAME");
		lblBookingTime = new JLabel("BOOKING TIME");
		txtName = new JTextField("NAME");
		txtNumSeats = new JTextField("NUM SEATS");

		pnlDetails.add(lblEventName);
		pnlDetails.add(lblBookingTime);
		pnlDetails.add(txtName);
		pnlDetails.add(txtNumSeats);

		// BUTTONS
		pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridLayout(0, 2, 10, 10));

		btnRemove = new JButton("Remove");
		btnSave = new JButton("Save");
		btnClear = new JButton("Clear");
		btnReturn = new JButton("Return");

		lblErrorText = new JLabel("ERROR?");

		pnlButtons.add(btnRemove);
		pnlButtons.add(btnSave);
		pnlButtons.add(btnClear);
		pnlButtons.add(btnReturn);

		pnlRight.add(pnlDetails);
		pnlRight.add(pnlButtons);
		pnlRight.add(lblErrorText);

		contentPane.add(spBookings);
		contentPane.add(pnlRight);
	}

	/**
	 * Update the details of an booking displayed on the right side of the frame
	 * 
	 * @param b
	 *            the booking of which the data is used for display
	 */
	public void setData(Booking b) {
		// Sets Booking details to the selected booking
		lblEventName.setText(b.getEvent().getName());
		lblBookingTime.setText(dateFormat.format(b.getBookingTime()));
		txtName.setText(b.getCustomerName());
		txtNumSeats.setText(Integer.toString(b.getNumSeats()));
	}

	/**
	 * empty the text fields
	 */
	public void clearView() {
		lblBookingTime.setText("");
		txtName.setText("");
		txtNumSeats.setText("");
	}

	/**
	 * enable/disable the 'save' button
	 * 
	 * @param b
	 *            the new boolean value
	 */
	public void SetBtnSaveEnabled(boolean b) {
		btnSave.setEnabled(b);
	}

	/**
	 * enable/disable the 'remove' button
	 * 
	 * @param b
	 *            the new boolean value
	 */
	public void setBtnRemoveEnabled(boolean b) {
		btnRemove.setEnabled(b);
	}

	/**
	 * Data Accessor Methods
	 */

	public void setSaveListener(ActionListener l) {
		this.btnSave.addActionListener(l);
	}

	public void setRemoveListener(ActionListener l) {
		this.btnRemove.addActionListener(l);
	}

	public void setClearListener(ActionListener l) {
		this.btnClear.addActionListener(l);
	}

	public void setReturnListener(ActionListener l) {
		this.btnReturn.addActionListener(l);
	}

	public void setCustomerBookingsListener(ListSelectionListener l) {
		this.lstBookings.addListSelectionListener(l);
	}

	public void setBookings(ArrayList<Booking> b) {

		if (b != null) {
			lstBookings.setListData(b.toArray(new Booking[0]));
		}

	}

	public JList<Booking> getLstBookings() {
		return lstBookings;
	}

	public void setLstBookings(JList<Booking> lstBookings) {
		this.lstBookings = lstBookings;
	}

	public String getName() {

		return txtName.getText();
	}

	public int getSeats() {

		try {
			// if is number
			int output = Integer.parseInt(txtNumSeats.getText());
			return output;
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public void setErrorText(String s) {
		lblErrorText.setText(s);
	}
}
