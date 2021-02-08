package com.movie.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart) {
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
			try {
				List<FileItem> fileList = servletFileUpload.parseRequest(request);
				for(int i=0; i<fileList.size(); i++) {
					FileItem fileItem = fileList.get(i);
					String key = fileItem.getFieldName();
					String value = "";
					if(fileItem.isFormField()) {
						value = fileItem.getString("UTF-8");
					}else {
						value = fileItem.getName();
					}
					System.out.println("key : " + key);
					System.out.println("value : " + value);
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}else {
			
		}
	}

}
