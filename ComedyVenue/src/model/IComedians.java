package model;

import java.util.ArrayList;

/**
 * IComedians
 * This interface holds all the necessary information
 * for working with data concerning Comedians
 * 
 * @author Sarah Bulk
 */
public interface IComedians {
	public ArrayList<Comedian> getAllComedians();
	public void addComedian(Comedian c);
	public void removeComedian(Comedian c);
}
