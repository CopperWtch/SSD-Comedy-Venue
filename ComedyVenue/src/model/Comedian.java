package model;

import java.io.Serializable;
public class Comedian implements Serializable{
	
	private int id;
	private String name;
	private String desc;
	
	public Comedian(int id, String name, String desc)
	{
		super();
		this.id=id;
		this.name=name;
		this.desc = desc;
	}

	//GETTER & SETTER
	//TODO CHECK VALUES
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name +": "+ desc;
	}

}
