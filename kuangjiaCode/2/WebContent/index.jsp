<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="testRequestHeader">testRequestHeader</a>
	<a href="testCookieValue">testCookieValue</a>
	<form action="testPOJO" method="post">
		id:<input type="text" name="id"/><br/>
		username:<input type="text" name="username"/><br/>
		password:<input type="password" name="password"/><br/>
		email:<input type="text" name="email"/><br/>
		age:<input type="text" name="age"/><br/>
		province:<input type="text" name="address.province"/><br/>
		city:<input type="text" name="address.city"/><br/>
		<input type="submit" value="提交"/>
	</form><br/>
	
	<a href="testServletAPI">testServletAPI</a><br/>
	
	<a href="testModelAndView">testModelAndView</a><br/>
	
	<a href="testMap">testMap</a><br/>
	模拟修改操作<br/>
	Tom 123456 tom@sina.com<br/>
	<form action="testModelAttribute" method="post">
		<input type="hidden" value="1" name="id"/>
		<input type="text" value="Tom" name="username"/><br/>
		<input type="text" value="tom@sina.com" name="email"/><br/>
		<input type="text" value="30" name="age"/><br/>
		<input type="submit" value="提交"/>
	</form>
	
	
</body>
</html>