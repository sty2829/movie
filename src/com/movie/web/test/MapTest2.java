package com.movie.web.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest2 {

	public static void main(String[] args) {
		Map<String, String[]> map = new HashMap<>();
		String[] name = {"하하"};
		String[] age = {"33"}; 
		String[] address = {"seoul"}; 
		String[] hobby = {"music", "travle"}; 
		
		map.put("name", name);
		map.put("age", age);
		map.put("address", address);
		map.put("hobby", hobby);
		
		
		Map<String,String> param = new HashMap<>();
		
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			String value = "";
			System.out.println("key : " + key);
			System.out.print("values : ");
			for(int i=0; i<map.get(key).length; i++) {
				value += map.get(key)[i] + ",";
				System.out.print(map.get(key)[i] + ",");
			}
			value = value.substring(0,value.length()-1);
			System.out.println();
			param.put(key, value);
		}
		System.out.println(param);
		
	}
}
