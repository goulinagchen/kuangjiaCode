<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>跳转成功页面</title>
</head>
<body>
	<h1 align="center" style="color: orange;">跳转成功！</h1>
	<table>
		<tr>
			<td>request msg: </td>
			<td>${requestScope.msg}</td>
		</tr>
		<tr>
			<td>request username:</td>
			<td>${requestScope.username }</td>
		</tr>
		<tr>
			<td>session username:</td>
			<td>${sessionScope.username }</td>
		</tr>
		<tr>
			<td>request password: </td>
			<td>${requestScope.password }</td>
		</tr>
		<tr>
			<td>session password: </td>
			<td>${sessionScope.password }</td>
		</tr>
		<tr>
			<td>request age: </td>
			<td>${requestScope.age }</td>
		</tr>
		<tr>
			<td>session age: </td>
			<td>${sessionScope.age }</td>
		</tr>
	</table>
</body>
</html>