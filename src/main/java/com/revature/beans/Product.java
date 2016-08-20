package com.revature.beans;

import java.sql.Blob;

import javax.persistence.*;

@Entity
@Table(name="IMS_PRODUCT")
public class Product {
	
		@Id
		@Column(name="PRODUCT_UPC", nullable=false)
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="productSeq")
		@SequenceGenerator(name="productSeq", sequenceName="PRODUCT_SEQ",initialValue=1, allocationSize=1)
	private int productUpc;
		@Column(name="PRODUCT_NAME", nullable=false)
	private String productName;
		@Column(name="PRODUCT_DESCRIPTION", nullable=false)
	private String productDescription;
		@Column(name="SHORT_NAME", nullable=false)
	private String shortName;
		@Column(name="UNIT_COST", nullable=false)
	private double unitCost;
		@Column(name="PACK_SIZE", nullable=false)
	private String packSize;
		@Column(name="REORDER_QUANTITY", nullable=false)
	private int reorderQuantity;
		@Column(name="RETAIL_PRICE", nullable=false)
	private double retailPrice;
		@Column(name="PRODUCT_WEIGHT")
	private double productWeight;
		@Column(name="PRODUCT_IMAGE")
	private Blob productImage;
		
		
	public int getProductUpc() {
		return productUpc;
	}
	public void setProductUpc(int productUpc) {
		this.productUpc = productUpc;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}
	public String getPackSize() {
		return packSize;
	}
	public void setPackSize(String packSize) {
		this.packSize = packSize;
	}
	public int getReorderQuantity() {
		return reorderQuantity;
	}
	public void setReorderQuantity(int reorderQuantity) {
		this.reorderQuantity = reorderQuantity;
	}
	public double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public double getProductWeight() {
		return productWeight;
	}
	public void setProductWeight(double productWeight) {
		this.productWeight = productWeight;
	}
	public Blob getProductImage() {
		return productImage;
	}
	public void setProductImage(Blob productImage) {
		this.productImage = productImage;
	}	
	
	public Product(int productUpc, String productName, String productDescription, String shortName, double unitCost,
			String packSize, int reorderQuantity, double retailPrice, double productWeight, Blob productImage) {
		super();
		this.productUpc = productUpc;
		this.productName = productName;
		this.productDescription = productDescription;
		this.shortName = shortName;
		this.unitCost = unitCost;
		this.packSize = packSize;
		this.reorderQuantity = reorderQuantity;
		this.retailPrice = retailPrice;
		this.productWeight = productWeight;
		this.productImage = productImage;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
