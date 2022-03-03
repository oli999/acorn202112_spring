<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/updateform.jsp</title>
</head>
<body>
<div class="container">
   <h1>회원정보 수정 폼</h1>
   <form action="update.do" method="post">
      <!-- 수정할 회원의 primary key 는 input type="hidden" 을 이용해서 폼 전송한다. -->
      
      <input type="hidden" name="num" value="${param.num }"/>
      <div>
         <label for="num">번호</label>
         <!-- 번호는 primary key 니까 수정 못하도록 하고  -->
         <input type="text" name="num" id="num" value="${param.num }" disabled/>
      </div>
      <div>
         <label for="name">이름</label>
         <input type="text" name="name" id="name" value="${dto.name }"/>
      </div>
      <div>
         <label for="addr">주소</label>
         <input type="text" name="addr" id="addr" value="${dto.addr }"/>
      </div>
      
      <button type="submit">수정 확인</button>
      <button type="reset">취소</button>
   </form>
</div>

</body>
</html>