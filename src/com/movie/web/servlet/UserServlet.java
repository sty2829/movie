package com.movie.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.service.UserService;
import com.movie.web.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String[] genres = request.getParameterValues("genre");
		String genre = "";
		for(int i=0; i<genres.length; i++) {
			genre += genres[i] + ",";
		}
		genre = genre.substring(0,genre.length()-1);
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String hint = request.getParameter("hint");
		String answer = request.getParameter("answer");
		Map<String,String> user = new HashMap<>();
		user.put("name", name);
		user.put("id", id);
		user.put("pwd", pwd);
		user.put("email", email);
		user.put("address", address);
		user.put("genre", genre);
		user.put("phone1", phone1);
		user.put("phone2", phone2);
		user.put("hint", hint);
		user.put("answer", answer);
		Map<String, String> rMap = userService.insertUser(user);
		request.setAttribute("rMap", rMap);
		ViewServlet.goPage(request, response, "/views/common/msg");
	}

}
