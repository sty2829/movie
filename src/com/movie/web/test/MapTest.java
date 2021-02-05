package com.movie.web.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		map.put("name", "하하");
		map.put("age", "33");
		map.put("address", "seoul");
		map.put("hobby", "travle");
		
		
		Map<String,String> param = new HashMap<>();
		
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			param.put(key, map.get(key));
		}
		
	}
}
