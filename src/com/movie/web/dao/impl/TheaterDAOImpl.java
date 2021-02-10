package com.movie.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.movie.web.conn.DBConn;
import com.movie.web.dao.TheaterDAO;

public class TheaterDAOImpl implements TheaterDAO {

	@Override
	public List<Map<String, String>> selectTheaterList(Map<String, String> theater) {
		String sql = "select ti_num, ti_name, ti_address, ti_phone1, ti_phone2 "
				+ " from theater_info order by ti_num";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String, String>> theaterList = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String, String> ta = new HashMap<>();
				ta.put("ti_num", rs.getString("ti_num"));
				ta.put("ti_name", rs.getString("ti_name"));
				ta.put("ti_address", rs.getString("ti_address"));
				ta.put("ti_phone1", rs.getString("ti_phone1") != null ? rs.getString("ti_phone1") : "없음");
				ta.put("ti_phone2", rs.getString("ti_phone2") != null ? rs.getString("ti_phone2") : "없음");
				
				theaterList.add(ta);
			}
			return theaterList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}
		return null;
	}

	@Override
	public Map<String, String> selectTheater(int tiNum) {
		String sql = "select ti_num, ti_name, ti_address, ti_phone1, ti_phone2 "
				+ " from theater_info where ti_num = ?";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, tiNum);
			rs = ps.executeQuery();
			if(rs.next()) {
				Map<String,String> theater = new HashMap<>();
				theater.put("ti_num", rs.getString("ti_num"));
				theater.put("ti_name", rs.getString("ti_name"));
				theater.put("ti_address", rs.getString("ti_address"));
				theater.put("ti_phone1", rs.getString("ti_phone1") != null ? rs.getString("ti_phone1") : "");
				theater.put("ti_phone2", rs.getString("ti_phone2") != null ? rs.getString("ti_phone2") : "");
				return theater;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}
		
		return null;
	}

	@Override
	public int insertTheater(Map<String, String> theater) {
		String sql = "insert into theater_info(ti_num, ti_name, ti_address, ti_phone1, ti_phone2)";
		sql += " values(seq_ti_num.nextval, ?, ?, ?, ?)";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		int cnt = 0;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, theater.get("ti_name"));
			ps.setString(2, theater.get("ti_address"));
			ps.setString(3, theater.get("ti_phone1"));
			ps.setString(4, theater.get("ti_phone2"));
			cnt = ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			DBConn.rollback(con);
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps);
		}
		
		return cnt;
	}

	@Override
	public int updateTheater(Map<String, String> theater) {
		return 0;
	}

	@Override
	public int deleteTheater(int tiNum) {
		String sql = "delete from theater_info where ti_num = ?";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		int cnt = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, tiNum);
			cnt = ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			DBConn.rollback(con);
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps);
		}
		
		return cnt;
	}

	
	public static void main(String[] args) {
		TheaterDAO theaterDAO = new TheaterDAOImpl();
		Map<String,String> theater = new HashMap<>();
		System.out.println(theaterDAO.selectTheaterList(theater));
		
	}
}
