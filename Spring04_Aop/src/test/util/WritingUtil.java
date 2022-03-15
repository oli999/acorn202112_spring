package test.util;

import org.springframework.stereotype.Component;

@Component // component scan 을 통해서 bean 이 될수 있도록 어노테이션을 붙인다.
public class WritingUtil {

	public void write1() {
		System.out.println("파란색 Pen 을 준비해요");
		System.out.println("편지를 써요");	
		System.out.println("Pen 을 마무리 해요");
	}
	public void write2() {
		System.out.println("파란색 Pen 을 준비해요");
		System.out.println("보고서를 써요");
		System.out.println("Pen 을 마무리 해요");
	}
	public void write3() {
		System.out.println("파란색 Pen 을 준비해요");
		System.out.println("일기를 써요");
		System.out.println("Pen 을 마무리 해요");
	}
}
