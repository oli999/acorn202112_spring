package com.gura.spring01.fortune.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FortuneController {
	
	@RequestMapping("/fortune/show.do")
	public String show(HttpServletRequest request) {
		//오늘의 운세를 얻어오는 비즈니스 로직을 수행 했다고 가정하자
		String fortuneToday="내일부터 4일동안 git 을 공부하게 될거에요!";
		//view page 에서 필요한 모델(데이터) 를 request scope 에 담는다.
		request.setAttribute("fortuneToday", fortuneToday);
		
		// /WEB-INF/views/fortune/show.jsp 페이지로 (view page) forward 이동해서 응답
		return "fortune/show";
	}
	
	@RequestMapping("/fortune/show2.do")
	public ModelAndView show2(ModelAndView mView) {
		//오늘의 운세를 얻어오는 비즈니스 로직을 수행 했다고 가정하자
		String fortuneToday="내일부터 4일동안 git 을 공부하게 될거에요!";
		
		mView.addObject("fortuneToday", fortuneToday);
		mView.setViewName("fortune/show");
		
		return mView;
	}
}





