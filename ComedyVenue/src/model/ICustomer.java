package model;

import java.util.ArrayList;

public interface ICustomer {
	public ArrayList<Customer> getAllCustomers();
	public void addCustomer(Customer c);
	public void removeCustomer(Customer c);
}
