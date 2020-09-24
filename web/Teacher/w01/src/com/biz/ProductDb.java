package com.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.frame.Db;
import com.frame.Sql;
import com.vo.Product;

public class ProductDb extends Db<Integer, Product> {

	
	
	public ProductDb() {
		super();
	}

	public ProductDb(String ip, String dbid, String dbpwd) {
		super(ip, dbid, dbpwd);
	}

	@Override
	public void insert(Product v) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.productInsert);
			pstmt.setInt(1, v.getId());
			pstmt.setString(2, v.getName());
			pstmt.setInt(3, v.getPrice());
			pstmt.setDouble(4, v.getRate());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(con);
		}
	}

	@Override
	public void delete(Integer k) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;	
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.productDelete);
			pstmt.setInt(1, k);
			int result = pstmt.executeUpdate();
			if(result == 0) {
				throw new Exception();
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(con);
		}
	}

	@Override
	public void update(Product v) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;	
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.productUpdate);
			pstmt.setString(1, v.getName());
			pstmt.setInt(2, v.getPrice());
			pstmt.setDouble(3, v.getRate());
			pstmt.setInt(4, v.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(con);
		}
	}

	@Override
	public Product select(Integer k) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Product product = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.productSelect);
			pstmt.setInt(1, k);
			rset = pstmt.executeQuery();
			rset.next();
			int id = rset.getInt("ID");
			String name = rset.getString("NAME");
			int price = rset.getInt("PRICE");
			double rate = rset.getDouble("RATE");
			Date regdate = rset.getDate("regdate");
			product = 
			new Product(id, name, price, rate, regdate);
		}catch(Exception e) {
			throw e;
		}finally {
			close(rset);
			close(pstmt);
			close(con);
		}
		
		return product;
	}

	@Override
	public ArrayList<Product> select() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = new ArrayList<>();
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.productSelectAll);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Product product = null;
				int id = rset.getInt("ID");
				String name = rset.getString("NAME");
				int price = rset.getInt("PRICE");
				double rate = rset.getDouble("RATE");
				Date regdate = rset.getDate("regdate");
				product = new Product(id, name, price, rate, regdate);
				list.add(product);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(rset);
			close(pstmt);
			close(con);
		}
		return list;
	}

}
