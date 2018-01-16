<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="testRequestHeader"> Test RequestHeader</a>
	
	<br/>
	
	<a href="testCookieValue">Test CookieValue</a>
	
	<br/>
	
	<form action="testPOJO" method="post">
		username: <input type="text" name="username"/>
		<br/>
		password: <input type="password" name="password"/>
		<br/>
		email: <input type="text" name="email"/>
		<br/>
		age :<input type="text" name="age"/>
		<br/>
		province: <input type="text" name="address.province"/>
		<br/>
		city: <input type="text" name="address.city"/>
		<br/>
		<input type="submit" value="submit"/>
	</form>
	
	<br/>
	<a href="testServletAPI"> Test ServletAPI</a>
	
	<br/>
	<a href="testModelAndView"> Test ModelAndView</a>
	<br/>
	<a href="testMap"> Test Map</a>
	
	<br/>
	<!-- 
		模拟修改操作
			原始数据为:  1  Tom  123456  tom@sina.com  30
			要求: 修改的时候密码不能被修改
	 -->
	 <form action="testModelAttribute" method="post">
	 	<input type="hidden" value ="1" name="id"/>
	 	username: <input type="text" name="username" value="Tom"/>
	 	<br/>
	 	email: <input type="text" name="email" value="tom@sina.com"/>
	 	<br/>
	 	age :<input type="text" name="age" value="30"/>
	 	<br/>
	 	<input type="submit" value="submit"/>
	 </form>
</body>
</html>