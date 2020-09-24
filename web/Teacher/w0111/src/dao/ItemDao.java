package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import frame.Dao;
import frame.Sql;
import vo.Item;

public class ItemDao extends Dao<Integer, Item> {

	@Override
	public void insert(Connection con, Item v) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.itemInsert);
			pstmt.setString(1,v.getName());
			pstmt.setInt(2,v.getPrice());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}	
	}

	@Override
	public void delete(Connection con, Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection con, Item v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Item select(Connection con, Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Item> select(Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Item> list = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(Sql.itemSelectAll);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int id = rset.getInt("ID");
				String name = rset.getString("NAME");
				int price = rset.getInt("PRICE");
				Date regdate = rset.getDate("REGDATE");
				Item item = new Item(id, name, price, regdate);
				list.add(item);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

}






