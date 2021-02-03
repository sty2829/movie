package com.movie.web.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {

	private static final String DRIVER_CLASSS_NAME   = "oracle.jdbc.OracleDriver";
	private static final String URL  = "jdbc:oracle:thin:@localhost:1521/xe";
	private static final String USER  = "jtest";
	private static final String PASSWORD  = "ezen1234";
	
	static {
		try {
			Class.forName(DRIVER_CLASSS_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void close(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement st) {
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void close(PreparedStatement ps) {
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection con, Statement st) {
		close(con);
		close(st);
	}

	public static void close(Connection con, Statement st, ResultSet rs) {
		close(con);
		close(st);
		close(rs);
	}
	
	public static void close(Connection con, PreparedStatement ps) {
		close(con);
		close(ps);
	}

	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		close(con);
		close(ps);
		close(rs);
	}
	
	public static void commit(Connection con) {
		if(con!=null) {
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void rollback(Connection con) {
		if(con!=null) {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
