<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登录成功.</h1>
	<!-- 查看值栈 -->
	<s:debug></s:debug>
	
	<!-- 取值栈的元素 -->
	root: <s:property value="[0].username"/>

	<br/>
	context:<s:property value="#request.requestMap"/>	
	
	<br/>
	Request :${request }
	<br/>
	Session: ${sessions }
	<br/>
	Application:${servletContext }
	
	<br/>
	requestMap: ${requestMap }
	<br/>
	sessionMap: ${sessionMap }
	<br/>
	application: ${servletContextMap }

</body>
</html>