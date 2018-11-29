<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>场景管理</title>
</head>
<body>
	<br>
	<br>(1代表当前可用)<br>
	<br>

	<table>
		<tr>
			<th>ID</th><th>名称</th><th>作者</th><th>&nbsp;</th>
		</tr>
		<c:forEach items="${requestScope.books}" var="book">
			<tr>
				<td>${book.id}</td>
				<td>${book.name}</td>
				<td>${book.writer}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
</body>
</html>