<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	li{
		list-style: none;
	}
</style>
<body>
	<header>
		<h1>스프링 mvc 테스트</h1>
	</header>
	<fieldset>
		<legend>log in</legend>
		
		<form action="login" method="post">
			<ul>
				<li><label>ID : <input type="text" name="id"></label></li>	
				<li><label>Password : <input type="password" name="password"></label></li>
			</ul>
			<input type="submit" value="Login" />
		</form>
		<a href="signup">signup</a>
	</fieldset>
	
	${errorMessage}
</body>
</html>