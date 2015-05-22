package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * DBEvent
 * This class is responsible for accesses to the database for the
 * events.
 * 
 * @author Sarah Bulk
 */
public class DBEvent implements IEventsList {

	private static DBEvent instance = null;

	/**
	 * static method to create an instance of this class
	 */
	public static DBEvent getInstance() {
		if (instance == null)
			instance = new DBEvent();
		return instance;
	}

	private Connection connection = null;

	/**
	 * The constructor to create an object. The constructor establishes a
	 * connection to the database.
	 */
	public DBEvent() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			connection = DriverManager
					.getConnection("jdbc:derby:ComedyVenueDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to retrieve every event
	 * 
	 * @return ArrayList<Event> A List of all the events as objects of the type
	 *         Event
	 */
	@Override
	public ArrayList<Event> getAllEvents() {
		ArrayList<Event> events = new ArrayList<Event>();
		if (connection != null) {
			try {
				String sql = "SELECT * FROM Event ORDER BY date";
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					int id = result.getInt("id");
					String name = result.getString("name");
					int price = result.getInt("price");
					String description = result.getString("description");
					int minAge = result.getInt("minAge");
					Timestamp date = result.getTimestamp("date");
					int seats = result.getInt("seats");

					ArrayList<Comedian> comedians = new ArrayList<Comedian>();

					Event event = new Event(id, name, price, description,
							minAge, date, seats, comedians);
					events.add(event);

				}

				sql = "SELECT * FROM Comedian join ComedianBooking on Comedian.id=ComedianBooking.comedianId";
				result = statement.executeQuery(sql);

				while (result.next()) {
					int eventId = result.getInt("eventId");
					int comedianId = result.getInt("comedianId");
					String comedianName = result.getString("name");
					String comedianDesc = result.getString("description");

					events.get(eventId - 1)
							.addComedian(
									new Comedian(comedianId, comedianName,
											comedianDesc));

				}

				statement.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return events;
	}

	/**
	 * method to add an event to the database
	 * 
	 * @param event
	 *            the event that has to be added
	 */
	@Override
	public void addEvent(Event event) {
		if (connection != null) {
			try {
				String sql = "INSERT INTO Event(name, prize,description,minAge,date,seats) VALUES ('"
						+ event.getName()
						+ "', '"
						+ event.getPrice()
						+ "', '"
						+ event.getDesc()
						+ "', '"
						+ event.getMinAge()
						+ "', '"
						+ event.getDate() + "', '" + event.getSeats() + "')";
				Statement statement = connection.createStatement();
				statement.executeUpdate(sql);
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * method to remove an event from the database
	 * 
	 * @param event
	 *            the event that has to be removed
	 */
	@Override
	public void removeEvent(Event event) {

		{
			try {
				String sql = "DELETE FROM Event " + "WHERE id = "
						+ event.getId();
				Statement statement = connection.createStatement();
				statement.executeUpdate(sql);
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
