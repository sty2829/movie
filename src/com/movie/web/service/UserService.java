package com.movie.web.service;

import java.util.List;
import java.util.Map;

public interface UserService {
	
	public List<Map<String,String>> selectUserList();
	
	public Map<String,String> selectUser(int uiNum);
	
	public Map<String,String> insertUser(Map<String,String> user);
	
	public Map<String,String> updateUser(Map<String,String> user);
	
	public Map<String,String> deleteUser(int uiNum);

}
