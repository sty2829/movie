package com.movie.web.dao;

import java.util.List;
import java.util.Map;

public interface UserDAO {

	
	public List<Map<String,String>> selectUserList();
	
	public Map<String,String> selectUser(int uiNum);
	
	public int insertUser(Map<String,String> user);
	
	public int updateUser(Map<String,String> user);
	
	public int deleteUser(int uiNum);

}
