package com.gura.spring02;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	
	/*
	 *  [ 파일 업로드 처리 하는 방법 ]
	 *  
	 *  1. pom.xml 에  commons-io, commons-fileupload dependency 설정
	 *  2. servlet-context.xml 에  CommonsMultipartResolver  bean 설정 (최대 업로드 사이즈 셋팅)
	 *  3. <input type="file" name="myFile" />  에서   name 속성의 value 를
	 *     MultipartFile  type 을 받을때 지역 변수명 혹은 필드명과 일치 시킨다.
	 *     ex)  MultipartFile  myFile 
	 */
	
	@RequestMapping("/upload")
	public ModelAndView upload(ModelAndView mView, 
			MultipartFile myFile, HttpServletRequest request) {
		
		//원본 파일명
		String orgFileName=myFile.getOriginalFilename();
		//upload 폴더에 저장할 파일명을 직접구성한다.
		// 1234123424343xxx.jpg
		String saveFileName=System.currentTimeMillis()+orgFileName;
		//파일의 크기
		long fileSize=myFile.getSize();
		// webapp/upload 폴더까지의 실제 경로 얻어내기 
		String realPath=request.getServletContext().getRealPath("/upload");
		// upload 폴더가 존재하지 않을경우 만들기 위한 File 객체 생성
		File upload=new File(realPath);
		if(!upload.exists()) {//만일 존재 하지 않으면
			upload.mkdir(); //만들어준다.
		}
		try {
			//파일을 저장할 전체 경로를 구성한다.  
			String savePath=realPath+File.separator+saveFileName;
			//임시폴더에 업로드된 파일을 원하는 파일을 저장할 경로에 전송한다.
			myFile.transferTo(new File(savePath));
			//테스트로 저장된 경로를 콘솔에 출력하기
			System.out.println("savePath:"+savePath);
		}catch(Exception e) {
			e.printStackTrace();
		}	
		
		mView.addObject("orgFileName", orgFileName);
		mView.addObject("saveFileName", saveFileName);
		mView.addObject("fileSize", fileSize);
		
		mView.setViewName("upload");
		return mView;
	}
	@RequestMapping("/upload2")
	public ModelAndView upload2(ModelAndView mView,
		FileDto dto, HttpServletRequest request) {
		//입력한 제목 읽어오기 
		String title=dto.getTitle();
		//업로드된 파일의 정보
		MultipartFile myFile=dto.getMyFile();
		
		//원본 파일명
		String orgFileName=myFile.getOriginalFilename();
		//upload 폴더에 저장할 파일명을 직접구성한다.
		// 1234123424343xxx.jpg
		String saveFileName=System.currentTimeMillis()+orgFileName;
		//파일의 크기
		long fileSize=myFile.getSize();
		// webapp/upload 폴더까지의 실제 경로 얻어내기 
		String realPath=request.getServletContext().getRealPath("/upload");
		// upload 폴더가 존재하지 않을경우 만들기 위한 File 객체 생성
		File upload=new File(realPath);
		if(!upload.exists()) {//만일 존재 하지 않으면
			upload.mkdir(); //만들어준다.
		}
		try {
			//파일을 저장할 전체 경로를 구성한다.  
			String savePath=realPath+File.separator+saveFileName;
			//임시폴더에 업로드된 파일을 원하는 파일을 저장할 경로에 전송한다.
			myFile.transferTo(new File(savePath));
			//테스트로 저장된 경로를 콘솔에 출력하기
			System.out.println("savePath:"+savePath);
		}catch(Exception e) {
			e.printStackTrace();
		}	
		
		mView.addObject("title", title);
		mView.addObject("orgFileName", orgFileName);
		mView.addObject("saveFileName", saveFileName);
		mView.addObject("fileSize", fileSize);
		
		mView.setViewName("upload2");
		return mView;
	}
}



















