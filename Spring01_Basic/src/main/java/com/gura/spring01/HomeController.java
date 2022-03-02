package com.gura.spring01;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gura.spring01.dto.MemberDto;
/*
 *   용어를 익히세요
 *   
 *   응답에 필요한 데이터 => Model
 *   
 *   응답을 하는 jsp 페이지 => View page 
 *   
 *   요청을 제어(처리) 객체 => Controller
 */
@Controller
public class HomeController {
	
	 // /home.do 요청에 대해 처리할 메소드 .do 는 생략 가능하다
	@RequestMapping("/home.do") 
	public String home(HttpServletRequest request) {
		//DB 에서 읽어온 공지사항 이라고 가정하자
		List<String> noticeList=new ArrayList<>();
		noticeList.add("오늘 부터 봄이 시작이라고 합니다.");
		noticeList.add("우연히 우리도 Spring 을 배우기 시작 했네요^^");
		noticeList.add("어쩌구...");
		noticeList.add("저쩌구...");
		
		//공지 사항을 noticeList 라는 키값으로 request scope 에 담는다. 
		request.setAttribute("noticeList", noticeList);
		
		// /WEB-INF/views/home.jsp 페이지로 forward 이동해서 응답
		return "home";
	}
	
	@RequestMapping("/send")  // .do 는 생략 가능 
	public String send(HttpServletRequest request) {
		// msg 라는 파라미터 명으로 전달되는 문자열 추출(요청 파라미터 추출)
		String msg=request.getParameter("msg");
		// 콘솔창에 테스트로 출력하고
		System.out.println("클라이언트가 전송한 내용:"+msg);
		// view page 로 forward 이동해서 응답하기
		return "send";
	}
	
	/*
	 *  스프링 프레임워크가 msg 라는 파라미터로 전달된 값이 있는지 찾아서 
	 *  알아서 추출해서 메소드의 인자로 전달해 준다. 
	 */
	@RequestMapping("/send2")
	public String send2(String msg) {
		
		System.out.println("클라이언트가 전송한 내용:"+msg);
		
		return "send";
	}
	/*
	 *  스프링 프레임워크가 num 이라는 파라미터로 전달된 값이 있는지 찾아서 
	 *  알아서 추출해서 숫자로 바꿔서 전달해준다.
	 */
	@RequestMapping("/send3")
	public String send3(int num) {

		System.out.println("클라이언트가 전송한 내용:"+num);
		
		return "send";
	}	
	/*
	 *  요청 파라미터가 여러개인 경우에도 모두 추출할수 있다.
	 */
	@RequestMapping("/send4")
	public String send4(int num, String name, String addr) {

		System.out.println(num+"|"+name+"|"+addr);
		
		return "send";
	}	
	/*
	 *  여러개의 요청파라미터를 추출해서 xxxDto 에 담긴 상태로 전달 받을수도 있다.
	 *  단, 요청 파라미터의 이름과 xxxDto 의 필드명이 같아야 하고
	 *  xxxDto 는 표준에 맞게 만들어져 있어야 된다.
	 */
	@RequestMapping("/send5")
	public String send5(MemberDto dto) {
		
		System.out.println(dto.getNum()+"|"+dto.getName()+"|"+dto.getAddr());
		
		return "send";
	}		
}



















