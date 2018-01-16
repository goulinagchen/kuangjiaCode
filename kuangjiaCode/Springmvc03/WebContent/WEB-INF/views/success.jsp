<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 导入JSTL标签库 -->
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Success Page.</h1>
	
	<br/>
	<!-- 根据当前浏览器端设置的语言显示不同的内容. -->
	<fmt:message key="i18n.username"></fmt:message>
	
	<br/>
	<fmt:message key="i18n.password"></fmt:message>

</body>
</html>