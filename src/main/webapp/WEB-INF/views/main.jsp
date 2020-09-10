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
		<legend>original login form</legend>
		<form action="main" method="post">
			<ul>
				<li><label>이름 : <input type="text" name="name"/></label></li>
				<li><label>이메일 : <input type="email" name="email"/></label></li>
				<li>
					<p>성별</p>
					<label>남자 : <input type="radio" name="gender" value="male" checked="checked"> </label>
					<label>여자 : <input type="radio" name="gender" value="female"></label>					
				</li>
				<li>
					<select name="position">
						<option value="student">학생</option>
						<option value="worker">직장인</option>						
						<option value="homemaker">주부</option>
					</select>
				</li>
				<li>
					<p>취미</p>
					<label>운동<input type="checkbox" name="hobby" value="exercise"/></label>
					<label> 요리<input type="checkbox" name="hobby" value="cooking"/></label>
					<label> 낚시<input type="checkbox" name="hobby" value="fishing"/></label>
				</li>
			</ul>	
			<input type="submit"/>
		</form>
	</fieldset>
	<!-- 위와 아래 비교해보기 -->
	
	<fieldset>
		<legend>spring custom tag form</legend>
		<form:form commandName="member">
			<ul>
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
						<form:option value="student">학생</form:option>
						<form:option value="worker">직장인</form:option>
						<form:option value="homemaker">주부</form:option>
					</form:select>
				</li>
				<li>
					<p>취미</p>
					<form:checkbox path="hobby" value="exercise" label="운동" />
					<form:checkbox path="hobby" value="cooking" label="요리"/>
					<form:checkbox path="hobby" value="fishing" label="낚시"/>					
				</li>
			</ul>
			<input type="submit"/>
		</form:form>
	</fieldset>
</body>
</html>