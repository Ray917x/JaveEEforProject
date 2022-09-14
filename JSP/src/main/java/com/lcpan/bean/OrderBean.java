package com.lcpan.bean;
public class OrderBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private double price;
	private int quantity;
	private String bookno;
	
	public String getBookno() {
		return bookno;
	}
	public void setBookno(String bookno) {
		this.bookno = bookno;
	}
	public double getPrice() {
		return price;
	}
	public double getSubTotal() {
		return price * quantity;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}