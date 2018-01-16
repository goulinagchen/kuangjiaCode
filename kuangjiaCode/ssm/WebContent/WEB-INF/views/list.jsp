<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">员工信息列表</h1>
	<table align="center" border="1px" width="75%" cellspacing="0px">
		<tr>
			<th>ID</th>
			<th>LastName</th>
			<th>Gender</th>
			<th>Email</th>
			<th>DeptName</th>
			<th>Operation</th>
		</tr>
		<c:forEach  items="${requestScope.emps }" var="emp">
			<tr align="center">
				<td>${emp.id }</td>
				<td>${emp.lastName }</td>
				<td>${emp.gender==0?'女':'男' }</td>
				<td>${emp.email }</td>
				<td>${emp.dept.departmentName }</td>
				<td>
					<a href="#">Edit</a>
					  &nbsp;&nbsp;
					<a href="#">Delete</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>