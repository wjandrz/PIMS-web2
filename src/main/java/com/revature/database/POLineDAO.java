package com.revature.database;

import java.util.List;
import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.beans.POLine;
import com.revature.beans.PurchaseOrder;

public class POLineDAO {
	
	private Session session;
	private List<POLine> poLine = new Vector<POLine>();
	
	public POLineDAO(Session session){
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	public List<POLine> getAllPOLines(){
		Query query = session.createQuery("from POLine");
		poLine = query.list();
		return poLine;
	}
	
	public POLine getPOLineByOrderNumberAndLineNumber(POLine line){
		Query query = session.createQuery("from POLine where compKey.orderNumber = :orderNum and compKey.lineNumber = :lineNum");
		query.setInteger("comp", line.getCompKey().getOrderNumber().getOrderNumber());
		query.setInteger("lineNum", line.getCompKey().getLineNumber());
		return (POLine) query.uniqueResult();
	}
	
	public List<POLine> getPOLinesByOrderNumber(POLine line){
		Query query = session.createQuery("from POLine where compKey.getOrderNumber() = :orderNum");
		query.setInteger("comp", line.getCompKey().getOrderNumber().getOrderNumber());
		poLine = query.list();
		return poLine;
	}
	
	public void insert(Object obj){
		// discrete process
		session.save(obj);
	}
	
	

}
