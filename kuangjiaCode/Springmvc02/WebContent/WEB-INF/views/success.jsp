<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Success Page.</h1>
	${requestScope.msg }
	
	username: ${requestScope.username}
	
	<br/>
	request  password: ${requestScope.password}
	<br/>
	session  password:${sessionScope.password }
	<br/>
	request age :${requestScope.age }
	<br/>
	session age: ${sessionScope.age }
</body>
</html>