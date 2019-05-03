package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IStudentDao;
import model.Student;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private IStudentDao dao;
	
	@Override
	public boolean insertStudent(Student student) {
		// TODO Auto-generated method stub
		int result = dao.insertStudent(student);
		
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		int result = dao.updateStudent(student);		
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteStudent(int s_id) {
		// TODO Auto-generated method stub
		int result = dao.deleteStudent(s_id);
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public Student selectStudentInfo(int s_id) {
		// TODO Auto-generated method stub
		return dao.selectStudentInfo(s_id);
	}

	@Override
	public List<Student> selectStudentList() {
		// TODO Auto-generated method stub
		return dao.selectStudentList();
	}

}