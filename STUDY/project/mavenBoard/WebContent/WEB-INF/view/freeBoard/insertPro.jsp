<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insertPro.ino" method="post">
	<fieldset >
		<label for="name">이름 </label></br>
		<input type="text" name="name"></br>
		<label for="title">제목</label></br>
		<input type="text" name="title"></br>
		<label for="content">내용</label></br>
		<textarea rows="30" cols="50" name="content"></textarea></br></br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</fieldset>
</form>
</body>
</html>