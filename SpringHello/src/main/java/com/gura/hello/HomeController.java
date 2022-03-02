package com.gura.hello;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//클라이언트의 어떤 경로 요청에 대해서 어떻게 응답할지 결정을하는 컨트롤러 클래스 
@Controller
public class HomeController {
	/*
	 *  HttpServletRequest, HttpServletResponse, HttpSession 등의 객체가 
	 *  메소드안에서 필요하면 메소드의 매개 변수로 선언만 해도 참조값이 알아서 전달이 된다.
	 */
	@RequestMapping("/fortune")
	public String fortune(HttpServletRequest request) {
		
		//만일 HttpServletRequest 객체의 참조값이 필요 하다면...
		request.setAttribute("fortuneToday", "동쪽으로 가면 귀인을 만나요!");
		
		// "/WEB-INF/views/" + "test/fortune" + ".jsp" 로 forward 이동 해서 응답
		return "test/fortune";
	}
	
	@RequestMapping("/study")
	public String study() { //메소드명은 마음대로 만들수 있다, 리턴 type 은 일단 String type 으로
		
		return "study";
	}
	
	// "/" 경로 요청(최상위 경로) 이 오면  이 메소드를 이용해서 응답하기
	@RequestMapping("/")
	public String home() {
		
		/*
		 *  여기서 리턴해주는 문자열은 아래와 같이 문자열이 연결되어서  
		 *  
		 *  "/WEB-INF/views/" + "home" + ".jsp" 
		 *  
		 *  결국  /WEB-INF/views/home.jsp 페이지로 forward 이동해서 응답을 하겠다는 의미가 된다. 
		 */
		return "home";
	}
	
}





