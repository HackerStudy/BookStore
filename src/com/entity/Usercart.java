package com.entity;

public class Usercart implements java.io.Serializable{
	private int userID;
	private	int bookID;
	private String bookName;
	private double price;
	private double costPrice;
	private int bookNumber;
	private double  Subtotal;
	public Usercart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usercart(int bookID, String bookName, double price,
			double costPrice, int bookNumber, double subtotal) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.price = price;
		this.costPrice = costPrice;
		this.bookNumber = bookNumber;
		Subtotal = subtotal;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}
	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	public double getSubtotal() {
		return Subtotal;
	}
	public void setSubtotal(double subtotal) {
		Subtotal = subtotal;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(Subtotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + bookID;
		result = prime * result
				+ ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + bookNumber;
		temp = Double.doubleToLongBits(costPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + userID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usercart other = (Usercart) obj;
		if (Double.doubleToLongBits(Subtotal) != Double
				.doubleToLongBits(other.Subtotal))
			return false;
		if (bookID != other.bookID)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (bookNumber != other.bookNumber)
			return false;
		if (Double.doubleToLongBits(costPrice) != Double
				.doubleToLongBits(other.costPrice))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usercart [userID=" + userID + ", bookID=" + bookID
				+ ", bookName=" + bookName + ", price=" + price
				+ ", costPrice=" + costPrice + ", bookNumber=" + bookNumber
				+ ", Subtotal=" + Subtotal + "]";
	}
	
	
}
