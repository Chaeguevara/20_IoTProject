package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.UserItem;

public class UserItemDao extends Dao<String, UserItem> {

	public ArrayList<UserItem> getItems(
			Connection con,String k) throws Exception{
		ArrayList<UserItem> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = con.prepareStatement(Sql.userItemSelect);
			pstmt.setString(1, k);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String id = rset.getString("ID");
				String user_id = rset.getString("USER_ID");
				int item_id = rset.getInt("ITEM_ID");
				String item_name = rset.getString("ITEM_NAME");
				int qt = rset.getInt("QT");
				UserItem userItem = 
				new UserItem(id, user_id, item_id, qt, item_name);
				list.add(userItem);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	
	@Override
	public void insert(Connection con, UserItem v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection con, String k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection con, UserItem v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserItem select(Connection con, String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserItem> select(Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
