package com.customerManagement.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customerManagement.Models.Customer;

@Repository
public class ServicesImpl  implements  Services {

	private SessionFactory sessionFactory;
	
	//creating session
	private Session session;
	
	@Autowired
	ServicesImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}

	@Transactional
	public List<Customer> findAll() {
		
		Transaction tx = session.beginTransaction();

		// find all the records from the database table
		List<Customer> customers = session.createQuery("from Customer").list();

		tx.commit();
		
		return customers;
	}
	
	@Transactional
	public void save(Customer theCustomer) {
		
		Transaction tx = session.beginTransaction();
		
		//save transaction
		session.saveOrUpdate(theCustomer);
		
		tx.commit();
	}

	@Transactional
	public void deleteById(int id) {
		Transaction tx = session.beginTransaction();
		
		// getting transaction
		Customer customer = session.get(Customer.class, id);
		
		//deleting record
		session.delete(customer);
		
		tx.commit();
	}

	@Transactional
	public Customer findById(int theId) {
		Transaction tx = session.beginTransaction();
		Customer theCustomer = session.get(Customer.class, theId);
		
		tx.commit();
		
		
		return theCustomer;
	}

	@Transactional
	public void update(int id) {
		
		Transaction tx = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, id);
		
		session.saveOrUpdate(customer);
		
		tx.commit();
	}

}
