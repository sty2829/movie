<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
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
List<Map<String,String>> addrList = new ArrayList<>();
Map<String,String> addr1 = new HashMap<>();
addr1.put("no","1");
addr1.put("area","서울");
addr1.put("cnt","20000000");
addrList.add(addr1);
Map<String,String> addr2 = new HashMap<>();
addr2.put("no","2");
addr2.put("area","경기");
addr2.put("cnt","10000000");
addrList.add(addr2);
Map<String,String> addr3 = new HashMap<>();
addr3.put("no","3");
addr3.put("area","충남");
addr3.put("cnt","10000000");
addrList.add(addr3);
%>
</body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>지역</th>
			<th>총확진자 수</th>
		</tr>
<%
int sum = 0;
for(Map<String,String> addr : addrList){
		sum += Integer.parseInt(addr.get("cnt"));
%>
		<tr>
			<td><%=addr.get("no") %></td>
			<td><%=addr.get("area") %></td>
			<td><%=addr.get("cnt") %></td>
		</tr>
<%	
}
		
%>
		<tr>
			<td colspan="2">총 인구수의 합 </td>
			<td><%=sum %></td>
		</tr>
	</table>


</html>