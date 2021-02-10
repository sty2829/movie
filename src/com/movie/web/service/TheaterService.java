package com.movie.web.service;

import java.util.List;
import java.util.Map;

public interface TheaterService {

	public List<Map<String,String>> selectTheaterList(Map<String, String> theater);
	
	public Map<String,String> selectTheater(int tiNum);
	
	public Map<String,String> insertTheater(Map<String,String> theater);
	
	public Map<String,String> updateTheater(Map<String,String> theater);
	
	public Map<String,String> deleteTheater(int tiNum);
	
	
}
