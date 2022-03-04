package com.gura.spring02;

import org.springframework.web.multipart.MultipartFile;

public class FileDto {
	private String title;
	private MultipartFile myFile; //업로드된 파일의 정보를 담을 필드 
	
	//생성자
	public FileDto() {}

	public FileDto(String title, MultipartFile myFile) {
		super();
		this.title = title;
		this.myFile = myFile;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MultipartFile getMyFile() {
		return myFile;
	}

	public void setMyFile(MultipartFile myFile) {
		this.myFile = myFile;
	}
	
	
	
}
