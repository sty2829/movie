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
 	<jsp:include page="/WEB-INF/views/include/menu.jsp"></jsp:include>
	<div class="container register">
		<div class="row">
		     <div class="col-md-3 register-left">
		         <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
		         <h3>안녕하세요</h3>
		         <p>저희 영화관에 오신것을 환영합니다.</p>
		         <input type="button" value="로그인" onclick="goPage('/views/user/login')" /><br/>
		     </div>
		     <div class="col-md-9 register-right">
		         <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
		         </ul>
		         <form enctype="multipart/form-data" action="/user/insert" method="post" onsubmit="return check()">
			         <div class="tab-content" id="myTabContent">
			             <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
			                 <h3 class="register-heading">회원가입</h3>
			                 <div class="row register-form">
			                     <div class="col-md-6">
			                         <div class="form-group">
			                             <input type="text" class="form-control" placeholder="이름" name="ui_name" id="name"/>
			                         </div>
			                         <div class="form-group">
			                             <input type="text" class="form-control" placeholder="아이디" name="ui_id" id="id" />
			                         </div>	
			                         <div class="form-group">
			                             <input type="password" class="form-control" placeholder="비밀번호" name="ui_pwd" id="pwd1"/>
			                         </div>
			                         <div class="form-group">
			                             <input type="password" class="form-control"  placeholder="비밀번호 재확인" id="pwd2"/>
			                         </div>
			                         <div class="form-group">
			                         	<input type="text" class="form-control" placeholder="주소" name="ui_address" id="address">
			                         </div>
			                     	 <div class="form-group">
			                     	 	<label for="genre1" style="float:left">스릴러</label>
			                         	<input type="checkbox" name="ui_genre" id="genre1" value="스릴러">
			                     	 	<label for="genre2">반전</label>
			                         	<input type="checkbox" name="ui_genre" id="genre2" value="반전">
			                         	<label for="genre3">추리</label>
			                         	<input type="checkbox" name="ui_genre" id="genre3" value="추리">
			                         	<label for="genre4">미스터리</label>
			                         	<input type="checkbox" name="ui_genre" id="genre4" value="미스터리">
			                         </div>
			                     </div>
			                     <div class="col-md-6">
			                         <div class="form-group">
			                             <input type="email" class="form-control" placeholder="이메일" name="ui_email" id="email" />
			                         </div>
			                         <div class="form-group">
			                         	<select name="ui_phone1" class="form-control" style="width:75px; float:left">
			                                 <option value="010">010</option>
			                                 <option value="011">011</option>
			                                 <option value="018">018</option>
			                                 <option value="019">019</option>
			                             </select>
			                             <input type="text" name="ui_phone2" id="phone2" class="form-control" placeholder="휴대 전화" style="width: 214px"/>
			                         </div>
			                         <div class="form-group">
			                             <select class="form-control" name="ui_hint" id="hint">
			                                 <option value="" class="hidden" selected>암호 힌트</option>
			                                 <option value="birthday">생년월일은 ?</option>
			                                 <option value="oldPhone">번호 뒷자리 ?</option>
			                                 <option value="petName">애완동물 이름은 ?</option>
			                             </select>
			                         </div>
			                         <div class="form-group">
			                             <input type="text" class="form-control" placeholder="답변을 입력해주세요" name="ui_answer" id="answer" />
			                         </div>
			                         <input type="submit" class="btnRegister"  value="가입하기"/>
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