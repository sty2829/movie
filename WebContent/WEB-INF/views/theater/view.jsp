<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/menu.jsp"></jsp:include>
<% 
Map<String,String> theater = (Map<String,String>)request.getAttribute("theater");
%>
<div>
	<h3>극장정보</h3>
	<table class="table table-bordered">
		<tr>
			<th>극장번호</th>
			<td><%= theater.get("ti_num") %></td>
		</tr>
		<tr>
			<th>극장이름</th>
			<td><%= theater.get("ti_name") %></td>
		</tr>
		<tr>
			<th>극장주소</th>
			<td><%= theater.get("ti_address") %></td>
		</tr>
		<tr>
			<th>전화번호1</th>
			<td><%= theater.get("ti_phone1") %></td>
		</tr>
		<tr>
			<th>전화번호2</th>
			<td><%= theater.get("ti_phone2") %></td>
		</tr>
		<tr>
			<td><button class="btn btn-outline-success my2 my-sm-0" onclick="goPage('/theater/update?ti_num=<%=theater.get("ti_num") %>')">수정하기</button></td>	
			<td><button class="btn btn-outline-danger my2 my-sm-0" onclick="doDelete()">삭제하기</button></td>
		</tr>
	</table>
	<form id="deleteForm" action="/theater/delete" method="post">
		<input type="hidden" name="ti_num" value="<%=theater.get("ti_num") %>">
	</form>
</div>
<script>	
function goPage(url) {
	location.href=url;
}
function doDelete() {
	var isDelete = confirm("해당 극장 정보를 정말로 삭제 하시겠습니까?");
	if(isDelete){
		var deleteForm = document.querySelector('#deleteForm');
		deleteForm.submit();
	}
}
</script>
</body>
</html>