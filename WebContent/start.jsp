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
session.setAttribute("str", "난 어디서든 나옴");
String str = "안녕하쇼~";
request.setAttribute("str", str);
RequestDispatcher requestDispatcher = request.getRequestDispatcher("/end.jsp");
requestDispatcher.forward(request, response);
%>
</body>
</html>