<%@page import="org.springframework.http.HttpRequest"%>
<%@page import="com.bit.java.StockSvc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<meta name="viewport" 
		content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no"/>
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript">
	$.ajax({
		url: "getStkIsinByNmN1.js",
		headers : { "Content-Type" : "application/json; charset=UTF-8" },
		dataType : 'json',
		type: "GET",
		success: function(data) {
			alert("성공");
		},error: function (data) {
			alert("실패");
			console.log(data);
			}
		}); 
</script>
</head>
<body>
	<div data-role="page" id="home">
		<div data-role="header" data-add-back-btn="true">
			<h3>주식 추천</h3>
			<a  href="#menu" data-role="button">메뉴</a>
		</div>
		<div data-role="content">
			<ul id="list" data-role="listview" id="rank">								
			</ul>
		</div>
		<div data-role="footer" data-position="fixed">
		</div>
	</div>
	
	<div data-role="page" id="menu">
		<div data-role="header" data-add-back-btn="true">
			<h3>메뉴</h3>
			<!-- 
			<a  href="#home" data-role="button">홈</a>
			 -->
		</div>
		<div data-role="content" class="content">
			<ul data-role="listview">
				<li><a href="#getStkIsinByNmN1" data-role="button">종목 검색</a></li>
				<li><a href="#getShotnByMartN1" data-role="button">시장 조회</a></li>
				<li><a href="#getNewDepoSecnList" data-role="button">신규 예탁지정 종목</a></li>
				<li><a href="#getWrtInfoN1" data-role="button">신주인수증권 조회</a></li>
				<li><a href="#getDocInfoN1" data-role="button">신주인수증서 조회</a></li>
			</ul> 		
		</div>
		<div data-role="footer" data-position="fixed">
		</div>
	</div>
	<div data-role="page" id="getStkIsinByNmN1">
		<div data-role="header" data-add-back-btn="true">
			<h3>종목 검색</h3>
		</div>
		<div data-role="content">
			<div>
				<form action="http://localhost:8089/pro/start.jsp" data-ajax="false" method="post">
					<input type="hidden" name="name" value="getStkIsinByNmN1">
					<input type="search" name="secnNm">
				</form>
			</div>
			<div>
				<ul data-role="listview" id="IsinList"><li>리스트</li></ul>
			</div>
		</div>
		<div data-role="footer" data-position="fixed">
		</div>
	</div>
	<!-- 
	<div data-role="page" id="getShotnByMartN1">
		<div data-role="header" data-add-back-btn="true">
			<h3>시장조회</h3>
			<a  href="#home" data-role="button">홈</a>
		</div>
		<div data-role="content">
			<ul id="list" data-role="listview">
				<li>유가증권시장</li>
				<li>코스닥</li>
				<li>K-OTC</li>
				<li>코넥스</li>
				<li>기타시장</li>						
			</ul>
		</div>

	</div>
	<div data-role="page" id="menu">
	
		<div data-role="header" data-add-back-btn="true">
			<h3>메뉴</h3>
			<a  href="#home" data-role="button">홈</a>
		</div>
		<div data-role="content">
			<ul id="list" data-role="listview">
				<li>종목 검색</li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>						
			</ul>
		</div>

	</div>
	<div data-role="page" id="menu">
	
		<div data-role="header" data-add-back-btn="true">
			<h3>메뉴</h3>
			<a  href="#home" data-role="button">홈</a>
		</div>
		<div data-role="content">
			<ul id="list" data-role="listview">
				<li>종목 검색</li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>						
			</ul>
		</div>

	</div>
	  -->
</body>
</html>