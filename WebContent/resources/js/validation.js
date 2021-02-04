/**
 * 
이름은 2글자 이상 10글자 이하
아이디는 4글자 이상 10글자 이하
비밀번호는 6글자 이상 20글자 이하
주소는 10글자 이상 100글자 이하
휴대폰번호 7글자 이상 10글자 이하
암호힌트는 반드시 선택 답변 반드시 입력 2글자 이상 10글자 이하
 */
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
			if(!validation('#name', 2, 10, '이름은 최소 2글자 최대 10글자 입니다.' )){
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
				console.log(pwd1.value.trim());
				alert('비밀번호가 일치하지 않습니다.');
				pwd2.value = '';
				pwd2.focus();
				return false;
			}
			if (!validation('#address', 10, 100, '주소는 최소 10글자 최대 100글자 입니다.')) {
				return false;
			}
			if (!validation('#phone2', 7, 10, '핸드폰 뒷자리는 최소 숫자 7자리 최대 10자리 입니다.')) {
				return false;
			}
			var phone2 = document.querySelector('#phone2');
			if(isNaN(phone2.value.trim())){
				alert('핸드폰 번호는 숫자로 입력해주세요');
				phone2.value = '';
				phone2.focus();
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
			var genres = document.querySelectorAll('[name=ui_genre]:checked');
			if(genres.length == 0){
				alert('좋아하는 장르를 1개 이상 선택해주세요.');
				document.querySelector('#genre1').focus();
				return false;
			}
			return true;
		}
		function goPage(url){
			location.href = url;
		}

