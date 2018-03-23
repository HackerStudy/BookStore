package com.entity;

public class book implements java.io.Serializable{
	private int bookid;
	private String bookName;
	private String author;
	private double price;
	private double costPrice;
	private String press;
	private String content;
	private String image;
	private int bookTypeSonID;
	private String typeSonName;
	private int bookTypeID;
	private String typeName;
	public book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public book(int bookid, String bookName, String author, double price,
			double costPrice, String press, String content, String image,
			int bookTypeSonID, String typeSonName, int bookTypeID,
			String typeName) {
		super();
		this.bookid = bookid;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.costPrice = costPrice;
		this.press = press;
		this.content = content;
		this.image = image;
		this.bookTypeSonID = bookTypeSonID;
		this.typeSonName = typeSonName;
		this.bookTypeID = bookTypeID;
		this.typeName = typeName;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result
				+ ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + bookTypeID;
		result = prime * result + bookTypeSonID;
		result = prime * result + bookid;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		long temp;
		temp = Double.doubleToLongBits(costPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((press == null) ? 0 : press.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((typeName == null) ? 0 : typeName.hashCode());
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
		book other = (book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (bookTypeID != other.bookTypeID)
			return false;
		if (bookTypeSonID != other.bookTypeSonID)
			return false;
		if (bookid != other.bookid)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (Double.doubleToLongBits(costPrice) != Double
				.doubleToLongBits(other.costPrice))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (press == null) {
			if (other.press != null)
				return false;
		} else if (!press.equals(other.press))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (typeName == null) {
			if (other.typeName != null)
				return false;
		} else if (!typeName.equals(other.typeName))
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
		return "book [bookid=" + bookid + ", bookName=" + bookName
				+ ", author=" + author + ", price=" + price + ", costPrice="
				+ costPrice + ", press=" + press + ", content=" + content
				+ ", image=" + image + ", bookTypeSonID=" + bookTypeSonID
				+ ", typeSonName=" + typeSonName + ", bookTypeID=" + bookTypeID
				+ ", typeName=" + typeName + "]";
	}
	
}
