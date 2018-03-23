package com.entity;

public class inventory implements java.io.Serializable{
	private int nid;
	private int inventory;
	private int bookID;
	public inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public inventory(int nid, int inventory, int bookID) {
		super();
		this.nid = nid;
		this.inventory = inventory;
		this.bookID = bookID;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookID;
		result = prime * result + inventory;
		result = prime * result + nid;
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
		inventory other = (inventory) obj;
		if (bookID != other.bookID)
			return false;
		if (inventory != other.inventory)
			return false;
		if (nid != other.nid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "inventory [nid=" + nid + ", inventory=" + inventory
				+ ", bookID=" + bookID + "]";
	}
}
