package dao;

import java.util.List;

import model.Student;

public interface IStudentDao {

	public int insertStudent(Student student);
	public int updateStudent(Student student);
	public int deleteStudent(int s_id);
	public Student selectStudentInfo(int s_id);
	public List<Student> selectStudentList();
	
}
