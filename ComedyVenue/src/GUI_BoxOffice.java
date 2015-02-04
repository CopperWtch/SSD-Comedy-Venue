import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;



public class GUI_BoxOffice extends JFrame {

	private JPanel contentPane;
	private JList<Event> lstEvents;
	private JList<Comedian> lstComedians;

	/**
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
		BorderLayout layoutRight = new BorderLayout();
		JPanel pnlRight=new JPanel(layoutRight);
		
	}

}
