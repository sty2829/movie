package com.movie.web.dao;

import java.util.List;
import java.util.Map;

public interface TheaterDAO {


	public List<Map<String,String>> selectTheaterList(Map<String, String> theater);
	
	public Map<String,String> selectTheater(int tiNum);
	
	public int insertTheater(Map<String,String> theater);
	
	public int updateTheater(Map<String,String> theater);
	
	public int deleteTheater(int tiNum);

	
}
