<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/home.jsp</title>
</head>
<body>
<div class="container">
	<h1>인덱스 페이지 입니다.</h1>
	<h2>공지사항</h2>
	<ul>
		<c:forEach var="tmp" items="${requestScope.noticeList }">
			<li>${tmp }</li>
		</c:forEach>
		<li><a href="fortune/show.do">오늘의 운세보기</a></li>
		<li><a href="fortune/show2.do">오늘의 운세보기</a></li>
	</ul>
	
	<form action="send.do" method="post">
		<input type="text" name="msg" placeholder="서버에 할말 입력..."/>
		<button type="submit">전송</button>
	</form>
	<br />
	<form action="send2.do" method="post">
		<input type="text" name="msg" placeholder="서버에 할말 입력..."/>
		<button type="submit">전송</button>
	</form>
	<br />
	<form action="send3.do" method="post">
		<input type="text" name="num" placeholder="번호 입력..."/>
		<button type="submit">전송</button>
	</form>
	<br />
	<form action="send4.do" method="post">
		<input type="text" name="num" placeholder="번호 입력..."/>
		<input type="text" name="name" placeholder="이름 입력..."/>
		<input type="text" name="addr" placeholder="주소 입력..."/>
		<button type="submit">전송</button>
	</form>
	<br />
	<form action="send5.do" method="post">
		<input type="text" name="num" placeholder="번호 입력..."/>
		<input type="text" name="name" placeholder="이름 입력..."/>
		<input type="text" name="addr" placeholder="주소 입력..."/>
		<button type="submit">전송</button>
	</form>
</div>
</body>
</html>






