package com.sql;

import java.sql.SQLException;

import com.dao.bookdao;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year = 2017,month = 5,day = 30;
		for(int i=1;i<66;i++){
			try {
				day--;
				if(day==20){
					month=month-1;
				}else if(day==10){
					month=month-1;
					year=year-1;
				}else if(day==1){
					month=month-1;
					year=year-1;
					day=30;
				}
				bookdao.intoshelftime(year,month,day,i);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
