package com.revature.beans;

import java.util.*;

import javax.persistence.*;



@Entity
@Table(name="IMS_PURCHASE_ORDER")
public class PurchaseOrder {
	
		@Id
		@Column(name="ORDER_NUMBER", nullable=false)
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="purchaseOrderSeq")
		@SequenceGenerator(name="purchaseOrderSeq", sequenceName="PURCHASE_ORDER_SEQ",initialValue=1, allocationSize=1)
	private int orderNumber;
		@Column(name="SUBTOTAL", nullable=false)
	private double subtotal;
		@Column(name="PURCHASE_DATE", nullable=false)
	private Date purchaseDate;
		@Column(name="TAX_AMOUNT", nullable=false)
	private double taxAmount;
		@Column(name="PO_TOTAL", nullable=false)
	private double poTotal;
		@ManyToOne
		@JoinColumn(name="CLIENT_ID", nullable=false)
	private Client clientId;
		@OneToMany(mappedBy="compKey.orderNumber")
	private List<POLine> poLine;

	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public double getPoTotal() {
		return poTotal;
	}
	public void setPoTotal(double poTotal) {
		this.poTotal = poTotal;
	}
	public Client getClientId() {
		return clientId;
	}
	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}
	public PurchaseOrder(int orderNumber, double subtotal, Date purchaseDate, double taxAmount, double poTotal,
			Client clientId) {
		super();
		this.orderNumber = orderNumber;
		this.subtotal = subtotal;
		this.purchaseDate = purchaseDate;
		this.taxAmount = taxAmount;
		this.poTotal = poTotal;
		this.clientId = clientId;
	}
	public PurchaseOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	


}
