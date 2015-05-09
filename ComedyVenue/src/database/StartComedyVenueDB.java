package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StartComedyVenueDB {
	public static void main(String[] args)
	   {
	      try
	      {
	         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	         System.out.println("Treiberklasse wurde geladen.");
	         //
	         String url = "jdbc:derby:ComedyVenueDB;create=true";
	         Connection connection = DriverManager.getConnection(url);
	         System.out.println("Connecting to Database 'ComedyVenueDB' successful.");
	         //
	         Statement statement = connection.createStatement();
	         //Delete all tables
//	         String sql = "DROP TABLE Event";
//		         System.out.println(sql);
//		         statement.executeUpdate(sql);
//		         sql = "DROP TABLE Comedian";
//		         System.out.println(sql);
//		         statement.executeUpdate(sql);
//		         sql = "DROP TABLE CustomerBooking";
//		         System.out.println(sql);
//		         statement.executeUpdate(sql);
//		         sql = "DROP TABLE ComedianBooking";
//		         System.out.println(sql);
//		         statement.executeUpdate(sql);
	         //Events
//	         String sql = "CREATE TABLE Event (" +
//	               "id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, " +
//	               "name VARCHAR(100) NOT NULL, " +
//	               "price DECIMAL NOT NULL, " +
//	               "description VARCHAR(500) NOT NULL, " +
//	               "minAge INTEGER NOT NULL, " +
//	               "date TIMESTAMP NOT NULL, " +
//	               "seats INT NOT NULL)";
//	         System.out.println(sql);
//	         statement.executeUpdate(sql);
////	         //
////	         sql = "CREATE TABLE Customer (" +
////	               "id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, " +
////	               "name VARCHAR(100) NOT NULL, " +
////	               "email VARCHAR(30) NOT NULL, " +
////	               "phoneNr VARCHAR(20))";
////	         System.out.println(sql);
////	         statement.executeUpdate(sql);
//	         //
//	         sql = "CREATE TABLE Comedian (" +
//		           "id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, " +
//		           "name VARCHAR(100) NOT NULL, " +
//		           "description VARCHAR(500))";
//		     System.out.println(sql);
//		     statement.executeUpdate(sql);
//		     
//		     //Bookings
//		     sql = "CREATE TABLE CustomerBooking (" +
//			       "eventId INTEGER NOT NULL, " +
//			       "bookingId INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY, " +
//			       "bookingTime TIMESTAMP NOT NULL, " +
//			       "numberSeats INTEGER NOT NULL, " +
//			       "customerName VARCHAR(100) NOT NULL)";
//			 System.out.println(sql);
//			 statement.executeUpdate(sql);
//		     //    
//		     sql = "CREATE TABLE ComedianBooking (" +
//		    	   "eventId INTEGER NOT NULL, " +
//				   "comedianId INTEGER NOT NULL, " +
//			       "PRIMARY KEY(eventId,comedianId))";
//			 System.out.println(sql);
//			 statement.executeUpdate(sql);			     
			     
			 
//			 //ADD DATA
//			 String sql = "INSERT INTO Event (name,price,description,minAge,date,seats) VALUES(" +
//		               "'SecondEvent'," +
//		               "40," +
//		               "'This is the second event', " +
//		               "18, " +
//		               "'2017-10-23 10:10:10.0', " +
//		               "250)";
//		         System.out.println(sql);
//		         statement.executeUpdate(sql);
//		         sql = "INSERT INTO Event (name,price,description,minAge,date,seats) VALUES(" +
//			               "'ThirdEvent'," +
//			               "40," +
//			               "'This is the third event', " +
//			               "18, " +
//			               "'2017-10-28 10:10:10.0', " +
//			               "250)";
//			         System.out.println(sql);
//			         statement.executeUpdate(sql);
	         
	         String sql = "INSERT INTO Comedian (name,description) VALUES(" +
		               "'Comedian One'," +
		               "'This is a mediocre comedian!')";
		         System.out.println(sql);
		         statement.executeUpdate(sql);
		         sql = "INSERT INTO Comedian (name,description) VALUES(" +
			               "'Comedian Two'," +
			               "'This is a mediocre comedian!')";
			     System.out.println(sql);
			     statement.executeUpdate(sql);
			     sql = "INSERT INTO Comedian (name,description) VALUES(" +
				               "'Comedian Three'," +
				               "'This is a mediocre comedian!') ";
				 System.out.println(sql);
				 statement.executeUpdate(sql);
				     
			     sql = "INSERT INTO ComedianBooking (eventId,comedianId) VALUES(" +
			               "1," +
			               "1) ";
			     System.out.println(sql);
			     statement.executeUpdate(sql);
			     sql = "INSERT INTO ComedianBooking (eventId,comedianId) VALUES(" +
			               "2," +
			               "2) ";
			     System.out.println(sql);
			     statement.executeUpdate(sql);
			     sql = "INSERT INTO ComedianBooking (eventId,comedianId) VALUES(" +
			               "2," +
			               "3) ";
			     System.out.println(sql);
			     statement.executeUpdate(sql);
			     
				 
	         statement.close();
	         connection.close();
	      }
	      catch(Exception e)
	      {
	         e.printStackTrace();
	      }
	   }
}
