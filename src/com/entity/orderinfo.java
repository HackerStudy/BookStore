package com.entity;

public class orderinfo implements java.io.Serializable{
	private int orderinfoid;
	private int bookID;
	private String bookName;
	private double price;
	private int bookNumber;
	private double Subtotal;
	private String No;
	public orderinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public orderinfo(int orderinfoid, int bookID, String bookName,
			double price, int bookNumber, double subtotal, String no) {
		super();
		this.orderinfoid = orderinfoid;
		this.bookID = bookID;
		this.bookName = bookName;
		this.price = price;
		this.bookNumber = bookNumber;
		Subtotal = subtotal;
		No = no;
	}
	public int getOrderinfoid() {
		return orderinfoid;
	}
	public void setOrderinfoid(int orderinfoid) {
		this.orderinfoid = orderinfoid;
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
	public String getNo() {
		return No;
	}
	public void setNo(String no) {
		No = no;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((No == null) ? 0 : No.hashCode());
		long temp;
		temp = Double.doubleToLongBits(Subtotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + bookID;
		result = prime * result
				+ ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + bookNumber;
		result = prime * result + orderinfoid;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		orderinfo other = (orderinfo) obj;
		if (No == null) {
			if (other.No != null)
				return false;
		} else if (!No.equals(other.No))
			return false;
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
		if (orderinfoid != other.orderinfoid)
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "orderinfo [orderinfoid=" + orderinfoid + ", bookID=" + bookID
				+ ", bookName=" + bookName + ", price=" + price
				+ ", bookNumber=" + bookNumber + ", Subtotal=" + Subtotal
				+ ", No=" + No + "]";
	}
	
}
