//package dao;
//
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import model.Student;
//
//public class StudentDao implements IStudentDao {
//
//	@Autowired
//	private SqlSession session; // SqlSession�� ��������� �����ϸ鼭 �����̳ʷ� ���� ����
//	
//	@Override
//	public int insertStudent(Student student) {
//		//-------------------------------------
//		// CASE1. ���۸� �޾Ƽ� ��� ����
//		//-------------------------------------
//		return session.getMapper(IStudentDao.class).insertStudent(student);
//		// session.getMapper()�� ȣ���ϸ� �������̽� Ÿ������
//		// �������̽� �޼ҵ��� ��ġ�ϴ� ���� ID�� ȣ���� �� �ִ�
//		// ����ü�� ��������µ�, �������̽��� ���� ��ü�̴�.
//		// �׷��Ƿ� session.getMapper()�� �����Ǵ� ��ü�� �����̳ʿ� ����� �� �ִ�.
//		// ������������ MapperFactoryBean Ŭ������ �����Ѵ�.
//		
//		//-------------------------------------
//		// CASE2. ������ ���� ȣ�� ����
//		// return session.insert("student.insert", student);
//		//-------------------------------------
//	}
//
//	@Override
//	public int updateStudent(Student student) {
//		return session.getMapper(IStudentDao.class).updateStudent(student);
//	}
//
//	@Override
//	public int deleteStudent(int s_id) {
//		return session.getMapper(IStudentDao.class).deleteStudent(s_id);
//	}
//
//	@Override
//	public Student selectStudentInfo(int s_id) {
//		return session.getMapper(IStudentDao.class).selectStudentInfo(s_id);
//	}
//
//	@Override
//	public List<Student> selectStudentList() {
//		return session.getMapper(IStudentDao.class).selectStudentList();
//	}
//
//}
