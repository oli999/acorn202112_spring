<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/animate_test.jsp</title>
<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
  />
<style>
	.container{
		width: 768px;
		margin: 0 auto;
	}
	#one{
		/* animation 진행시간 변경 */
		animation-duration: 2s;
	}
	#five{
		animation-iteration-count: 10;
	}
</style> 
</head>
<body>
<div class="container">
	<h1>페이지 로딩시에 한번 동작</h1>
	<img class="animate__animated animate__bounce" src="resources/images/kim1.png" />
	<h1>동작시간 변경(default 는 1초)</h1>
	<img id="one" class="animate__animated animate__bounce" src="resources/images/kim1.png" />
	<h1>원하는 시점에 한번 동작</h1>
	<img id="two" class="animate__animated" src="resources/images/kim1.png" />
	<script>
		document.querySelector("#two").addEventListener("click", function(){
			this.classList.add("animate__bounce");
		});
	</script>
	<h1>원하는 시점에 여러번 동작</h1>
	<img id="three" class="animate__animated" src="resources/images/kim1.png" />
	<script>
	document.querySelector("#three").addEventListener("click", function(){
		this.classList.add("animate__bounce");
	});
	//애니메이션이 끝나면 추가된 클래스를 제거를 해줘야 여러번 동작할수 있다.
	document.querySelector("#three").addEventListener("animationend", function(){
		this.classList.remove("animate__bounce");
	});
	</script>
	<h1>원하는 시점에 여러번 동작하되 다른 UI 를 동작시키기</h1>
	<button id="myBtn">눌러보셈</button>
	<img id="four" class="animate__animated" src="resources/images/kim1.png" />
	<script>
		document.querySelector("#myBtn").addEventListener("click", function(){
			document.querySelector("#four").classList.add("animate__bounce");
		});
		//애니메이션이 끝나면 추가된 클래스를 제거를 해줘야 여러번 동작할수 있다.
		document.querySelector("#four").addEventListener("animationend", function(){
			this.classList.remove("animate__bounce");
		});
	</script>
	<h1>원하는 횟수 만큼 반복하기</h1>
	<!-- repeat-1 , repeat-2, repeat-3, infinite -->
	<img class="animate__animated animate__bounce animate__repeat-3" src="resources/images/kim1.png" />
	<h1>원하는 휫수 직접 지정해서 반복하기</h1>
	<img id="five" class="animate__animated animate__bounce" src="resources/images/kim1.png" />
	<h1>예제</h1>
	<form class="animate__animated" action="insert.jsp" id="myForm">
		<input type="text" />
		<button id="submitBtn" type="submit">가입</button>
	</form>
	<script>
		document.querySelector("#submitBtn").addEventListener("click", function(e){
			//폼 전송이 되지 않도록 기본 동작을 막아준다.
			e.preventDefault();
			document.querySelector("#myForm").classList.add("animate__bounce");
			document.querySelector("#myForm").addEventListener("animationend", function(){
				//폼 강제 제출
				this.submit();
			});
		});
	</script>
</div>
</body>
</html>




