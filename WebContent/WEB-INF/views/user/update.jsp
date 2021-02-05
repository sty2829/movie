<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>
<script src="/resources/js/validation.js"></script>
</head>
<body>
<%
Map<String,String> user = (Map<String,String>)session.getAttribute("user");
%>
 	<jsp:include page="/WEB-INF/views/include/menu.jsp"></jsp:include>
	<div class="container register">
		<div class="row">
		     <div class="col-md-3 register-left">
		         <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
		         <h3><%= user.get("ui_name")%>님 <br> 안녕하세요</h3>
		     </div>
		     <div class="col-md-9 register-right">
		         <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
		         </ul>
		         <form action="/user/insert" method="post" onsubmit="return check()">
			         <div class="tab-content" id="myTabContent">
			             <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
			                 <h3 class="register-heading">회원수정</h3>
			                 <div class="row register-form">
			                     <div class="col-md-6">
			                         <div class="form-group">
			                             <input type="text" class="form-control" placeholder="이름" name="ui_name" id="name" value="<%=user.get("ui_name")%>" />
			                         </div>
			                         <div class="form-group">
			                             <input type="text" class="form-control" placeholder="아이디" name="ui_id" id="id" value="<%=user.get("ui_id")%>" />
			                         </div>	
			                         <div class="form-group">
			                             <input type="password" class="form-control" placeholder="비밀번호" name="ui_pwd" id="pwd1"  />
			                         </div>
			                         <div class="form-group">
			                             <input type="password" class="form-control"  placeholder="비밀번호 재확인" id="pwd2"/>
			                         </div>
			                         <div class="form-group">
			                         	<input type="text" class="form-control" placeholder="주소" name="ui_address" id="address" value="<%=user.get("ui_address")%>">
			                         </div>
			                     	 <div class="form-group">
			                     	 	<label for="genre1" style="float:left">스릴러</label>
			                         	<input type="checkbox" name="ui_genre" id="genre1" value="스릴러" <%=user.get("ui_genre").contains("스릴러") ? "checked" : "" %>>
			                     	 	<label for="genre2">반전</label>
			                         	<input type="checkbox" name="ui_genre" id="genre2" value="반전" <%=user.get("ui_genre").contains("반전") ? "checked" : "" %>>
			                         	<label for="genre3">추리</label>
			                         	<input type="checkbox" name="ui_genre" id="genre3" value="추리" <%=user.get("ui_genre").contains("추리") ? "checked" : "" %>>
			                         	<label for="genre4">미스터리</label>
			                         	<input type="checkbox" name="ui_genre" id="genre4" value="미스터리" <%=user.get("ui_genre").contains("미스터리") ? "checked" : "" %>>
			                         </div>
			                     </div>
			                     <div class="col-md-6">
			                         <div class="form-group">
			                             <input type="email" class="form-control" placeholder="이메일" name="ui_email" id="email" value="<%=user.get("ui_email") != null ? user.get("ui_email") : "" %>" />
			                         </div>
			                         <div class="form-group">
			                         	<select name="ui_phone1" class="form-control" style="width:75px; float:left">
			                                 <option value="010" <%= "010".equals(user.get("ui_phone1")) ? "selected" : "" %>>010</option>
			                                 <option value="011" <%= "011".equals(user.get("ui_phone1")) ? "selected" : "" %>>011</option>
			                                 <option value="018" <%= "018".equals(user.get("ui_phone1")) ? "selected" : "" %>>018</option>
			                                 <option value="019" <%= "019".equals(user.get("ui_phone1")) ? "selected" : "" %>>019</option>
			                             </select>
			                             <input type="text" name="ui_phone2" id="phone2" value="<%=user.get("ui_phone2")%>" class="form-control" placeholder="휴대 전화" style="width: 214px"/>
			                         </div>
			                         <div class="form-group">
			                             <select class="form-control" name="ui_hint" id="hint">
			                                 <option value="" class="hidden" selected>암호 힌트</option>
			                                 <option value="birthday" <%= "birthday".equals(user.get("ui_hint")) ? "selected" : "" %>>생년월일은 ?</option>
			                                 <option value="oldPhone" <%= "oldPhone".equals(user.get("ui_hint")) ? "selected" : "" %>>번호 뒷자리 ?</option>
			                                 <option value="petName" <%= "petName".equals(user.get("ui_hint")) ? "selected" : "" %>>애완동물 이름은 ?</option>
			                             </select>
			                         </div>
			                         <div class="form-group">
			                             <input type="text" class="form-control" placeholder="답변을 입력해주세요" name="ui_answer" id="answer" value="<%=user.get("ui_answer")%>" />
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