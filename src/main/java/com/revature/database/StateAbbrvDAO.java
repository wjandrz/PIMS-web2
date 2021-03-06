package com.revature.database;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.beans.StateAbbrv;

public class StateAbbrvDAO {

	private Session session;
	
	public StateAbbrvDAO(Session session){
		this.session = session;
	}
	
	public List<StateAbbrv> getStateAbbrv(){
		Query query = session.createQuery("From StateAbbrv");
		return query.list();
	}
	public StateAbbrv getStateAbbrvbyId(int id){
		Query query = session.createQuery("From StateAbbrv Where abbrvId = :id");
		query.setParameter("id", id);
		return (StateAbbrv) query.uniqueResult();
	}
}
