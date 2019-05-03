package spring01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println("?????");
		
		Greeting gr1 = context.getBean("gr", Greeting.class);
		gr1.greeting();
		
		Greeting gr2 = context.getBean("gr", Greeting.class);
		gr2.greeting();
		
		if(gr1 == gr2) {
			System.out.println("equals"); 
		}
		System.out.println(gr1);
		System.out.println(gr2);		
		
		
		// 컨테이너 소멸
		((GenericXmlApplicationContext) context).close();
	}
	
}
