<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>This is doC JSP (src/main/webapp/WEB-INF/views/sample-c.jsp) 입니다!</h1>
	<div>Message is <b>${msg}</b> (id: ${id})</div>
	<hr>
	<h1>${ title }</h1>
	<div>
		상품: <b>${ product.name }</b> <br>
		가격: <b>${ product.price }</b> 원
	</div>
</body>
</html>