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

	@Override
	public List<Map<String, String>> selectUserList() {
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String,String>> userList = new ArrayList<>();
		String sql = "select * from user_info";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,String> user = new HashMap<>();
				user.put("ui_num", rs.getString("ui_num"));
				user.put("ui_name", rs.getString("ui_name"));
				user.put("ui_id", rs.getString("ui_id"));
				user.put("ui_pwd", rs.getString("ui_pwd"));
				user.put("ui_genre", rs.getString("ui_genre"));
				user.put("ui_email", rs.getString("ui_email"));
				user.put("ui_phone1", rs.getString("ui_phone1"));
				user.put("ui_phone2", rs.getString("ui_phone2"));
				user.put("ui_address", rs.getString("ui_address"));
				user.put("ui_hint", rs.getString("ui_hint"));
				user.put("ui_answer", rs.getString("ui_answer"));
				user.put("credat", rs.getString("credat"));
				user.put("cretim", rs.getString("cretim"));
				user.put("moddat", rs.getString("moddat"));
				user.put("modtim", rs.getString("modtim"));
				
				userList.add(user);
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
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String,String> user = new HashMap<>();
		String sql = "select * from user_info where ui_num = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, uiNum);
			rs = ps.executeQuery();
			if(rs.next()) {
				user.put("ui_num", rs.getString("ui_num"));
				user.put("ui_name", rs.getString("ui_name"));
				user.put("ui_id", rs.getString("ui_id"));
				user.put("ui_pwd", rs.getString("ui_pwd"));
				user.put("ui_genre", rs.getString("ui_genre"));
				user.put("ui_email", rs.getString("ui_email"));
				user.put("ui_phone1", rs.getString("ui_phone1"));
				user.put("ui_phone2", rs.getString("ui_phone2"));
				user.put("ui_address", rs.getString("ui_address"));
				user.put("ui_hint", rs.getString("ui_hint"));
				user.put("ui_answer", rs.getString("ui_answer"));
				user.put("credat", rs.getString("credat"));
				user.put("cretim", rs.getString("cretim"));
				user.put("moddat", rs.getString("moddat"));
				user.put("modtim", rs.getString("modtim"));
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}
		return user;
	}

	@Override
	public int insertUser(Map<String, String> user) {
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		int cnt = 0;
		String sql = "insert into user_info(UI_NUM, UI_NAME, UI_ID, "
				+ "UI_PWD, UI_GENRE, UI_EMAIL, "
				+ "UI_PHONE1, UI_PHONE2, UI_ADDRESS, "
				+ "UI_HINT, UI_ANSWER, CREDAT, "
				+ "CRETIM, MODDAT, MODTIM)"; 
		sql += " values(seq_ui_num.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_char(sysdate, 'YYYYMMDD'), to_char(sysdate, 'HH24MISS'), to_char(sysdate, 'YYYYMMDD'), to_char(sysdate, 'HH24MISS'))";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.get("name"));
			ps.setString(2, user.get("id"));
			ps.setString(3, user.get("pwd"));
			ps.setString(4, user.get("genre"));
			ps.setString(5, user.get("email"));
			ps.setString(6, user.get("phone1"));
			ps.setString(7, user.get("phone2"));
			ps.setString(8, user.get("address"));
			ps.setString(9, user.get("hint"));
			ps.setString(10, user.get("answer"));
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
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		int cnt = 0;
		String sql = "update user_info set";
		sql += " ui_name = ?"; 
		sql += " ui_pwd = ?"; 
		sql += " ui_genre = ?"; 
		sql += " ui_email = ?"; 
		sql += " ui_phone1 = ?"; 
		sql += " ui_phone2 = ?"; 
		sql += " ui_address = ?"; 
		sql += " ui_hint = ?"; 
		sql += " ui_answer = ?"; 
		sql += " moddat = to_char(sysdate, 'YYYYMMDD')"; 
		sql += " modtim = to_char(sysdate, 'HH24MISS')"; 
		sql += " where ui_num = ?"; 
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.get("name"));
			ps.setString(2, user.get("id"));
			ps.setString(3, user.get("pwd"));
			ps.setString(4, user.get("genre"));
			ps.setString(5, user.get("email"));
			ps.setString(6, user.get("phone1"));
			ps.setString(7, user.get("phone2"));
			ps.setString(8, user.get("address"));
			ps.setString(9, user.get("hint"));
			ps.setString(10, user.get("answer"));
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
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		int cnt = 0;
		String sql = "delete from user_info where ui_num = ?"; 
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
		UserDAO userDAO = new UserDAOImpl();
		System.out.println(userDAO.deleteUser(2));
	}
}
