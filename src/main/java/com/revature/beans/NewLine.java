package com.revature.beans;

public class NewLine {

	private int productUpc;
	private double unitPrice;
	private int qty;
	private int lineNumber;
	public int getProductUpc() {
		return productUpc;
	}
	public void setProductUpc(int productUpc) {
		this.productUpc = productUpc;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	public NewLine(int productUpc, double unitPrice, int qty, int lineNumber) {
		super();
		this.productUpc = productUpc;
		this.unitPrice = unitPrice;
		this.qty = qty;
		this.lineNumber = lineNumber;
	}
	public NewLine() {
		super();
	}
	
}
