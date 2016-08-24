package com.revature.database;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Address;

public class AddressDAO {
	
	private Session session;
	
	public AddressDAO(Session session){
		this.session = session;
	}

	public Address getAddress(String streetAddress1){
		Query query = session.createQuery("FROM Address WHERE streetAddress1 = :street1");
		query.setParameter("street1", streetAddress1);
		List<Address> add = (List<Address>) query.list();
		return add.get(0);
	}
	public void insert(Address address){
		Transaction tx = session.beginTransaction();
		try{
			session.saveOrUpdate(address);
			tx.commit();
		}catch (Throwable t) {
			tx.rollback();
		}
	}
	
	public void delete(int id){
		Transaction tx = session.beginTransaction();
		try{
			Query query = session.createQuery("DELETE Address WHERE addressId = :id");
			query.setParameter("id", id);
			query.executeUpdate();
			tx.commit();
		}catch (Throwable t) {
			tx.rollback();
		}
	}
}
