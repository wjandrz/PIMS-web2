package com.revature.database;

import java.util.List;
import java.util.Vector;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Client;

public class ClientDAO {
	
	private Session session;
	private List<Client> clients = new Vector<Client>();
	
	public ClientDAO(Session session){
		this.session = session;
	}

	public List<Client> getClients(){
		Query query = session.createQuery("from Client");
		return query.list();
	}
	public Client getClientsbyIdSupply(int id){
		Query query = session.createQuery("FROM Client WHERE clientId = :id "
				+ "AND clientTypeId = :type");
		query.setInteger("id", id);
		query.setInteger("type", 1);
		return (Client) query.uniqueResult();
	}
	public List<Client> getClientsbySupply(){
		Query query = session.createQuery("FROM Client WHERE clientTypeId = :type");
		query.setInteger("type", 1);
		return query.list();
	}
	public Client getClientsbyIdRetail(int id){
		Query query = session.createQuery("FROM Client WHERE clientId = :id "
				+ "AND clientTypeId = :type");
		query.setInteger("id", id);
		query.setInteger("type", 2);
		return (Client) query.uniqueResult();
	}
	public List<Client> getClientsbyRetail(){
		Query query = session.createQuery("FROM Client WHERE clientTypeId = :type");
		query.setInteger("type", 2);
		return query.list();
	}
	public void insert(Client client){
		session.saveOrUpdate(client);
	}
	
	public void update(Client client){
		Query query = session.createQuery("update Client set clientName = :name, "
				+ "clientEmail = :email, "
				+ "pointOfContactName = :pOCN, "
				+ "clientPhone = :phone, "
				+ "clientFax = :fax, "
				+ "where clientName = :name");
		query.setString("name", client.getClientName());
		query.setString("email", client.getClientEmail());
		query.setString("pOCN", client.getPointOfContactName());
		query.setString("phone", client.getClientPhone());
		query.setString("fax", client.getClientFax());
		query.executeUpdate();
	}
	
	public void delete(Client client){
		Query query = session.createQuery("DELETE Client WHERE clientName = :name");
		query.setString("name", client.getClientName());
		query.executeUpdate();
	}
}
