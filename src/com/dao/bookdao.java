package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.Shelftime;
import com.entity.book;
import com.entity.inventory;
import com.entity.only;
import com.entity.repeat;
import com.entity.typeSon;
import com.util.DBUtil;
public class bookdao{
	public static Connection con;
	static{
		try {
			con = DBUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static List<book> searchbook(String keyword,int typeID,int priceflag)throws SQLException{
		Statement stmt=con.createStatement();
		String sql;
		if(priceflag==0){
			sql="select * from book where bookName like'%"+keyword+"%' AND BOOKTYPEID="+typeID+" order by price desc";
		}else{
			sql="select * from book where bookName like'%"+keyword+"%' AND BOOKTYPEID="+typeID+" order by price asc";
		}
		List<book> searchbooklist=new ArrayList<book>();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			int bookid=rs.getInt("id");
			String bookName=rs.getString("bookName");
			String anthor=rs.getString("anthor");
			double price=rs.getDouble("price");
			double costprice=rs.getDouble("costprice");
			String press=rs.getString("press");
			String content=rs.getString("content");
			String image=rs.getString("image");
			int bookTypeSonID=rs.getInt("bookTypeSonID");
			int bookTypeID=rs.getInt("bookTypeID");
			String typeSonName=querytypeSonName(bookTypeSonID);
			String typeName=querytypeName(bookTypeID);
			book searchbook=new book(bookid,bookName,anthor,price,costprice,press,content,image,bookTypeSonID,typeSonName,bookTypeID,typeName);
			searchbooklist.add(searchbook);
		}
		DBUtil.close(stmt, rs);
	    return searchbooklist;
}	
	public static List<book> searchbook(String keyword)throws SQLException{
			Statement stmt=con.createStatement();
			String sql = "SELECT * FROM BOOK where bookName like'%"+keyword+"%'";
			List<book> searchbooklist=new ArrayList<book>();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				int bookid=rs.getInt("id");
				String bookName=rs.getString("bookName");
				String anthor=rs.getString("anthor");
				double price=rs.getDouble("price");
				double costprice=rs.getDouble("costprice");
				String press=rs.getString("press");
				String content=rs.getString("content");
				String image=rs.getString("image");
				int bookTypeSonID=rs.getInt("bookTypeSonID");
				int bookTypeID=rs.getInt("bookTypeID");
				String typeSonName=querytypeSonName(bookTypeSonID);
				String typeName=querytypeName(bookTypeID);
				book searchbook=new book(bookid,bookName,anthor,price,costprice,press,content,image,bookTypeSonID,typeSonName,bookTypeID,typeName);
				searchbooklist.add(searchbook);
			}
			DBUtil.close(stmt, rs);
		    return searchbooklist;
	}	
	public static List<book> querytypebook(int start, int end, int bookTypeID)throws SQLException{
		int distance=end-start+1;
		List<book> typebooklist=new ArrayList<book>();
		Statement stmt=con.createStatement();
		String sql="SELECT * FROM BOOK WHERE BOOKTYPEID="+bookTypeID+" LIMIT "+start+","+distance+"";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			int bookid=rs.getInt("id");
			String bookName=rs.getString("bookName");
			String anthor=rs.getString("anthor");
			double price=rs.getDouble("price");
			double costprice=rs.getDouble("costprice");
			String press=rs.getString("press");
			String content=rs.getString("content");
			String image=rs.getString("image");
			int bookTypeSonID=rs.getInt("bookTypeSonID");
			String typeSonName=querytypeSonName(bookTypeSonID);
			String typeName=querytypeName(bookTypeID);
			book typebook=new book(bookid,bookName,anthor,price,costprice,press,content,image,bookTypeSonID,typeSonName,bookTypeID,typeName);
			typebooklist.add(typebook);
		}
		DBUtil.close(stmt, rs);
		return typebooklist;
	}
	public static List<book> querytypebook(int start, int end, int bookTypeID1,int bookTypeID2)throws SQLException{
		int distance=end-start+1;
		List<book> typebooklist=new ArrayList<book>();
		Statement stmt=con.createStatement();
		String sql="SELECT * FROM BOOK WHERE BOOKTYPEID="+bookTypeID1+" OR BOOKTYPEID="+bookTypeID2+" LIMIT "+start+","+distance+"";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			int bookid=rs.getInt("id");
			String bookName=rs.getString("bookName");
			String anthor=rs.getString("anthor");
			double price=rs.getDouble("price");
			double costprice=rs.getDouble("costprice");
			String press=rs.getString("press");
			String content=rs.getString("content");
			String image=rs.getString("image");
			int bookTypeSonID=rs.getInt("bookTypeSonID");
			String typeSonName=querytypeSonName(bookTypeSonID);
			int bookTypeID=rs.getInt("bookTypeID");
			String typeName=querytypeName(bookTypeID);
			book typebook=new book(bookid,bookName,anthor,price,costprice,press,content,image,bookTypeSonID,typeSonName,bookTypeID,typeName);
			typebooklist.add(typebook);
		}
		DBUtil.close(stmt, rs);
		return typebooklist;
	}
	public static List<book> querytypebook(int start, int end, int bookTypeID1,int bookTypeID2,int bookTypeID3)throws SQLException{
		int distance=end-start+1;
		List<book> typebooklist=new ArrayList<book>();
		Statement stmt=con.createStatement();
		String sql="SELECT * FROM BOOK WHERE BOOKTYPEID="+bookTypeID1+" OR BOOKTYPEID="+bookTypeID2+" OR BOOKTYPEID="+bookTypeID3+" LIMIT "+start+","+distance+"";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			int bookid=rs.getInt("id");
			String bookName=rs.getString("bookName");
			String anthor=rs.getString("anthor");
			double price=rs.getDouble("price");
			double costprice=rs.getDouble("costprice");
			String press=rs.getString("press");
			String content=rs.getString("content");
			String image=rs.getString("image");
			int bookTypeSonID=rs.getInt("bookTypeSonID");
			String typeSonName=querytypeSonName(bookTypeSonID);
			int bookTypeID=rs.getInt("bookTypeID");
			String typeName=querytypeName(bookTypeID);
			book typebook=new book(bookid,bookName,anthor,price,costprice,press,content,image,bookTypeSonID,typeSonName,bookTypeID,typeName);
			typebooklist.add(typebook);
		}
		DBUtil.close(stmt, rs);
		return typebooklist;
	}
	public static List<book> querytypesonbook(int start, int end, int bookTypeSonID)throws SQLException{
		int distance=end-start+1;
		List<book> typesonbooklist=new ArrayList<book>();
		Statement stmt=con.createStatement();
		String sql="SELECT * FROM BOOK WHERE BOOKTYPESONID="+bookTypeSonID+" LIMIT "+start+","+distance+"";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			int bookid=rs.getInt("id");
			String bookName=rs.getString("bookName");
			String anthor=rs.getString("anthor");
			double price=rs.getDouble("price");
			double costprice=rs.getDouble("costprice");
			String press=rs.getString("press");
			String content=rs.getString("content");
			String image=rs.getString("image");
			int bookTypeID=rs.getInt("bookTypeID");
			String typeSonName=querytypeSonName(bookTypeSonID);
			String typeName=querytypeName(bookTypeID);
			book typesonbook=new book(bookid,bookName,anthor,price,costprice,press,content,image,bookTypeSonID,typeSonName,bookTypeID,typeName);
			typesonbooklist.add(typesonbook);
		}
		DBUtil.close(stmt, rs);
		return typesonbooklist;
	}
	public static List<book> queryAllbook(int start, int end)throws SQLException{
		int distance=end-start+1;
		List<book> booklist=new ArrayList<book>();
		Statement stmt=con.createStatement();
		String sql="SELECT * FROM BOOK LIMIT "+start+","+distance+"";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			int bookid=rs.getInt("id");
			String bookName=rs.getString("bookName");
			String anthor=rs.getString("anthor");
			double price=rs.getDouble("price");
			double costprice=rs.getDouble("costprice");
			String press=rs.getString("press");
			String content=rs.getString("content");
			String image=rs.getString("image");
			int bookTypeSonID=rs.getInt("bookTypeSonID");
			int bookTypeID=rs.getInt("bookTypeID");
			String typeSonName=querytypeSonName(bookTypeSonID);
			String typeName=querytypeName(bookTypeID);
			book book=new book(bookid,bookName,anthor,price,costprice,press,content,image,bookTypeSonID,typeSonName,bookTypeID,typeName);
			booklist.add(book);
		}
		DBUtil.close(stmt, rs);
		return booklist;
	}
	public static String querytypeName(int bookTypeID)throws SQLException{
		String typeName = null;
		Statement stmt=con.createStatement();
		String sql="SELECT TYPENAME FROM BOOKTYPE WHERE ID="+bookTypeID+"";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			typeName=rs.getString("typeName");
		}
		DBUtil.close(stmt, rs);
		return typeName;
	}
	public static String querytypeSonName(int bookTypeSonID)throws SQLException{
		String typeSonName = null;
		Statement stmt=con.createStatement();
		String sql="SELECT TYPESONNAME FROM BOOKTYPESON WHERE ID="+bookTypeSonID+"";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			typeSonName=rs.getString("typeSonName");
		}
		DBUtil.close(stmt, rs);
		return typeSonName;
	}
	public static List<typeSon> qtypeSon(int bookTypeID1)throws SQLException{
		List<typeSon> Sonlist=new ArrayList<typeSon>();
		Statement stmt=con.createStatement();
		String sql="SELECT * FROM BOOKTYPESON WHERE bookTypeID="+bookTypeID1+"";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			int bookTypeSonID=rs.getInt("id");
			String typeSonName=rs.getString("typeSonName");
			int bookTypeID=rs.getInt("bookTypeID");
			typeSon Son=new typeSon(bookTypeSonID,typeSonName,bookTypeID);
			Sonlist.add(Son);
		}
		DBUtil.close(stmt, rs);
		return Sonlist;
	}
	public static List<typeSon> qtypeSon(int bookTypeID1,int bookTypeID2)throws SQLException{
		List<typeSon> Sonlist=new ArrayList<typeSon>();
		Statement stmt=con.createStatement();
		String sql="SELECT * FROM BOOKTYPESON WHERE bookTypeID="+bookTypeID1+" OR BOOKTYPEID="+bookTypeID2+"";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			int bookTypeSonID=rs.getInt("id");
			String typeSonName=rs.getString("typeSonName");
			int bookTypeID=rs.getInt("bookTypeID");
			typeSon Son=new typeSon(bookTypeSonID,typeSonName,bookTypeID);
			Sonlist.add(Son);
		}
		DBUtil.close(stmt, rs);
		return Sonlist;
	}
	public static List<typeSon> qtypeSon(int bookTypeID1,int bookTypeID2,int bookTypeID3)throws SQLException{
		List<typeSon> Sonlist=new ArrayList<typeSon>();
		Statement stmt=con.createStatement();
		String sql="SELECT * FROM BOOKTYPESON WHERE bookTypeID="+bookTypeID1+" OR BOOKTYPEID="+bookTypeID2+" OR BOOKTYPEID="+bookTypeID3+"";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			int bookTypeSonID=rs.getInt("id");
			String typeSonName=rs.getString("typeSonName");
			int bookTypeID=rs.getInt("bookTypeID");
			typeSon Son=new typeSon(bookTypeSonID,typeSonName,bookTypeID);
			Sonlist.add(Son);
		}
		DBUtil.close(stmt, rs);
		return Sonlist;
	}
	public static int count()throws SQLException{
		Statement stmt=con.createStatement();
		String sql="SELECT count(*) count FROM BOOK";
		ResultSet rs=stmt.executeQuery(sql);
		if(rs.next()){
			return rs.getInt("count");
		}
		DBUtil.close(stmt, rs);
		return 0;
	}
	public static int bookspage() throws SQLException{
		 //1.获取t_book表的记录总数
			int count =bookdao.count();
			int pageNum = 12;
			int pages = count % pageNum == 0?count/pageNum:count/pageNum+1;
			return pages;
	}
	public static int bookspage(int bookTypeID) throws SQLException{
		 //1.获取t_book表的记录总数
			int count =bookdao.countType(bookTypeID);
			int pageNum = 12;
			int pages = count % pageNum == 0?count/pageNum:count/pageNum+1;
			return pages;
	}
	public static int bookspage(int bookTypeID,int bookTypeID2) throws SQLException{
		 //1.获取t_book表的记录总数
			int count =bookdao.countType(bookTypeID,bookTypeID2);
			int pageNum = 12;
			int pages = count % pageNum == 0?count/pageNum:count/pageNum+1;
			return pages;
	}
	public static int bookspage(int bookTypeID,int bookTypeID2,int bookType3) throws SQLException{
		 //1.获取t_book表的记录总数
			int count =bookdao.countType(bookTypeID,bookTypeID2,bookType3);
			int pageNum = 12;
			int pages = count % pageNum == 0?count/pageNum:count/pageNum+1;
			return pages;
	}
	public static int booksSonpage(int bookTypeSonID) throws SQLException{
		 //1.获取t_book表的记录总数
			int count =bookdao.countSonType(bookTypeSonID);
			int pageNum = 12;
			int pages = count % pageNum == 0?count/pageNum:count/pageNum+1;
			return pages;
	}
	public static int countSonType(int bookTypeSonID)throws SQLException{
		Statement stmt=con.createStatement();
		String sql="SELECT count(*) count FROM BOOK WHERE BOOKTYPESONID="+bookTypeSonID+"";
		ResultSet rs=stmt.executeQuery(sql);
		if(rs.next()){
			return rs.getInt("count");
		}
		DBUtil.close(stmt, rs);
		return 0;
	}
	public static int countType(int bookTypeID)throws SQLException{
		Statement stmt=con.createStatement();
		String sql="SELECT count(*) count FROM BOOK WHERE BOOKTYPEID="+bookTypeID+"";
		ResultSet rs=stmt.executeQuery(sql);
		if(rs.next()){
			return rs.getInt("count");
		}
		DBUtil.close(stmt, rs);
		return 0;
	}
	public static int countType(int bookTypeID1,int bookTypeID2)throws SQLException{
		Statement stmt=con.createStatement();
		String sql="SELECT count(*) count FROM BOOK WHERE BOOKTYPEID="+bookTypeID1+" OR BOOKTYPEID="+bookTypeID2+"";
		ResultSet rs=stmt.executeQuery(sql);
		if(rs.next()){
			return rs.getInt("count");
		}
		DBUtil.close(stmt, rs);
		return 0;
	}
	public static int countType(int bookTypeID1,int bookTypeID2,int bookTypeID3)throws SQLException{
		Statement stmt=con.createStatement();
		String sql="SELECT count(*) count FROM BOOK WHERE BOOKTYPEID="+bookTypeID1+" OR BOOKTYPEID="+bookTypeID2+" OR BOOKTYPEID="+bookTypeID3+"";
		ResultSet rs=stmt.executeQuery(sql);
		if(rs.next()){
			return rs.getInt("count");
		}
		DBUtil.close(stmt, rs);
		return 0;
	}
	public static int getsalesNumber(int bookID) throws SQLException{
		int salesNumber = 0;
		Statement stmt=con.createStatement();
		String sql="SELECT SALESNUMBER FROM SALESNUMBER WHERE BOOKID="+bookID+"";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			salesNumber=rs.getInt("salesNumber");
		}
		DBUtil.close(stmt, rs);
		return salesNumber;
	}
	public static int addsalesNumber(int bookNumber,int salesNumber){
		int finNumber=0;
		finNumber=bookNumber+salesNumber;
		return finNumber;
	}
	public static void updatesalesNumber(int bookID,int finNumber) throws SQLException{
		Statement stmt=con.createStatement();
		String sql="UPDATE salesNumber SET SALESNUMBER="+finNumber+" WHERE BOOKID="+bookID+"";
		stmt.executeUpdate(sql);
		DBUtil.close(stmt);
	}
	public static List<book> querysalesbook() throws SQLException{
		List<book> salebooklist=new ArrayList<book>();
		Statement stmt=con.createStatement();
		String sql="select book.* from book,salesNumber where book.id=salesNumber.bookID order by salesNumber.salesNumber desc limit 0,4";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			int bookid=rs.getInt("id");
			String bookName=rs.getString("bookName");
			String anthor=rs.getString("anthor");
			double price=rs.getDouble("price");
			double costprice=rs.getDouble("costprice");
			String press=rs.getString("press");
			String content=rs.getString("content");
			String image=rs.getString("image");
			int bookTypeSonID=rs.getInt("bookTypeSonID");
			int bookTypeID=rs.getInt("bookTypeID");
			String typeSonName=querytypeSonName(bookTypeSonID);
			String typeName=querytypeName(bookTypeID);
			book book=new book(bookid,bookName,anthor,price,costprice,press,content,image,bookTypeSonID,typeSonName,bookTypeID,typeName);
			salebooklist.add(book);
		}
		DBUtil.close(stmt, rs);
		return salebooklist;
	}
	public static book queryb(int bookID) throws SQLException{
		book b=null;
		Statement stmt=con.createStatement();
		String sql="SELECT * FROM BOOK where id="+bookID+"";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			int bookid=rs.getInt("id");
			String bookName=rs.getString("bookName");
			String anthor=rs.getString("anthor");
			double price=rs.getDouble("price");
			double costprice=rs.getDouble("costprice");
			String press=rs.getString("press");
			String content=rs.getString("content");
			String image=rs.getString("image");
			int bookTypeSonID=rs.getInt("bookTypeSonID");
			int bookTypeID=rs.getInt("bookTypeID");
			String typeSonName=querytypeSonName(bookTypeSonID);
			String typeName=querytypeName(bookTypeID);
			b=new book(bookid,bookName,anthor,price,costprice,press,content,image,bookTypeSonID,typeSonName,bookTypeID,typeName);
		}
		DBUtil.close(stmt, rs);
		return b;
	}
	public static book querybk(int start, int end,int bookTypeID) throws SQLException{
		book b=null;
		Statement stmt=con.createStatement();
		String sql="SELECT * FROM BOOK where BOOKTYPEID="+bookTypeID+" LIMIT "+start+","+end+"";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			int bookid=rs.getInt("id");
			String bookName=rs.getString("bookName");
			String anthor=rs.getString("anthor");
			double price=rs.getDouble("price");
			double costprice=rs.getDouble("costprice");
			String press=rs.getString("press");
			String content=rs.getString("content");
			String image=rs.getString("image");
			int bookTypeSonID=rs.getInt("bookTypeSonID");
			String typeSonName=querytypeSonName(bookTypeSonID);
			String typeName=querytypeName(bookTypeID);
			b=new book(bookid,bookName,anthor,price,costprice,press,content,image,bookTypeSonID,typeSonName,bookTypeID,typeName);
		}
		DBUtil.close(stmt, rs);
		return b;
	}
	public static int compareCR(int cartbookTypeID,List<book> rlist) throws SQLException{
		int flag=0;
		for(book list:rlist){
			if(cartbookTypeID!=list.getBookTypeID()){
				flag=1;
			}
		}
		return flag;
	}
	public static int querybookTypeID(String typeName)throws SQLException{
		int bookTypeID = 0;
		Statement stmt=con.createStatement();
		String sql="SELECT id FROM BOOKTYPE WHERE TYPENAME='"+typeName+"'";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			bookTypeID=rs.getInt("id");
		}
		DBUtil.close(stmt, rs);
		return bookTypeID;
	}
	public static inventory qInventory(int bookID)throws SQLException{
		inventory inventory = null;
		Statement stmt=con.createStatement();
		String sql="SELECT * FROM INVENTORY WHERE BOOKID="+bookID+"";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			int nid=rs.getInt("id");
			int in=rs.getInt("inventory");
			int bID=rs.getInt("bookID");
			inventory=new inventory(nid, in, bID);
		}
		DBUtil.close(stmt,rs);
		return inventory;
	}
	public static int getsaleNumber(int bookID)throws SQLException{
		int saleNumber=0;
		Statement stmt=con.createStatement();
		String sql="SELECT * FROM SALESNUMBER WHERE BOOKID="+bookID+"";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			saleNumber=rs.getInt("salesNumber");
		}
		DBUtil.close(stmt,rs);
		return saleNumber;
	}
	public static List<book> querypricebook(int priceflag) throws SQLException{
		List<book> pricebooklist=new ArrayList<book>();
		Statement stmt=con.createStatement();
		String sql;
		if(priceflag==0){
			sql="select * from book order by price desc";
		}else{
			sql="select * from book order by price asc";
		}
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			int bookid=rs.getInt("id");
			String bookName=rs.getString("bookName");
			String anthor=rs.getString("anthor");
			double price=rs.getDouble("price");
			double costprice=rs.getDouble("costprice");
			String press=rs.getString("press");
			String content=rs.getString("content");
			String image=rs.getString("image");
			int bookTypeSonID=rs.getInt("bookTypeSonID");
			int bookTypeID=rs.getInt("bookTypeID");
			String typeSonName=querytypeSonName(bookTypeSonID);
			String typeName=querytypeName(bookTypeID);
			book book=new book(bookid,bookName,anthor,price,costprice,press,content,image,bookTypeSonID,typeSonName,bookTypeID,typeName);
			pricebooklist.add(book);
		}
		DBUtil.close(stmt, rs);
		return pricebooklist;
	}
//	public static void insertInventory(int bookID)throws SQLException{
//		Statement stmt=con.createStatement();
//		String sql="INSERT INTO INVENTORY (INVENTORY,BOOKID) VALUES(100,"+bookID+")";
//		stmt.execute(sql);
//		DBUtil.close(stmt);
//	}
	public static void intoshelftime(int year,int month,int day,int bookID)throws SQLException{
		Statement stmt=con.createStatement();
		String sql="INSERT INTO shelftime (year,month,day,bookID) VALUES("+year+","+month+","+day+","+bookID+")";
		stmt.execute(sql);
		DBUtil.close(stmt);
	}
	public static List<book> qshelftime(int start, int end, int bookTypeID)throws SQLException{
		int distance=end-start+1;
		List<book> typebooklist=new ArrayList<book>();
		Statement stmt=con.createStatement();
		String sql="SELECT book.* FROM book,shelftime WHERE book.id=shelftime.bookID and book.bookTypeID="+bookTypeID+" order by shelftime.year desc,shelftime.month desc,shelftime.day desc";
		ResultSet rs=stmt.executeQuery(sql);
		int i=0;
		while(rs.next()){
			if(i<4){
				int bookid=rs.getInt("id");
				String bookName=rs.getString("bookName");
				String anthor=rs.getString("anthor");
				double price=rs.getDouble("price");
				double costprice=rs.getDouble("costprice");
				String press=rs.getString("press");
				String content=rs.getString("content");
				String image=rs.getString("image");
				int bookTypeSonID=rs.getInt("bookTypeSonID");
				String typeSonName=querytypeSonName(bookTypeSonID);
				String typeName=querytypeName(bookTypeID);
				book typebook=new book(bookid,bookName,anthor,price,costprice,press,content,image,bookTypeSonID,typeSonName,bookTypeID,typeName);
				typebooklist.add(typebook);
			}
			i++;
		}
		DBUtil.close(stmt, rs);
		return typebooklist;
	}
	public static Shelftime qshelf(int bookID)throws SQLException{
		Shelftime t = null;
		Statement stmt=con.createStatement();
		String sql="SELECT * FROM shelftime WHERE bookID="+bookID+"";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			int id=rs.getInt("id");
			int year=rs.getInt("year");
			int month=rs.getInt("month");
			int day=rs.getInt("day");
			t=new Shelftime(id,year,month,day,bookID);
		}
		DBUtil.close(stmt, rs);
		return t;
	}
	public static List<book> qrecommendbook(List<repeat> replist,List<only> onlist){
		List<book> recommendbook=new ArrayList<book>();
		List<repeat> repeatlist=replist;
		List<only> onlylist=onlist;
		try {
			for(repeat r:repeatlist){
				book b=querybk(0, 1,r.getRepeatbookTypeID());
				book c=querybk(1, 1,r.getRepeatbookTypeID());
				recommendbook.add(b);
				recommendbook.add(c);
			}
			for(only o:onlylist){
				book b=querybk(0, 1,o.getOnlybookTypeID());
				book c=querybk(1, 1,o.getOnlybookTypeID());
				recommendbook.add(b);
				recommendbook.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recommendbook;
	}
	public static List<repeat> qrepeatbookTypeID(int userID){
		List<repeat> repeatlist=new ArrayList<repeat>();
		try {
			Statement stmt;
			stmt = con.createStatement();
			String sql="select book.bookTypeID from book,usercart where book.id=usercart.bookID and usercart.userID="+userID+" group by book.bookTypeID having COUNT(*)>1";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				int bookTypeID=rs.getInt("bookTypeID");
				repeat r=new repeat(bookTypeID);
				repeatlist.add(r);
			}
			DBUtil.close(stmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return repeatlist;
	}
	public static List<only> qonlybookTypeID(int userID){
		List<only> onlylist=new ArrayList<only>();
		try {
			Statement stmt;
			stmt = con.createStatement();
			String sql="select book.bookTypeID from book,usercart where book.id=usercart.bookID and usercart.userID="+userID+" group by book.bookTypeID having COUNT(*)=1";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				int bookTypeID=rs.getInt("bookTypeID");
				only o=new only(bookTypeID);
				onlylist.add(o);
			}
			DBUtil.close(stmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return onlylist;
	}
}
