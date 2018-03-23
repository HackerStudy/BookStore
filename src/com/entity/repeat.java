package com.entity;

public class repeat implements java.io.Serializable{
	private int repeatbookTypeID;

	public repeat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public repeat(int repeatbookTypeID) {
		super();
		this.repeatbookTypeID = repeatbookTypeID;
	}

	public int getRepeatbookTypeID() {
		return repeatbookTypeID;
	}

	public void setRepeatbookTypeID(int repeatbookTypeID) {
		this.repeatbookTypeID = repeatbookTypeID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + repeatbookTypeID;
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
		repeat other = (repeat) obj;
		if (repeatbookTypeID != other.repeatbookTypeID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "repeat [repeatbookTypeID=" + repeatbookTypeID + "]";
	}
	
}
