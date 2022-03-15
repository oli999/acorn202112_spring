package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.util.WritingUtil;

public class MainClass {
	public static void main(String[] args) {
		// xml 문서를 로딩해서 Spring Bean Container 를 만들고
		ApplicationContext context=
				new ClassPathXmlApplicationContext("test/main/init.xml");
		// Container 로 부터 WritingUtil type 객체의 참조값을 얻어와서 
		WritingUtil util=context.getBean(WritingUtil.class);
		// 원하는 동작을 한다. 
		util.write1();
		util.write2();
		util.write3();
	}
}
