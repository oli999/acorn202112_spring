package com.gura.spring02.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring02.member.dao.MemberDao;
import com.gura.spring02.member.dto.MemberDto;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDao dao;
	
	@RequestMapping("/member/list.do")
	public String list(HttpServletRequest request) {
		//1. dao 를 이용해서 DB 에서 회원 목록을 얻어온다.
		List<MemberDto> list=dao.getList();
		//2. 회원목록을 request scope 에 담는다.
		request.setAttribute("list", list);
		//3. view page 로 forward 이동해서 회원목록을 응답한다. 
		
		return "member/list"; // /WEB-INF/views/member/list.jsp 
	}
	
	@RequestMapping("/member/list2")
	public ModelAndView list2(ModelAndView mView) {
		//1. dao 를 이용해서 DB 에서 회원 목록을 얻어온다.
		List<MemberDto> list=dao.getList();
		//2. 회원 목록을 ModelAndView 객체에 담는다.
		mView.addObject("list", list);
		//3. view page 의 정보를 ModelAndView 객체에 담는다.
		mView.setViewName("member/list");
		//4. ModelAndView 객체를 리턴해 준다.
		return mView;
	}
}






