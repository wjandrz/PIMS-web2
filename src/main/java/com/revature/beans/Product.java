package com.revature.beans;

import java.sql.Blob;
import java.util.Arrays;
import java.util.Set;

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
		@Column(name="QUANTITY_ON_HAND")
	private int quantityOnHand;
		@ManyToMany
		@JoinTable(name="PRODUCT_CATEGORIES", 
				joinColumns=@JoinColumn(name="PRODUCT_UPC"),
				inverseJoinColumns=@JoinColumn(name="CATEGORY_ID"))
	private Set<ProductCategory> productCategories;
		
	/////////////////////////////////////////////////////
	//				Plain String
	/////////////////////////////////////////////////////
	private String strName;
	private String strDesc;
	private String strShName;
	private String strUnitCost;
	private String strPackSize;
	private String strReQuat;
	private String strRetail;
	private String strQOH;
	private String[] strProdCat;
		
	public Product(String strName, String strDesc, String strShName, String strUnitCost, String strPackSize,
			String strReQuat, String strRetail, String strQOH, String[] strProdCat) {
		super();
		this.strName = strName;
		this.strDesc = strDesc;
		this.strShName = strShName;
		this.strUnitCost = strUnitCost;
		this.strPackSize = strPackSize;
		this.strReQuat = strReQuat;
		this.strRetail = strRetail;
		this.strQOH = strQOH;
		this.strProdCat = strProdCat;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public String getStrDesc() {
		return strDesc;
	}
	public void setStrDesc(String strDesc) {
		this.strDesc = strDesc;
	}
	public String getStrShName() {
		return strShName;
	}
	public void setStrShName(String strShName) {
		this.strShName = strShName;
	}
	public String getStrUnitCost() {
		return strUnitCost;
	}
	public void setStrUnitCost(String strUnitCost) {
		this.strUnitCost = strUnitCost;
	}
	public String getStrPackSize() {
		return strPackSize;
	}
	public void setStrPackSize(String strPackSize) {
		this.strPackSize = strPackSize;
	}
	public String getStrReQuat() {
		return strReQuat;
	}
	public void setStrReQuat(String strReQuat) {
		this.strReQuat = strReQuat;
	}
	public String getStrRetail() {
		return strRetail;
	}
	public void setStrRetail(String strRetail) {
		this.strRetail = strRetail;
	}
	public String getStrQOH() {
		return strQOH;
	}
	public void setStrQOH(String strQOH) {
		this.strQOH = strQOH;
	}
	public String[] getStrProdCat() {
		return strProdCat;
	}
	public void setStrProdCat(String[] strProdCat) {
		this.strProdCat = strProdCat;
	}
	public Product(int productUpc, String productName, String productDescription, String shortName, double unitCost,
				String packSize, int reorderQuantity, double retailPrice, double productWeight, Blob productImage,
				int quantityOnHand, Set<ProductCategory> productCategories) {
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
		this.quantityOnHand = quantityOnHand;
		this.productCategories = productCategories;
	}
	public Product(String productName, String productDescription, String shortName, double unitCost,
			String packSize, int reorderQuantity, double retailPrice,
			int quantityOnHand, Set<ProductCategory> productCategories) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.shortName = shortName;
		this.unitCost = unitCost;
		this.packSize = packSize;
		this.reorderQuantity = reorderQuantity;
		this.retailPrice = retailPrice;
//		this.productWeight = productWeight;
		this.quantityOnHand = quantityOnHand;
		this.productCategories = productCategories;
	}
		
	public int getQuantityOnHand() {
		return quantityOnHand;
	}
	public void setQuantityOnHand(int quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}
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
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Set<ProductCategory> getProductCategories() {
		return productCategories;
	}
	public void setProductCategories(Set<ProductCategory> productCategories) {
		this.productCategories = productCategories;
	}
	@Override
	public String toString() {
		return "Product [productUpc=" + productUpc + ", productName=" + productName + ", productDescription="
				+ productDescription + ", shortName=" + shortName + ", unitCost=" + unitCost + ", packSize=" + packSize
				+ ", reorderQuantity=" + reorderQuantity + ", retailPrice=" + retailPrice + ", productWeight="
				+ productWeight + ", productImage=" + productImage + ", quantityOnHand=" + quantityOnHand
				+ ", productCategories=" + productCategories + ", strName=" + strName + ", strDesc=" + strDesc
				+ ", strShName=" + strShName + ", strUnitCost=" + strUnitCost + ", strPackSize=" + strPackSize
				+ ", strReQuat=" + strReQuat + ", strRetail=" + strRetail + ", strQOH=" + strQOH + ", strProdCat="
				+ Arrays.toString(strProdCat) + "]";
	}
	
	
	

}
