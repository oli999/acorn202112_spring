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
	<ul>
		<li><a href="member/list.do">회원 목록 보기</a></li>
		<li><a href="todo/list.do">할일 목록 보기</a></li>
		<li><a href="send.do">json 테스트</a></li>
		<li><a href="send2.do">json 테스트2</a></li>
		<li><a href="send3.do">json 테스트3</a></li>
		<li><a href="send4.do">json 테스트4</a></li>
	</ul>
	
	<form action="upload.do" method="post" enctype="multipart/form-data">
		<input type="file" name="myFile"/>
		<button type="submit">업로드</button>	
	</form>
	
	<br />
	
	<form action="upload2.do" method="post" enctype="multipart/form-data">
		<input type="text" name="title" placeholder="제목 입력..."/>
		<input type="file" name="myFile"/>
		<button type="submit">업로드</button>	
	</form>
	
	<h2>공지사항</h2>
	<ul>
		<c:forEach var="tmp" items="${requestScope.noticeList }">
			<li>${tmp }</li>
		</c:forEach>
	</ul>
</div>
</body>
</html>






