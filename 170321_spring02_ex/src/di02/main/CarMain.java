package di02.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import di02.tire.Tire;

public class CarMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("di02/conf/applicationContext.xml");
		System.out.println("컨테이너 빌드 완료");
		Car car = context.getBean("car", Car.class);
		Tire tire = context.getBean("tire", Tire.class);
		car.drive();

	}
	
}
