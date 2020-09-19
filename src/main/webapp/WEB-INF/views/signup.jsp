<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>sign up</legend>
		<form:form commandName="member">
			<ul>
				<li>
					<label>ID : <form:input path="id"/></label>
					<form:errors path="id"/>
				</li>
				<li>
					<label>Password : <form:password path="password"/></label>
					<form:errors path="password"/>
				</li>
				<li>
					<label>이름  : <form:input path="name"/></label>				
					<form:errors path="name"/>
				</li>
				<li>
					<label>이메일  : <form:input path="email"/></label>
					<form:errors path="email"/>
				</li>				
				<li>
					<p>성별</p>
					<form:radiobutton path="gender" value="male" label="남자" checked="checked"/>
					<form:radiobutton path="gender" value="female" label="여자"/>
				</li>
				<li>
					<form:select path="position">
						<form:option value="학생">학생</form:option>
						<form:option value="직장인">직장인</form:option>
						<form:option value="주부">주부</form:option>
					</form:select>
				</li>
				<li>
					<p>취미</p>
					<form:checkbox path="hobby" value="운동" label="운동" />
					<form:checkbox path="hobby" value="요리" label="요리" />
					<form:checkbox path="hobby" value="낚시" label="낚시" />					
				</li>
			</ul>
			<input type="submit" value="가입"/>	${errorMessage}
		</form:form>
	</fieldset>
</body>
</html>