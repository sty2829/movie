package com.movie.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.movie.web.dao.TheaterDAO;
import com.movie.web.dao.impl.TheaterDAOImpl;
import com.movie.web.service.TheaterService;

public class TheaterServiceImpl implements TheaterService {
	
	private TheaterDAO theaterDAO = new TheaterDAOImpl();

	@Override
	public List<Map<String, String>> selectTheaterList(Map<String, String> theater) {
		return theaterDAO.selectTheaterList(theater);
	}

	@Override
	public Map<String, String> selectTheater(int tiNum) {
		return theaterDAO.selectTheater(tiNum);
	}

	@Override
	public Map<String, String> insertTheater(Map<String, String> theater) {
		Map<String,String> rMap = new HashMap<>();
		rMap.put("msg", "극장 등록에 성공하였습니다.");
		int result = theaterDAO.insertTheater(theater);
		if(result!=1) {
			rMap.put("msg", "극장 등록에 실패하였습니다.");
		}
		rMap.put("result", result+"");
		return rMap;
	}

	@Override
	public Map<String, String> updateTheater(Map<String, String> theater) {
		return null;
	}

	@Override
	public Map<String, String> deleteTheater(int tiNum) {
		int result = theaterDAO.deleteTheater(tiNum);
		Map<String,String> rMap = new HashMap<>();
		rMap.put("msg", "극장 삭제에 성공하였습니다.");
		if(result!=1) {
			rMap.put("msg", "극장 삭제에 실패하였습니다.");
		}
		rMap.put("result", result+"");
		return rMap;
	}
	
	public static void main(String[] args) {
		TheaterService theaterService = new TheaterServiceImpl();
		Map<String,String> theater = new HashMap<>();
		theater.put("ti_name", "테스트");
		theater.put("ti_address", "테스트어딘가");
		theater.put("ti_phone1", "010");
		theater.put("ti_phone2", "5612313");
		System.out.println(theaterService.insertTheater(theater));
	}
}
