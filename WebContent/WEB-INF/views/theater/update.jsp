<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>극장 수정</title>
<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>
</head>
<body>
<%
Map<String,String> theater = (Map<String,String>)request.getAttribute("theater");
System.out.println(theater);
%>
<jsp:include page="/WEB-INF/views/include/menu.jsp"></jsp:include>
<div class="container register">
		<div class="row">
		     <div class="col-md-3 register-left">
		         <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
		         <h3>안녕하세요</h3>
		         <p>극장 수정 갑시다.</p>
		     </div>
		     <div class="col-md-9 register-right">
		         <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
		         </ul>
		         <form action="/theater/update" method="post">
			         <div class="tab-content" id="myTabContent">
			             <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
			                 <h3 class="register-heading">극장등록</h3>
			                 <div class="row register-form">
			                     <div class="col-md-6">
			                         <div class="form-group">
			                             <input type="text" class="form-control" placeholder="극장이름" name="ti_name" id="name" value="<%=theater.get("ti_name") %>"/>
			                         </div>
			                         <div class="form-group">
			                         	<input type="text" class="form-control" placeholder="극장주소" name="ti_address" id="address" value="<%=theater.get("ti_address") %>">
			                         </div>
			                     </div>
			                     <div class="col-md-6">
			                         <div class="form-group">
			                             <input type="text" class="form-control" placeholder="전화번호1" name="ti_phone1" id="phone1" value="<%=theater.get("ti_phone1") %>"/>
			                         </div>
			                         <div class="form-group">
			                             <input type="text" class="form-control" placeholder="전화번호2" name="ti_phone2" id="phone2" value="<%=theater.get("ti_phone2") %>"/>
			                         </div>
			                         <input type="submit" class="btnRegister"  value="수정하기"/>
			                     </div>
			                 </div>
			             </div>
			         </div>
		         </form>
		     </div>
		</div>
	</div>
</body>
</html>