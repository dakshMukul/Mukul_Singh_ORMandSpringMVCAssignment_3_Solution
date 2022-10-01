package com.customerManagement.services;

import java.util.List;


import com.customerManagement.Models.Customer;


public interface Services {
	
	public List<Customer> findAll();
	
	public Customer findById(int id);

	public void save(Customer theCustomer);
	
	public void update(int id);

	public void deleteById(int id);

	//public List<Student> searchBy(String name, String department);

}
