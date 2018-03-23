package com.entity;

public class only implements java.io.Serializable{
	private int onlybookTypeID;

	public only() {
		super();
		// TODO Auto-generated constructor stub
	}

	public only(int onlybookTypeID) {
		super();
		this.onlybookTypeID = onlybookTypeID;
	}

	public int getOnlybookTypeID() {
		return onlybookTypeID;
	}

	public void setOnlybookTypeID(int onlybookTypeID) {
		this.onlybookTypeID = onlybookTypeID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + onlybookTypeID;
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
		only other = (only) obj;
		if (onlybookTypeID != other.onlybookTypeID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "only [onlybookTypeID=" + onlybookTypeID + "]";
	}
	
}
