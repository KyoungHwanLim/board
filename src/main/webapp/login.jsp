<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	h1{
		text-align : center;
	}
</style>


<body>
	<h1>나의 사이트</h1>
	<form action="${pageContext.request.contextPath }/login" method="post">
		<label>아이디 :  </label><input type="text" name="userId">
		<label>비밀번호 : </label><input type="password" name="userPass">
		<input type="submit" value="확인">		
	</form>
</body>
</html>