package com.gura.spring03;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	

}



















