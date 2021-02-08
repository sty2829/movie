<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
boolean upload = ServletFileUpload.isMultipartContent(request);
if(upload){
	DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
	ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
	List<FileItem> fileList = servletFileUpload.parseRequest(request);
	for(int i=0; i<fileList.size(); i++){
		FileItem fileItem = fileList.get(i);
		//해당 fileItem isFormField가 true면
		//해당 fileItem 은 file이 아님.
		if(fileItem.isFormField()){
			String name = fileItem.getFieldName();
			String value = fileItem.getString("UTF-8");
			out.println("니가 입력한 " + name + " : " + value + "<br>");
		}else{
			String name = fileItem.getFieldName();
			String fileName = fileItem.getName();
			out.println("니가 전송한 " + name + " : " + fileName);
		}
	}
	
}else{
	String id = request.getParameter("id");
	if(id!=null){
		out.println("니가 입력한 아이디: " + id);
		
	}
}
%>
<form method="post" enctype="multipart/form-data">
	<input type="text" name="id" placeholder="아이디"><br>
	<input type="text" name="name" placeholder="이름"><br>
	<input type="file" name="img" placeholder="프사"><br>
	<button>회원가입</button>
</form>
</body>
</html>