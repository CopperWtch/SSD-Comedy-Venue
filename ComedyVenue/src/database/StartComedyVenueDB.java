package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * StartComedyVenueDB This class was used to create the database and to fill it
 * with placeholder data for testing.
 * 
 * @author Sarah Bulk
 */
public class StartComedyVenueDB {
	public static void main(String[] args) {
		try {
			// Connect to the database
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			System.out.println("Treiberklasse wurde geladen.");
			//
			String url = "jdbc:derby:ComedyVenueDB;create=true";
			Connection connection = DriverManager.getConnection(url);
			System.out
					.println("Connecting to Database 'ComedyVenueDB' successful.");
			//
			Statement statement = connection.createStatement();
			// Delete all tables
			String sql = "DROP TABLE Event";
			System.out.println(sql);
			statement.executeUpdate(sql);
			sql = "DROP TABLE Comedian";
			System.out.println(sql);
			statement.executeUpdate(sql);
			sql = "DROP TABLE CustomerBooking";
			System.out.println(sql);
			statement.executeUpdate(sql);
			sql = "DROP TABLE ComedianBooking";
			System.out.println(sql);
			statement.executeUpdate(sql);
			// Create Events table
			sql = "CREATE TABLE Event ("
					+ "id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, "
					+ "name VARCHAR(100) NOT NULL, "
					+ "price DECIMAL NOT NULL, "
					+ "description VARCHAR(500) NOT NULL, "
					+ "minAge INTEGER NOT NULL, " + "date TIMESTAMP NOT NULL, "
					+ "seats INT NOT NULL)";
			System.out.println(sql);
			statement.executeUpdate(sql);

			// Create Comedian table
			sql = "CREATE TABLE Comedian ("
					+ "id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, "
					+ "name VARCHAR(100) NOT NULL, "
					+ "description VARCHAR(500))";
			System.out.println(sql);
			statement.executeUpdate(sql);

			// Create Bookings table
			sql = "CREATE TABLE CustomerBooking ("
					+ "eventId INTEGER NOT NULL, "
					+ "bookingId INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, "
					+ "bookingTime TIMESTAMP NOT NULL, "
					+ "numberSeats INTEGER NOT NULL, "
					+ "customerName VARCHAR(100) NOT NULL)";
			System.out.println(sql);
			statement.executeUpdate(sql);

			// Create Comedian Bookings table
			sql = "CREATE TABLE ComedianBooking ("
					+ "eventId INTEGER NOT NULL, "
					+ "comedianId INTEGER NOT NULL, "
					+ "PRIMARY KEY(eventId,comedianId))";
			System.out.println(sql);
			statement.executeUpdate(sql);

			// ADD DATA

			// Add events for testing
			sql = "INSERT INTO Event (name,price,description,minAge,date,seats) VALUES("
					+ "'SecondEvent',"
					+ "40,"
					+ "'This is the second event', "
					+ "18, " + "'2017-10-23 10:10:10.0', " + "250)";
			System.out.println(sql);
			statement.executeUpdate(sql);
			sql = "INSERT INTO Event (name,price,description,minAge,date,seats) VALUES("
					+ "'ThirdEvent',"
					+ "40,"
					+ "'This is the third event', "
					+ "18, " + "'2017-10-28 10:10:10.0', " + "250)";
			System.out.println(sql);
			statement.executeUpdate(sql);

			// Add placeholder Comedians for testing
			sql = "INSERT INTO Comedian (name,description) VALUES("
					+ "'Comedian One'," + "'This is a mediocre comedian!')";
			System.out.println(sql);
			statement.executeUpdate(sql);
			sql = "INSERT INTO Comedian (name,description) VALUES("
					+ "'Comedian Two'," + "'This is a mediocre comedian!')";
			System.out.println(sql);
			statement.executeUpdate(sql);
			sql = "INSERT INTO Comedian (name,description) VALUES("
					+ "'Comedian Three'," + "'This is a mediocre comedian!') ";
			System.out.println(sql);
			statement.executeUpdate(sql);

			// Assign comedians to events by creating comedian booking test data
			sql = "INSERT INTO ComedianBooking (eventId,comedianId) VALUES("
					+ "1," + "1) ";
			System.out.println(sql);
			statement.executeUpdate(sql);
			sql = "INSERT INTO ComedianBooking (eventId,comedianId) VALUES("
					+ "2," + "2) ";
			System.out.println(sql);
			statement.executeUpdate(sql);
			sql = "INSERT INTO ComedianBooking (eventId,comedianId) VALUES("
					+ "2," + "3) ";
			System.out.println(sql);
			statement.executeUpdate(sql);

			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
