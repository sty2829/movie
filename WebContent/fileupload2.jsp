<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
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
<form method="post" enctype="multipart/form-data" action="/file/test">
	<input type="file" name="f1"><br>
	<input type="file" name="f2"><br>
	<input type="file" name="f3"><br>
	<input type="file" name="f4"><br>
	<input type="text" name="t1"><br>
	<input type="text" name="t2"><br>
	<button>전송</button>
</form>
</body>
</html>