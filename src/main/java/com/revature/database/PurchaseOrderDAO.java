package com.revature.database;

import java.io.IOException;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.beans.PurchaseOrder;

public class PurchaseOrderDAO {

	private Session session;
	private List<PurchaseOrder> orders = new Vector<PurchaseOrder>();
	
	public PurchaseOrderDAO(Session session) {
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	public List<PurchaseOrder> getAllPurchaseOrders(){
		Query query = session.createQuery("from Product");
		orders = query.list();
		return orders;
	}
	
	public PurchaseOrder getPurchaseOrderById(PurchaseOrder order){
		Query query = session.createQuery("from PurchaseOrder where orderNumber = :orderNum");
		query.setInteger("orderNum", order.getOrderNumber());
		return (PurchaseOrder) query.uniqueResult();
	}
	
	public void updatePurchaseOrder(PurchaseOrder order){
		Query query = session.createQuery("update PurchaseOrder set subtotal= :sub, purchaseDate= :date, "
				+"taxAmount= :tax, poTotal= :total, clientId= :client where orderNumber = :orderNum");
		
		query.setDouble("sub", order.getSubtotal());
		query.setDate("date", order.getPurchaseDate());
		query.setDouble("tax", order.getTaxAmount());
		query.setDouble("total", order.getPoTotal());
		query.setInteger("client", order.getClientId().getClientId());
		query.setInteger("orderNum", order.getOrderNumber());
		query.executeUpdate();
	}
	
	public void deletePurchaseOrder(PurchaseOrder order){
		Query query = session.createQuery("delete PurchaseOrder where orderNumber = :orderNum");
		query.setInteger("orderNum", order.getOrderNumber());
		query.executeUpdate();		
	}
	
	public void insert(Object obj){
		// discrete process
		session.save(obj);
	}
	
}
