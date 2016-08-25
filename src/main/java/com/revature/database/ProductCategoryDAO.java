package com.revature.database;

import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Product;
import com.revature.beans.ProductCategory;

public class ProductCategoryDAO {

	private Session session;
	private List<ProductCategory> category = new Vector<ProductCategory>();
	
	public ProductCategoryDAO(Session session) {
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductCategory> getAllProductCategories(){
		Criteria criteria = session.createCriteria(ProductCategory.class);
		return criteria.list();
	}
	
	public ProductCategory getProductCategoryById(ProductCategory cat){
		Query query = session.createQuery("from ProductCategory where categoryId = :id");
		query.setInteger("id", cat.getCategoryId());
		return (ProductCategory) query.uniqueResult();
	}
	
	public ProductCategory getProductCategoryById(int id){
		Query query = session.createQuery("from ProductCategory where categoryId = :id");
		query.setInteger("id", id);
		return (ProductCategory) query.uniqueResult();
	}


	public void insert(Object obj){
		// discrete process
		session.save(obj);
	}
	
	public ProductCategory getProductCategoryByDescription(String description){
		Criteria criteria = session.createCriteria(ProductCategory.class);
		criteria.add(Restrictions.eq("categoryDescription", description));
		return (ProductCategory) criteria.uniqueResult();
	}
	
}
