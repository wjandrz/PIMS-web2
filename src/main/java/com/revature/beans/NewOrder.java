package com.revature.beans;

public class NewOrder {
	
	private double subtotal;
	private double taxAmount;
	private double poTotal;
	private int clientId;
	
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
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
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public NewOrder(double subtotal, double taxAmount, double poTotal, int clientId) {
		super();
		this.subtotal = subtotal;
		this.taxAmount = taxAmount;
		this.poTotal = poTotal;
		this.clientId = clientId;
	}
	public NewOrder() {
		super();
	}
	
}
