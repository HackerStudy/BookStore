package com.entity;

public class order implements java.io.Serializable{
	private int orderid;
	private String No;
	private String date;
	private double totalprice;
	private int userID;
	public order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public order(int orderid, String no, String date, double totalprice,
			int userID) {
		super();
		this.orderid = orderid;
		No = no;
		this.date = date;
		this.totalprice = totalprice;
		this.userID = userID;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getNo() {
		return No;
	}
	public void setNo(String no) {
		No = no;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((No == null) ? 0 : No.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + orderid;
		long temp;
		temp = Double.doubleToLongBits(totalprice);
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
		order other = (order) obj;
		if (No == null) {
			if (other.No != null)
				return false;
		} else if (!No.equals(other.No))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (orderid != other.orderid)
			return false;
		if (Double.doubleToLongBits(totalprice) != Double
				.doubleToLongBits(other.totalprice))
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "order [orderid=" + orderid + ", No=" + No + ", date=" + date
				+ ", totalprice=" + totalprice + ", userID=" + userID + "]";
	}
	
	
}
