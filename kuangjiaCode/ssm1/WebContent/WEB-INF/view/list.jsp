<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			//获取当前点击的a的href值
			var href = $(this).attr("href");
			//将获取到的href的值 赋值给form表单的action属性,并提交表单.
			$("form").attr("action",href).submit();
			return false ;  //禁止超链接的默认行为
		});
	});
</script>
</head>
<body>
	
	
	<form action="" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
	</form>
	
	<c:if test="${empty requestScope.employees }">
		<h3 align="center">没有任何员工信息!</h3>
	</c:if>
	
	<h1 align="center">员工信息列表</h1>
	<table align="center" border="1px" width="70%" cellspacing="0px">
		<tr align="center">
			<th>ID</th>
			<th>LastName</th>
			<th>Gender</th>
			<th>Email</th>
			<th>DepartmentName</th>
			<th>Operation</th>
		</tr>
		<c:forEach items="${requestScope.employees}" var="emp">
			<tr align="center">
				<td>${emp.id}</td>
				<td>${emp.lastName}</td>
				<td>${emp.gender==0?'女':'男'}</td>
				<td>${emp.email}</td>
				<td>${emp.department.departmentName}</td>
				<td>
					<a href="emp/${emp.id}">Edit</a>
					&nbsp;&nbsp;
					<a class="delete" href="emp/${emp.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table><br/>
	<h3 align="center"><a href="emp">添加员工</a></h3>
</body>
</html>