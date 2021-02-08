<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
boolean isFileUpload = ServletFileUpload.isMultipartContent(request);
if(isFileUpload){
	out.print("파일 업로드네?");
}else{
	request.setCharacterEncoding("UTF-8");
	Map<String,String[]> params = request.getParameterMap();
	Map<String,String> param = new HashMap<>();
	Iterator<String> iterator = params.keySet().iterator();
	while(iterator.hasNext()){
		String key = iterator.next();
		String[] values = params.get(key);
		String value = "";
		for(int i=0; i<values.length; i++) {
			value += values[i] + ",";
		}
		value = value.substring(0,value.length()-1);
		param.put(key, value);
	}
	out.print(param);
}
%>
	<form method="post" action="/form.jsp">
		<input type="text" name="name" value="test">
		<button>전송</button>
	</form>
	<form method="post" action="/form.jsp" enctype="multipart/form-data">
		<input type="file" name="name" value="test">
		<button>전송</button>
	</form>
</body>
</html>