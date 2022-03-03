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
	
	//회원 수정 폼 요청 처리
	@RequestMapping("/member/updateform")
	public ModelAndView updateform(int num, ModelAndView mView) {
		//수정할 회원의 번호를 읽어와서 
		
		//DB 에서 해당회원의 정보를 얻어와서
		MemberDto dto=dao.getData(num);
		//request scope 에 담고
		mView.addObject("dto", dto);
		//view page 로 forward 이동해서 회원 수정폼 응답
		mView.setViewName("member/updateform");
		
		return mView;
	}
	
	//회원 삭제 요청 처리
	@RequestMapping("/member/delete")
	public String delete(int num) {
		//GET 방식 파라미터로 전달되는 회원 번호를 이용해서 회원정보를 삭제하고 
		dao.delete(num);
		//리다일렉트 응답(클라이언트에게 해당 경로로 요청을 다시 하라고 강요)
		return "redirect:/member/list.do";
	}
	
	//회원 추가 요청 처리
	@RequestMapping("/member/insert")
	public String insert(HttpServletRequest request) {
		//1. 폼전송되는 이름과, 주소를 추출해서
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		//2. MemberDto 에 담아서
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		//3. DB 에 저장하고
		dao.insert(dto);
		//4. 응답하기 
		return "member/insert";
	}
	
	//회원 추가 요청 처리
	@RequestMapping("/member/insert2")
	public String insert2(String name, String addr) {
		//2. MemberDto 에 담아서
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		//3. DB 에 저장하고
		dao.insert(dto);
		//4. 응답하기 
		return "member/insert";
	}

	//회원 추가 요청 처리
	@RequestMapping("/member/insert3")
	public String insert3(MemberDto dto) {
		//3. DB 에 저장하고
		dao.insert(dto);
		//4. 응답하기 
		return "member/insert";
	}
	
	//회원 추가 폼 요청 처리 
	@RequestMapping("/member/insertform")
	public String insertform() {
		
		return "member/insertform";
	}
	
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






