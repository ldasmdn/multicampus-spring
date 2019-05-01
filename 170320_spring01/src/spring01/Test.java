package spring01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println("?????");
		
		Greeting gr1 = (Greeting) context.getBean("gr");
		gr1.greeting();
		
		Greeting gr2 = (Greeting) context.getBean("gr");
		gr2.greeting();
		
		System.out.println(gr1);
		System.out.println(gr2);
		
	}
	
}
