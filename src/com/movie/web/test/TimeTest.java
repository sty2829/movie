package com.movie.web.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		System.out.println("밀리세컨으로 계산된 : " + time);
		
		Date date = new Date();
		System.out.println("변환 전 : " + date);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = simpleDateFormat.format(date);
		System.out.println("변환 후 : " + dateStr);
		dateStr = simpleDateFormat.format(time);
		System.out.println("밀리 변환 후 : " + dateStr);
	}
}
