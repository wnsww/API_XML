<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이노시스</title>
</head>
<body>

<table width="800"border="0">
	<!-- header -->
	<tr height="100">
		<td  align="left"><tiles:insertAttribute name="header" /></td>
	</tr>
	<!-- body -->
	<tr height="650" valign="top" align="left" >
		<td><tiles:insertAttribute name="body" /></td>
	</tr>
	<!-- footer -->
	<tr height="50">
		<td lign="left"><tiles:insertAttribute name="footer" /></td>
	</tr>
</table>
</body>
</html>