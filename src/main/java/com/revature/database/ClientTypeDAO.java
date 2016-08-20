package com.revature.database;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.beans.Address;
import com.revature.beans.ClientType;
import com.revature.beans.StateAbbrv;

public class ClientTypeDAO {
	private Session session;
	
	public ClientTypeDAO(Session session){
		this.session = session;
	}
	
	public List<ClientType> getClientType(){
		Query query = session.createQuery("FROM ClientType");
		return query.list();
	}
	public ClientType getClientTypebyId(ClientType clientType){
		Query query = session.createQuery("FROM ClientType Where clientTypeId = :id");
		query.setParameter("id", clientType.getClientTypeId());
		return (ClientType) query.uniqueResult();
	}
	
	public void insert(ClientType clientType){
		session.save(clientType);
	}
	public void update(ClientType clientType){
		Query query = session.createQuery("update ClientType set clientType = :ct, "
				+ "where clientTypeId = :id");
		query.setString("ct", clientType.getClientType());
		query.setInteger("id", clientType.getClientTypeId());
		query.executeUpdate();
	}
	
	public void delete(ClientType clientType){
		Query query = session.createQuery("DELETE Address WHERE addressId = :id");
		query.setParameter("id", clientType.getClientTypeId());
		query.executeUpdate();
	}
}
