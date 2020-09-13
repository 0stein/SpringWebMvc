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
						<option value="학생">학생</option>
						<option value="직장인">직장인</option>						
						<option value="주부">주부</option>
					</select>
				</li>
				<li>
					<p>취미</p>
					<label>운동<input type="checkbox" name="hobby" value="운동"/></label>
					<label> 요리<input type="checkbox" name="hobby" value="요리"/></label>
					<label> 낚시<input type="checkbox" name="hobby" value="낚시"/></label>
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
			<input type="submit"/>
		</form:form>
	</fieldset>
	
	
	<fieldset>
		<legend>file upload</legend>
		<form action="main/upload" method="POST" enctype="multipart/form-data">
			제목: <input type="text" name="title"><br/> 
			파일: <input type="file" name="f"><br/> 
    		<input type="submit" value="전송" /> 
		</form>
	</fieldset>
	
	<fieldset>
		<legend>find user with name</legend>
		<form action="main/select" method="POST">
			<label>이름 : <input type="text" name="name"/></label>
			<input type="submit"/>
		</form>
	</fieldset>
</body>
</html>