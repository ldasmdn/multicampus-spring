package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.Student;
import service.IStudentService;

public class StudentDaoTest {
		
	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		IStudentService service = context.getBean("studentService", IStudentService.class);
		
		System.out.println(service.selectStudentInfo(2));
		
		for(Student student : service.selectStudentList()) {
			System.out.println(student);			
		}
		
	}
	
}
