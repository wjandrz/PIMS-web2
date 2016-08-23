package com.revature.database;

import org.hibernate.Session;

public class DAO {

	private Session session;
	
	public DAO(Session session) {
		this.session = session;
	}

	public void insert(Object obj){
		// discrete process
		Object here = session.merge(obj);
		session.save(here);
	}
	
	
}
