package com.movie.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.movie.web.conn.DBConn;
import com.movie.web.dao.UserDAO;

public class UserDAOImpl implements UserDAO {
	
	private final String col = "ui_num\r\n" + 
			"ui_name\r\n" + 
			"ui_id\r\n" + 
			"ui_pwd\r\n" + 
			"ui_genre\r\n" + 
			"ui_email\r\n" + 
			"ui_phone1\r\n" + 
			"ui_phone2\r\n" + 
			"ui_address\r\n" + 
			"ui_hint\r\n" + 
			"ui_answer\r\n" + 
			"ui_img\r\n" +
			"credat\r\n" + 
			"cretim\r\n" + 
			"moddat\r\n" + 
			"modtim";
	
	private final String[] cols = col.split("\r\n");			

	@Override
	public List<Map<String, String>> selectUserList(Map<String, String> user) {
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String,String>> userList = new ArrayList<>();
		String sql = "select * from user_info";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,String> users = new HashMap<>();
				for(String col : cols) {
					users.put(col, rs.getString(col));
				}		
				userList.add(users);
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}
		return userList;
	}

	@Override
	public Map<String, String> selectUser(int uiNum) {
		String sql = "select * from user_info where ui_num = ?";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, uiNum);
			rs = ps.executeQuery();
			if(rs.next()) {
				Map<String,String> user = new HashMap<>();
				for(String col : cols) {
					user.put(col, rs.getString(col));
				}
				return user;
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}
		return null;
	}
	
	@Override
	public Map<String, String> selectUser(Map<String, String> user) {
		String sql = "select * from user_info where ui_id = ? and ui_pwd = ?";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.get("ui_id"));
			ps.setString(2, user.get("ui_pwd"));
			rs = ps.executeQuery();
			if(rs.next()) {
				Map<String,String> rUser = new HashMap<>();
				for(String col : cols) {
					rUser.put(col, rs.getString(col));
				}
				return rUser;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
			
		}
		
		return null;
	}	
	
	@Override
	public int insertUser(Map<String, String> user) {
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		int cnt = 0;
		String sql = "insert into user_info(ui_num, ui_name, ui_id, "
				+ "ui_pwd, ui_genre, ui_email, "
				+ "ui_phone1, ui_phone2, ui_address, "
				+ "ui_hint, ui_answer, ui_img, credat, "
				+ "cretim, moddat, modtim)"; 
		sql += " values(seq_ui_num.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_char(sysdate, 'YYYYMMDD'), to_char(sysdate, 'HH24MISS'), to_char(sysdate, 'YYYYMMDD'), to_char(sysdate, 'HH24MISS'))";
		try {
			ps = con.prepareStatement(sql);
			for(int i=1; i<=11; i++) {
				ps.setString(i,user.get(cols[i]));
			};
			cnt = ps.executeUpdate();
			DBConn.commit(con);
		} catch(Exception e) {
			DBConn.rollback(con);
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps);
		}
		
		return cnt;
	}

	@Override
	public int updateUser(Map<String, String> user) {
		String sql = "update user_info set";
		sql += " ui_pwd = ?,"; 
		sql += " ui_genre = ?,"; 
		sql += " ui_email = ?,"; 
		sql += " ui_phone1 = ?,"; 
		sql += " ui_phone2 = ?,"; 
		sql += " ui_address = ?,"; 
		sql += " ui_hint = ?,"; 
		sql += " ui_answer = ?,"; 
		sql += " ui_img = ?,"; 
		sql += " moddat = to_char(sysdate, 'YYYYMMDD'),"; 
		sql += " modtim = to_char(sysdate, 'HH24MISS')"; 
		sql += " where ui_num = ?"; 
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			ps = con.prepareStatement(sql);
			for(int i=3; i<11; i++) {
				ps.setString(i-2, user.get(cols[i]));
				ps.setString(10, user.get("ui_num"));
			}
			cnt = ps.executeUpdate();
			DBConn.commit(con);
		} catch(Exception e) {
			DBConn.rollback(con);
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps);
		}
		
		return cnt;
	}

	@Override
	public int deleteUser(int uiNum) {
		String sql = "delete from user_info where ui_num = ?"; 
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, uiNum);
			cnt = ps.executeUpdate();
			DBConn.commit(con);
		} catch(Exception e) {
			DBConn.rollback(con);
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps);
		}
		
		return cnt;
	}

	public static void main(String[] args) {
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		int beginIndex = userDAOImpl.col.indexOf("ui_pwd");
		int endIndex = userDAOImpl.col.lastIndexOf("credat");
		String col = userDAOImpl.col.substring(beginIndex, endIndex) + "ui_num" ;
		
		System.out.println(col);
	}
}