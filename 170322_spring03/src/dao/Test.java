package dao;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import commons.Student;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		StudentDao dao = context.getBean("studentDao", StudentDao.class);
		
//		HashMap<String, Object> params = new HashMap<>();
//		params.put(Student.NAME , "이름");
//		params.put(Student.AGE  , 22   );
//		params.put(Student.SCORE, 100  );
//		System.out.println(dao.insertStudent(params)); // 결과 : true
		
		
//		System.out.println(dao.deleteStudent(3)); // 결과 : true
		
		
//		System.out.println(dao.selectOne(1));
		
		
//		for(HashMap<String, Object> student : dao.selectAll()) {
//			System.out.println(student);
//		}
		
	}
	
}
