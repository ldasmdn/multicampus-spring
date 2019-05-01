package dao;

import model.Student;

public class Test {

	public static void main(String[] args) {
		
		StudentDao dao = new StudentDao();
		
		for(Student student : dao.selectAll()) {
			System.out.println(student);
		}
		
	}
	
}
