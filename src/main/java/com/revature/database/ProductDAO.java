package com.revature.database;

import java.io.IOException;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.beans.Product;

public class ProductDAO {

	private Session session;
	private static Properties colProduct;
	private List<Product> products = new Vector<Product>();
	private Product product = new Product();
	
	static{
		colProduct = new Properties();
		
		try {
			colProduct.load(
					ProductDAO.class.getClassLoader().getResourceAsStream("product.properties")
			);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public ProductDAO(Session session) {
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts(){
		Query query = session.createQuery("from Product");
		products = query.list();
		return products;
	}
	
	public Product getProductById(Product prod){
		Query query = session.createQuery("from Product where productUpc = :upc");
		query.setInteger("upc", prod.getProductUpc());
		return (Product) query.uniqueResult();
	}


	public void insert(Object obj){
		// discrete process
		session.save(obj);
	}
	
	public void updateProduct(Product prod){
		Query query = session.createQuery("update Product set productName= :name, productDescription= :description, "
				+"shortName= :short, unitCost= :unit, packSize= :size, reorderQuantity= :reorder, " 
				+"retailPrice= :retail, productWeight= :weight where productUpc = :upc");
		query.setString("name", prod.getProductName());
		query.setString("description", prod.getProductDescription());
		query.setString("short", prod.getShortName());
		query.setDouble("unit", prod.getUnitCost());
		query.setString("size", prod.getPackSize());
		query.setInteger("reorder", prod.getReorderQuantity());
		query.setDouble("retail", prod.getRetailPrice());
		query.setDouble("weight", prod.getProductWeight());
		query.setInteger("upc", prod.getProductUpc());
		query.executeUpdate();
	}
	
	public void deleteProduct(Product prod){
		Query query = session.createQuery("delete Product where productUpc = :upc");
		query.setInteger("upc", prod.getProductUpc());
		query.executeUpdate();		
	}
	
}
