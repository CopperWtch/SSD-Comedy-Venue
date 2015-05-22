package model;

import java.io.Serializable;

/**
 * Comedian
 * This class describes the object type 'Comedian'.
 * 
 * @author Sarah Bulk
 * @version 1.0
 * @since 19.05.2015
 */
public class Comedian implements Serializable{
	
	private static final long serialVersionUID = -8772439028021070723L;
	private int id;
	private String name;
	private String desc;
	
	/**
	 * The constructor to create an object
	 * 
	 * @param id
	 *            The ID of the comedian
	 * @param name
	 *            The comedian's name
	 * @param desc
	 *            A description of the comedian
	 */
	public Comedian(int id, String name, String desc)
	{
		super();
		this.id=id;
		this.name=name;
		this.desc = desc;
	}

	/**
	 * 
	 * Data accessor methods
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * A method to generate a String representing the most important data.
	 * 
	 * @return A String object containing the data.
	 */
	@Override
	public String toString() {
		return name +": "+ desc;
	}

}
