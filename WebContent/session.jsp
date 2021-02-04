<%@page import="java.text.SimpleDateFormat"%>
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
String sessionId = session.getId();
long createTime = session.getCreationTime();
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
session.setAttribute("id", "sim2829");
%>
<%="세션아이디 : " + sessionId %><br>
<%="세션생성시간 : " + simpleDateFormat.format(createTime)  %><br>
당신의 아이디 : <%=session.getAttribute("id") %>
</body>
</html>