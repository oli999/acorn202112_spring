package com.gura.spring02.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring02.member.dto.MemberDto;
import com.gura.spring02.member.service.MemberService;

/*
 *  [ 컨트롤러에서 하는 작업 ]
 *  
 *  1. 전송된 파라미터 추출 가능
 *  2. 특정 요청이 왔을때 서비스를 이용해서 비즈니스 로직을 처리하고 forward, 혹은 redirect 이동한다.
 *  3. HttpServletRequest, HttpServletResponse, HttpSession, ModelAndView 등의 
 *     객체가 필요하면 메소드의 인자로 전달 받는다.
 */

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	//회원 정보 수정 요청 처리
	@RequestMapping(value = "/member/update", method = RequestMethod.POST)
	public String update(MemberDto dto) {
		service.updateMember(dto);
		return "member/update";
	}
	
	//회원 수정 폼 요청 처리
	@RequestMapping("/member/updateform")
	public ModelAndView updateform(int num, ModelAndView mView) {
		
		service.getMember(num, mView);
		
		//view page 로 forward 이동해서 회원 수정폼 응답
		mView.setViewName("member/updateform");
		return mView;
	}
	
	//회원 삭제 요청 처리
	@RequestMapping("/member/delete")
	public String delete(int num)  {
		//GET 방식 파라미터로 전달되는 회원 번호를 이용해서 회원정보를 삭제하고 
		service.deleteMember(num);
		//리다일렉트 응답(클라이언트에게 해당 경로로 요청을 다시 하라고 강요)
		return "redirect:/member/list.do";
	}
	

	//회원 추가 요청 처리
	@RequestMapping(value = "/member/insert", method = RequestMethod.POST)
	public String insert(MemberDto dto) {
		service.addMember(dto);
		return "member/insert";
	}
	
	//회원 추가 폼 요청 처리 
	@RequestMapping("/member/insertform")
	public String insertform() {
		
		return "member/insertform";
	}
	
	@RequestMapping("/member/list")
	public ModelAndView list(ModelAndView mView) {
		service.getListMember(mView);
		//view page 의 정보를 ModelAndView 객체에 담는다.
		mView.setViewName("member/list");
		//ModelAndView 객체를 리턴해 준다.
		return mView;
	}
}






