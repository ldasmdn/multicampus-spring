package dao;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		StudentDao dao = context.getBean("studentDao", StudentDao.class);
		
		System.out.println(dao.selectStudentInfo(1));
		
		for(HashMap<String, Object> student : dao.selectStudentList()) {
			System.out.println(student);
		}
		
	}
	
}