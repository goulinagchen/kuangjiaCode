<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="springmvc/testRequestMapping">Test RequestMapping</a>
	<br/>
	<a href="springmvc/testRequestMethod"> Test RequestMethod</a>
	<br/>
	<form action="springmvc/testRequestMethod" method="post">
	
		<input type="submit" value="submit"/>
	</form>
	
	<br/>
	<a href="springmvc/testParams?username=Atguigu&age=10"> Test Params</a>
	<br/>
	<a href="springmvc/testAnt/aaa/abc">Test Ant</a>
	
	<br/>
	<a href="springmvc/testPathVariable/1001/30">Test PathVariable</a>
	
	
	<br/>
	<!-- 查询id为1001的User    GET-->
	<a href="springmvc/user/1001">Test REST GET</a>
	<br/>
	<!-- 添加一个新的User  POST -->
	<form action="springmvc/user" method="post">
		<input type="submit" value="POST"/>
	</form>
	
	<br/>
	<!-- 删除一个id为1001的User   DELETE
		
		_method=DELETE
	-->
	<form action="springmvc/user/1001" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
		<input type="submit" value="DELETE"/>
	</form>
	
	<br/>
	<!-- 修改一个id为1001的User  PUT 
		更新: 
			1. 查询id为1001的User   user/1001 GET
			2. 更新id为1001的User   user
	
	-->
	<form action="springmvc/user" method="post">
		<input type="hidden" name="_method" value="PUT"/>
		<!-- <intput type="hidden" name="id" value="1001"/>
		<input type="text" name="username" />
		<input type="password" name="password"/> -->
		<input type="submit" value="PUT"/>
	</form>
	
	<br/>
	<a href="springmvc/testRequestParam?username=Atguigu&age=10">Test RequestParam</a>
</body>
</html>