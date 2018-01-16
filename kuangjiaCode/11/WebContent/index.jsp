<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="springmvc/testRequestMapping" method="get">
		<input type="submit" value="测试 RequestMapping"/>
	</form>
	
	<form action="springmvc/testRequestMethod" method="get">
		<input type="submit" value="测试 RequestMethod get">
	</form>
	
	<form action="springmvc/testRequestMethod" method="post">
		<input type="submit" value="测试 RequestMethod post"/>
	</form>
	
	<form action="springmvc/testParams?username=Atguigu&age=11" method="post">
		<input type="submit" value="测试 Params username=Atguigu&age=11"/>
	</form>
	
	<form action="springmvc/testAnt/aaa/abc">
		<input type="submit" value="测试 Ant aaa/abc">
	</form>
	
	<form action="springmvc/testPathVarible/1001/30" method="post">
		<input type="submit" value="测试  PathVariable /1001/30"/>
	</form>
	
	<form action="springmvc/user/1001" method="get">
		<input type="submit" value="测试  查询id为1001的user  User GET user/1001"/>
	</form>
	
	<form action="springmvc/user" method="post">
		<input type="submit" value="测试  添加一个新的User  User POST"/>
	</form>
	
	<form action="springmvc/user/1001" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
		<input type="submit" value="测试  删除id为1001的user  _method=DELETE User DELETE"/>
	</form>
	
	<form action="springmvc/user" method="post">
		<input type="hidden" name="_method" value="PUT"/>
		<input type="submit" value="测试 修改id为1001的user user/1001 GET"/>
	</form>
	
	<form action="springmvc/testRequestParam?username=Atguigu&age=20" method="post">
		<input type="submit" value="测试param username=Atguigu&age=20"/>
	</form>
	
	
</body>
</html>