package com.entity;

public class comment implements java.io.Serializable{
	private int commentid;
	private String comment;
	private int bookID;
	private int userID;
	public comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public comment(int commentid, String comment, int bookID, int userID) {
		super();
		this.commentid = commentid;
		this.comment = comment;
		this.bookID = bookID;
		this.userID = userID;
	}
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
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
		result = prime * result + bookID;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + commentid;
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
		comment other = (comment) obj;
		if (bookID != other.bookID)
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (commentid != other.commentid)
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "comment [commentid=" + commentid + ", comment=" + comment
				+ ", bookID=" + bookID + ", userID=" + userID + "]";
	}
}
