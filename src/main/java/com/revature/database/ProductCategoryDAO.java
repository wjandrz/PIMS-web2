package com.revature.database;

import java.io.IOException;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.beans.ProductCategory;

public class ProductCategoryDAO {

	private Session session;
	private List<ProductCategory> category = new Vector<ProductCategory>();
	
	public ProductCategoryDAO(Session session) {
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductCategory> getAllProductCategories(){
		Query query = session.createQuery("from ProductCategory");
		category = query.list();
		return category;
	}
	
	public ProductCategory getProductCategoryById(ProductCategory cat){
		Query query = session.createQuery("from ProductCategory where categoryId = :id");
		query.setInteger("id", cat.getCategoryId());
		return (ProductCategory) query.uniqueResult();
	}


	public void insert(Object obj){
		// discrete process
		session.save(obj);
	}
	
	public void updateProductCategory(ProductCategory cat){
		Query query = session.createQuery("update ProductCategory set categoryDescription= :description "
				+" where categoryId = :id");
		query.setString("description", cat.getCategoryDescription());
		query.setInteger("id", cat.getCategoryId());
		query.executeUpdate();
	}
	
	public void deleteProductCategory(ProductCategory cat){
		Query query = session.createQuery("delete ProductCategory where categoryId = :id");
		query.setInteger("id", cat.getCategoryId());
		query.executeUpdate();		
	}
	
}
