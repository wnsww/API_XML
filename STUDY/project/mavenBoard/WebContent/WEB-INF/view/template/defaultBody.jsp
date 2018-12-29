<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body >
	<form action="main.ino" method="get">
		<select name='keyOption'>
			<option value="title">제목</option>
			<option value="name">이름</option>
			<option value="num">글번호</option>
		</select>
		<input type="text" name="keyword" />
		<input type="submit" value="검색"/>
	</form>
	
	<table border="1">
		<tr>
			<td class="align-right">
				<input type="button" value="글쓰기" onclick="location.href='insert.ino'">
			</td>
			
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일자</td>
		</tr>
		<c:forEach var="article" items="${list}">
			<tr>
				<td>${article.num}</td>
				<td><a href="detail.ino?num=${article.num}">${article.title}</a></td>
				<td>${article.name}</td>
				<td>${article.regdate}</td>
			</tr>
			</c:forEach>	
	</table >
	<a charset="UTF-8" href="">확인</a>
	${page.pagination  }
</body>
</html>