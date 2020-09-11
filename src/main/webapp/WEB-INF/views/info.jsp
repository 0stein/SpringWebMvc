<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		name : ${member.name} <br/>
		email : ${member.email} <br/>
		gender : ${member.gender} <br/>
		position : ${member.position } <br/>
		subscribe : 
		<c:forEach var="x" items="${member.hobby}">
			${x}&nbsp;
		</c:forEach>
		
	</p>
	<form action="info/data">
		<input type="submit" value="see data" />				
	</form>
</body>
</html>