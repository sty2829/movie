<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/css/common.css">
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 
이름은 2글자 이상 10글자 이하
아이디는 4글자 이상 10글자 이하
비밀번호는 6글자 이상 20글자 이하
주소는 10글자 이상 100글자 이하
휴대폰번호 7글자 이상 10글자 이하
암호힌트는 반드시 선택 답변 반드시 입력 2글자 이상 10글자 이하
 -->
	<div class="container register">
		<div class="row">
		     <div class="col-md-3 register-left">
		         <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
		         <h3>안녕하세요</h3>
		         <p>저희 영화관에 오신것을 환영합니다.</p>
		         <input type="button" value="로그인"/><br/>
		     </div>
		     <div class="col-md-9 register-right">
		         <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
		         </ul>
		         <form action="/user/insert" method="post" onsubmit="return check()">
			         <div class="tab-content" id="myTabContent">
			             <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
			                 <h3 class="register-heading">회원가입</h3>
			                 <div class="row register-form">
			                     <div class="col-md-6">
			                         <div class="form-group">
			                             <input type="text" class="form-control" placeholder="이름" name="name" id="name"/>
			                         </div>
			                         <div class="form-group">
			                             <input type="text" class="form-control" placeholder="아이디" name="id" id="id" />
			                         </div>	
			                         <div class="form-group">
			                             <input type="password" class="form-control" placeholder="비밀번호" name="pwd" id="pwd1"/>
			                         </div>
			                         <div class="form-group">
			                             <input type="password" class="form-control"  placeholder="비밀번호 재확인" id="pwd2"/>
			                         </div>
			                         <div class="form-group">
			                         	<input type="text" class="form-control" placeholder="주소" name="address" id="address">
			                         </div>
			                     	 <div class="form-group">
			                     	 	<label for="genre1" style="float:left">스릴러</label>
			                         	<input type="checkbox" name="genre" id="genre1" value="스릴러">
			                     	 	<label for="genre2">반전</label>
			                         	<input type="checkbox" name="genre" id="genre2" value="반전">
			                         	<label for="genre3">추리</label>
			                         	<input type="checkbox" name="genre" id="genre3" value="추리">
			                         	<label for="genre4">미스터리</label>
			                         	<input type="checkbox" name="genre" id="genre4" value="미스터리">
			                         </div>
			                     </div>
			                     <div class="col-md-6">
			                         <div class="form-group">
			                             <input type="email" class="form-control" placeholder="이메일" name="email" id="email" />
			                         </div>
			                         <div class="form-group">
			                         	<select name="phone1" class="form-control" style="width:75px; float:left">
			                                 <option value="010">010</option>
			                                 <option value="011">011</option>
			                                 <option value="018">018</option>
			                                 <option value="019">019</option>
			                             </select>
			                             <input type="text" name="phone2" id="phone2" class="form-control" placeholder="휴대 전화" style="width: 214px"/>
			                         </div>
			                         <div class="form-group">
			                             <select class="form-control" name="hint" id="hint">
			                                 <option value="" class="hidden" selected>암호 힌트</option>
			                                 <option value="birthday">생년월일은 ?</option>
			                                 <option value="oldPhone">번호 뒷자리 ?</option>
			                                 <option value="petName">애완동물 이름은 ?</option>
			                             </select>
			                         </div>
			                         <div class="form-group">
			                             <input type="text" class="form-control" placeholder="답변을 입력해주세요" name="answer" id="answer" />
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
	<script>
		function validation(id, min, max, msg) {
			var obj = document.querySelector(id);
			if ((min && obj.value.trim().length < min)
					|| (max && obj.value.trim().length > max)) {
				alert(msg);
				obj.value = '';
				obj.focus();
				return false;
			}
			return true;
		}
	
		function check(){
			if(!validation('#name', 2, 4, '이름은 최소 2글자 최대 10글자 입니다.' )){
				return false;
			}

			if(!validation('#id', 4, 10, '아이디는 최소 4글자 최대 10글자 입니다' )){
				return false;
			}
			
			if(!validation('#pwd1', 6, 20, '비밀번호는 최소 6글자 최대 10글자 입니다.' )){
				return false;
			}
			var pwd2 = document.querySelector('#pwd2');
			if(pwd1.value.trim() != pwd2.value.trim()){
				alert('비밀번호가 일치하지 않습니다.');
				pwd2.value = '';
				pwd2.focus();
				return false;
			}
			if (!validation('#address', 10, 100, '주소는 최소 10글자 최대 100글자 입니다.')) {
				return false;
			}
			if (!validation('#phone2', 7, 10, '핸드폰 뒷자리는 최소 숫자 7자리 입니다.')) {
				return false;
			}
			var hint = document.querySelector('#hint');
			if(hint.value == ''){
				alert('힌트를 선택해주세요');
				hint.focus();
				return false;
			}
			if (!validation('#answer', 2, 10, '답변은 최소 2글자 최대 10글자 입니다.')) {
				return false;
			}
			var genres = document.querySelectorAll('[name=genre]:checked');
			if(genres.length == 0){
				alert('좋아하는 장르를 1개 이상 선택해주세요.');
				document.querySelector('#genre1').focus();
				return false;
			}
			return true;
		}
	</script>
</body>

</html>