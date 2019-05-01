package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Student;

/**
 * <pre>
 * 데이터에비스에 접근하기 위한 인터페이스
 * </pre>
 * 
 * @version 1.0, 2019/05/01
 *
 */
public interface IStudentDao {
	
	public int insertStudent(Student student);
	public int updateStudent(Student student);
	public int deleteStudent(int s_id);
	public Student selecctStudentInfo(int s_id);
	public List<Student> selectStudentList();
}
