<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="http://192.168.1.10:8080/videoweb/video/manage.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="method" value="save"><br/>
		视频名称：<input type="text" name="name" value=""><br/>
		时长：<input type="text" name="timelength" value=""><br/>
		视频文件：<input type="file" name="video"><br/>
		<input type="submit" value="提交"> 
	</form>
</body>
</html>