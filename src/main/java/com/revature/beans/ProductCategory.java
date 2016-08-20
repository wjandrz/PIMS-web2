package com.revature.beans;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="IMS_PRODUCT_CATEGORY")
public class ProductCategory {
	
		@Id
		@Column(name="CATEGORY_ID", nullable=false)
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="productCategorySeq")
		@SequenceGenerator(name="productCategorySeq", sequenceName="PRODUCT_CATEGORY_SEQ",initialValue=1, allocationSize=1)
	private int categoryId;
	
		@Column(name="CATEGORY_DESCRIPTION", nullable=false)
	private String categoryDescription;
		
		@ManyToMany
		@JoinTable(name="PRODUCT_CATEGORIES", 
				joinColumns=@JoinColumn(name="CATEGORY_ID"),
				inverseJoinColumns=@JoinColumn(name="PRODUCT_UPC"))
	private Set<Product> products;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}


	public ProductCategory(int categoryId, String categoryDescription, Set<Product> products) {
		super();
		this.categoryId = categoryId;
		this.categoryDescription = categoryDescription;
		this.products = products;
	}

	public ProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
		

}
