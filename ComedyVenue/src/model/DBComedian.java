package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * DBComedian
 * This class is responsible for accesses to the database for the
 * comedians.
 * 
 * @author Sarah Bulk
 */
public class DBComedian implements IComedians {

	private static DBComedian instance = null;

	/**
	 * static method to create an instance of this class
	 */
	public static DBComedian getInstance() {
		if (instance == null)
			instance = new DBComedian();
		return instance;
	}

	private Connection connection = null;

	/**
	 * The constructor to create an object. The constructor establishes a
	 * connection to the database.
	 */
	public DBComedian() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			connection = DriverManager
					.getConnection("jdbc:derby:ComedyVenueDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to retrieve every comedian.
	 * 
	 * @return ArrayList<Comediab> A List of all the comedians as objects of the
	 *         type Comedian
	 */
	@Override
	public ArrayList<Comedian> getAllComedians() {
		ArrayList<Comedian> comedians = new ArrayList<Comedian>();
		if (connection != null) {
			try {
				String sql = "SELECT * FROM Comedian ORDER BY id";
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					int id = result.getInt("id");
					String name = result.getString("name");
					String desc = result.getString("desc");

					Comedian comedian = new Comedian(id, name, desc);
					comedians.add(comedian);

				}

				statement.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return comedians;
	}

	/**
	 * method to add a comedian to the database
	 * 
	 * @param c
	 *            The comedian that needs to be added
	 */
	@Override
	public void addComedian(Comedian c) {
		if (connection != null) {
			try {
				String sql = "INSERT INTO Comedian(name, desc) VALUES ('"
						+ c.getName() + "', '" + c.getDesc() + "')";
				Statement statement = connection.createStatement();
				statement.executeUpdate(sql);
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * method to remove a comedian from the database
	 * 
	 * @param c
	 *            the comedian that has to be removed
	 */
	@Override
	public void removeComedian(Comedian c) {
		if (connection != null) {
			try {
				String sql = "DELETE FROM Comedian " + "WHERE id = "
						+ c.getId();
				Statement statement = connection.createStatement();
				statement.executeUpdate(sql);
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
