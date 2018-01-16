<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<!-- 
		页面使用SpringMVC的表单标签进行开发:
			1.可以快速的开发表单页面
			2.更加方便的回显数据.
		如何使用:
			1.导入标签库
		问题:
			SpringMVC的表单标签要求必须要回显数据.默认情况下,会使用"command"这个key到
			request域对象中找对应的数据.
			建议: 使用modelAttribute属性来指定使用哪个key到request中找回显的数据.
			          使用自定义的key替换掉"command"
	 -->
	 <c:set var="basePath" value="${pageContext.request.contextPath }" scope="request"></c:set>
	
	 <form:form action="${basePath}/emp" method="post"  modelAttribute="employee">	
	 
	 	
	 	<!--  path: path属性对应的就是HTML表单标签的name属性 -->
	 	
	 	<!-- 判断当前是添加还是修改 -->
	 	<c:if test="${employee.id == null }">
	 		<!-- 添加 -->
	 		LastName:<form:input path="lastName"/>
	 	</c:if>
	 	<c:if test="${employee.id !=null }">
	 		<!-- 修改 -->
	 		<form:hidden path="id"/>  <!-- 隐藏id值. -->
	 		<input type="hidden" name="_method" value="PUT"/>
	 	</c:if>
	 	
	 	<br/>
	 	Email: <form:input path="email"/>
	 	<br/>
	 	<%
	 		Map<String,String> genders = new HashMap<String,String>();
	 		genders.put("1", "Male");
	 		genders.put("0","Female");
	 		request.setAttribute("genders", genders);
	 	
	 	%>
	 	Gender:<form:radiobuttons path="gender"  items="${genders }"/>
	 		<!--  Male:<input type="radio" name="gender" value="1"/> --> 
	 	<br/>
	 	Dept:<form:select path="department.id" items="${requestScope.deparments }"
	 					 itemValue="id" itemLabel="departmentName">
	 	     </form:select>
	 	<br/>
	 	
	 	 <input type="submit" value="ADD"/>  
	 	    
	 </form:form>
	
</body>
</html>