package service;

import java.util.List;

import model.Student;

public interface IStudentService {

	public boolean insertStudent(Student student);
	public boolean updateStudent(Student student);
	public boolean deleteStudent(int s_id);
	public Student selectStudentInfo(int s_id);
	public List<Student> selectStudentList();
	
}