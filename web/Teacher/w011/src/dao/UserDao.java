package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import frame.Dao;
import frame.Sql;
import vo.Item;
import vo.User;

public class UserDao extends Dao<String, User> {

	@Override
	public void insert(Connection con, User v) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.userInsert);
			pstmt.setString(1,v.getId());
			pstmt.setString(2,v.getPwd());
			pstmt.setString(3,v.getName());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}	
	}

	@Override
	public void delete(Connection con, String k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection con, User v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User select(Connection con, String k) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User user = null;
		try {
			pstmt = con.prepareStatement(Sql.userSelect);
			pstmt.setString(1,k);
			rset = pstmt.executeQuery();
			rset.next();
			String id = rset.getString("ID");
			String pwd = rset.getString("PWD");
			String name = rset.getString("NAME");
			user = new User(id, pwd, name);
		}catch(Exception e) {
			throw e;
		}finally {
			close(rset);
			close(pstmt);
		}
		return user;
	}

	@Override
	public ArrayList<User> select(Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<User> list = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(Sql.userSelectAll);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String id = rset.getString("ID");
				String pwd = rset.getString("PWD");
				String name = rset.getString("NAME");
				User user = new User(id, pwd, name);
				list.add(user);
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



