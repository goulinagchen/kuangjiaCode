<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<form action="testRequestHeader" method="post">
		<input type="submit" value="RequestHeader" />
	</form>
	<br />
	<form action="testCookieValue" method="post">
		<input type="submit" value="CookieValue" />
	</form>
	<br />
	<form action="testPOJO" method="post">
		<table>
			<tr>
				<td>username:</td>
				<td><input type="text" value="Tom" name="username" /></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="password" value="123654" name="password" /></td>
			</tr>
			<tr>
				<td>email:</td>
				<td><input type="text" value="tom@126.com" name="email" /></td>
			</tr>
			<tr>
				<td>age:</td>
				<td><input type="text" value=18 name="age" /></td>
			</tr>
			<tr>
				<td>province:</td>
				<td><input type="text" value="北京" name="address.province" /></td>
			</tr>
			<tr>
				<td>city:</td>
				<td><input type="text" value="北京市" name="address.city" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="POJO" /></td>
			</tr>
		</table>
	</form>
	<br />
	<form action="testServletAPI">
		<input type="submit" value="Servlet" />
	</form>
	<br />
	<form action="testModelAndView">
		<input type="submit" value="ModelAndView" />
	</form>
	<br />
	<br />
	<form action="testMap">
		<input type="submit" value="Map" />
	</form>
	<br />
	<form action="testModelAttribute" method="post">
		<input type="hidden" value="1" name="id" />
		<table>
			<tr>
				<td>username:</td>
				<td><input type="text" name="username" value="Tom" /></td>
			</tr>
			<tr>
				<td>email:</td>
				<td><input type="text" name="email" value="tom@sina.com" /></td>
			</tr>
			<tr>
				<td>age:</td>
				<td><input type="text" name="age" value="20" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="ModelAttribute" /></td>
			</tr>
		</table>
	</form>
	<br />
</body>
</html>