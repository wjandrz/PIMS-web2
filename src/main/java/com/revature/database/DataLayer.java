package com.revature.database;

import org.hibernate.*;

import com.revature.PIMS.SessionFactoryManager;

public class DataLayer {

	private Session session; 
	private DAO dao;
	
	public DataLayer(){
		session = SessionFactoryManager.getInstance().openSession();
		dao = new DAO(session); 
	}
	
	public void close(){
		if(session!=null) session.close();
	}
	
	public void createRecord(Object obj){
		
		Transaction tx = session.beginTransaction();
		try{
			dao.insert(obj); 
			tx.commit(); 
		}catch(Throwable t){
			tx.rollback();
		}
	}
	
}