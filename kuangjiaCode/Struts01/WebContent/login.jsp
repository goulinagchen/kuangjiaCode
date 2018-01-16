<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 登录表单 
		 使用struts2的标签库:
		 	1.可以自动排版,会填充一些自带的样式
		 	2.自动回显数据
		 theme:主题
		 	 xhtml  默认值
		 	 css_xhtml
		 	 simple
	-->
	<s:form action="user/login.do" method="post" theme="simple">
		用户名称:<s:textfield name="username" label="用户名称"></s:textfield>
		<span>${loginMsg }</span>
		<br/>
		
		用户密码:<s:password name="password" label="用户密码"></s:password>
		<br/>
		<s:submit value="登录"></s:submit>
	</s:form>
</body>
</html>