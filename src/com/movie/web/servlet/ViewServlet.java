package com.movie.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String PREFIX = "/WEB-INF";
    private static final String SUFFIX = ".jsp";
	
	public static void goPage(HttpServletRequest request, HttpServletResponse response,
			String path) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI();
		System.out.println(path);
		RequestDispatcher requestDispatcher = 
				request.getRequestDispatcher(PREFIX + path + SUFFIX);
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
