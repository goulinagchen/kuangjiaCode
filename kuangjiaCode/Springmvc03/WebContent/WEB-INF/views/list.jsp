<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<!-- 引入JQuery -->
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
	<!-- 
		Spingmvc处理静态资源:
		1.若将DispatcherServlet的请求映射配置为/,则Springmvc会捕获web容器的所有请求，
		    包括静态资源的请求.
		    
		2.解决:
			a.让Springmvc处理带有后缀的请求 .例如: *.do  *.action等.  不建议使用这种方式.
			  优秀的REST风格的URL不希望带有任何后缀.
		    b.在Springmvc的配置文件中配置<mvc:default-servlet-handler/>
	
	 -->
	<!-- 用于删除功能的表单 -->
	<form action="" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
	</form>

	<c:if test="${empty requestScope.employees }">
		没有任何员工信息
	</c:if>
	<c:if test="${!empty requestScope.employees }">
		<h1 align="center">员工信息列表</h1>
		<table border="1px" width="65%" align="center" cellspacing="0px">
			<tr>
				<th>ID</th>
				<th>LastName</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Department</th>
				<th>Operation</th>
			</tr>			
			<c:forEach items="${requestScope.employees }" var="emp">
				<tr align="center">
					<td>${emp.id }</td>
					<td>${emp.lastName }</td>
					<td>${emp.email }</td>
					<td>${emp.gender }</td>
					<td>${emp.department.departmentName }</td>
					<td>
						<a href="emp/${emp.id}">Edit</a>
						 &nbsp;&nbsp;
						<a class="delete" href="emp/${emp.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br/>
	<!-- 
		去往添加页面，需要将部门信息查询出来，在添加页面中展示.
	 -->
	<a href="emp">Add New Employee</a>
</body>
</html>