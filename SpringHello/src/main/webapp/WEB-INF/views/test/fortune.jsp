<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test/fortune.jsp</title>
</head>
<body>
	<h1>오늘의 운세 페이지</h1>
	<p>오늘의 운세 : <strong>${requestScope.fortuneToday }</strong></p>
</body>
</html>