<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form onsubmit="return check()">
	테스트: <input type="text" id="test">
	<button>확인</button>
	</form>	
	<script>
		function check(){
			console.log(test);
			
			return false;
		}
	
	</script>
</body>
</html>