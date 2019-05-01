package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Student;

/**
 * <pre>
 * �����Ϳ��񽺿� �����ϱ� ���� �������̽�
 * </pre>
 * 
 * @version 1.0, 2019/05/01
 *
 */
public interface IStudentDao {
	
	//-----------------------------------------------------------
	// [MyBatis] ���� XML + �������̽� �������� �����ϴ� ���
	//-----------------------------------------------------------
	// �������̽��� �ֳ����̼��� �̿��Ͽ� MyBatis ���α����� �ۼ�
	
	@Insert("insert into students values(0, #{name}, #{age}, #{score})")
	public int insertStudent(Student student);
	
	@Update("update students set name = #{name}, age = #{age}, score = #{score} where s_id = #{s_id}")
	public int updateStudent(Student student);
	
	@Delete("delete from students where s_id = #{s_id}")
	public int deleteStudent(int s_id);
	
	@Select("select * from students where s_id = #{s_ID}")
	public Student selecctStudentInfo(int s_id);
	
	@Select("select * from students")
	public List<Student> selectStudentList();
}
