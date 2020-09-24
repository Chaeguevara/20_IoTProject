package com.frame;

public class Sql {
	public static String userInsert = 
	"INSERT INTO USERS VALUES(?,?,?)";
	public static String userDelete = 
	"DELETE FROM USERS WHERE ID=?";
	public static String userUpdate = 
	"UPDATE USERS SET PWD=?,NAME=? WHERE ID=?";
	public static String userSelect = 
	"SELECT * FROM USERS WHERE ID=?";
	public static String userSelectAll = 
	"SELECT * FROM USERS";
	
	public static String productInsert = 
	"INSERT INTO PRODUCT VALUES(?,?,?,?,SYSDATE)";
	public static String productDelete = 
	"DELETE FROM PRODUCT WHERE ID=?";
	public static String productUpdate = 
	"UPDATE PRODUCT SET NAME=?,PRICE=?,RATE=? WHERE ID=?";
	public static String productSelect = 
	"SELECT * FROM PRODUCT WHERE ID=?";
	public static String productSelectAll = 
	"SELECT * FROM PRODUCT";
}









