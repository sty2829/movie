package com.movie.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.service.TheaterService;
import com.movie.web.service.impl.TheaterServiceImpl;
import com.movie.web.util.MapConvert;


public class TheaterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TheaterService theaterService = new TheaterServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = MapConvert.getCmd(request.getRequestURI());
		Map<String,String> theater = MapConvert.getMap(request);
		Map<String,String> th = new HashMap<>();
		String path = "/views/theater/"+ cmd;
		
		if("list".equals(cmd)) {
			List<Map<String, String>> theaterList = theaterService.selectTheaterList(theater);
			request.setAttribute("theaterList", theaterList);
		}else if("view".equals(cmd)) {
			th = theaterService.selectTheater(Integer.parseInt(theater.get("ti_num")));
			request.setAttribute("theater", th);
		}else if("update".equals(cmd)) {
			th = theaterService.selectTheater(Integer.parseInt(theater.get("ti_num")));
			request.setAttribute("theater", th);
		}
		
		ViewServlet.goPage(request, response, path);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = MapConvert.getCmd(request.getRequestURI());
		Map<String, String> theater = MapConvert.getMap(request);
		Map<String, String> rMap = new HashMap<>();
		String path = "/views/theater/insert";
		if("insert".equals(cmd)) {
			rMap = theaterService.insertTheater(theater);
		}else if("update".equals(cmd)){
			rMap = theaterService.updateTheater(theater);
		}else if("delete".equals(cmd)) {
			rMap = theaterService.deleteTheater(Integer.parseInt(request.getParameter("ti_num")));
			response.sendRedirect("/theater/list");
			return;
		}
		
		request.setAttribute("rMap", rMap);
		ViewServlet.goPage(request, response, path);
	}

}
