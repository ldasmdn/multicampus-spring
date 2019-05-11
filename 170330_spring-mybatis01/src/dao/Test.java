package dao;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.Student;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		IStudentDao dao = context.getBean("studentDao", IStudentDao.class);
		
		Student insertVO = new Student();
		insertVO.setName ("NAME");
		insertVO.setAge  ( 20   );
		insertVO.setScore( 100  );
		System.out.println("result : " + dao.insertStudent(insertVO));
		
		for(Student student : dao.selectAll()) {
			System.out.println(student);
		}
	}
}
