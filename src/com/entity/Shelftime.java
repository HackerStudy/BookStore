package com.entity;

public class Shelftime implements java.io.Serializable{
	private int Shelftimeid;
	private int year;
	private int month;
	private int day;
	private int bookID;
	public Shelftime() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shelftime(int shelftimeid, int year, int month, int day, int bookID) {
		super();
		Shelftimeid = shelftimeid;
		this.year = year;
		this.month = month;
		this.day = day;
		this.bookID = bookID;
	}
	public int getShelftimeid() {
		return Shelftimeid;
	}
	public void setShelftimeid(int shelftimeid) {
		Shelftimeid = shelftimeid;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
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
		result = prime * result + Shelftimeid;
		result = prime * result + bookID;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
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
		Shelftime other = (Shelftime) obj;
		if (Shelftimeid != other.Shelftimeid)
			return false;
		if (bookID != other.bookID)
			return false;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Shelftime [Shelftimeid=" + Shelftimeid + ", year=" + year
				+ ", month=" + month + ", day=" + day + ", bookID=" + bookID
				+ "]";
	}
	
}
