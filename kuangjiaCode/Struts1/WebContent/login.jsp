<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="s" uri="/struts-tags"%>
   <!-- struts2标签库，自动排版，自动回显 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- theme="xhtml"默认    css_xhtml  simple -->
	<s:form action="login" method="post" theme="xhtml">
		<s:textfield name="username" label="用户名称"></s:textfield>
		<s:password name="password" label="用户密码"></s:password>
		<s:submit value="登录"></s:submit>
	</s:form>
</body>
</html>