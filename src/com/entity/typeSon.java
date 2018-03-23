package com.entity;

public class typeSon implements java.io.Serializable{
	private int bookTypeSonID;
	private String typeSonName;
	private int bookTypeID;
	public typeSon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public typeSon(int bookTypeSonID, String typeSonName, int bookTypeID) {
		super();
		this.bookTypeSonID = bookTypeSonID;
		this.typeSonName = typeSonName;
		this.bookTypeID = bookTypeID;
	}
	public int getBookTypeSonID() {
		return bookTypeSonID;
	}
	public void setBookTypeSonID(int bookTypeSonID) {
		this.bookTypeSonID = bookTypeSonID;
	}
	public String getTypeSonName() {
		return typeSonName;
	}
	public void setTypeSonName(String typeSonName) {
		this.typeSonName = typeSonName;
	}
	public int getBookTypeID() {
		return bookTypeID;
	}
	public void setBookTypeID(int bookTypeID) {
		this.bookTypeID = bookTypeID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookTypeID;
		result = prime * result + bookTypeSonID;
		result = prime * result
				+ ((typeSonName == null) ? 0 : typeSonName.hashCode());
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
		typeSon other = (typeSon) obj;
		if (bookTypeID != other.bookTypeID)
			return false;
		if (bookTypeSonID != other.bookTypeSonID)
			return false;
		if (typeSonName == null) {
			if (other.typeSonName != null)
				return false;
		} else if (!typeSonName.equals(other.typeSonName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "typeSon [bookTypeSonID=" + bookTypeSonID + ", typeSonName="
				+ typeSonName + ", bookTypeID=" + bookTypeID + "]";
	}
	
}
