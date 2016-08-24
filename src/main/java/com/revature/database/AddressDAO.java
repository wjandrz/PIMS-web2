package com.revature.database;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

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
		session.saveOrUpdate(address);
	}
	public void update(Address address){
		Query query = session.createQuery("update Address set streetAddress1 = :sa1, "
				+ "streetAddress2 = :sa2, "
				+ "addressCity = :ac, "
				+ "stateId = :si, "
				+ "addressZip = :az, "
				+ "where addressId = :id");
		query.setString("sa1", address.getStreetAddress1());
		query.setString("sa2", address.getStreetAddress2());
		query.setString("ac", address.getAddressCity());
		query.setInteger("si", address.getStateId().getAbbrvId());
		query.setString("az", address.getAddressZip());
		query.setParameter("id", address.getAddressId());
		query.executeUpdate();
	}
	
	public void delete(Address address){
		Query query = session.createQuery("DELETE Address WHERE addressId = :id");
		query.setParameter("id", address.getAddressId());
		query.executeUpdate();
	}
}
