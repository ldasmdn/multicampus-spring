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
//	private SqlSession session; // SqlSession을 멤버변수로 유지하면서 컨테이너로 부터 주입
//	
//	@Override
//	public int insertStudent(Student student) {
//		//-------------------------------------
//		// CASE1. 매퍼를 받아서 사용 가능
//		//-------------------------------------
//		return session.getMapper(IStudentDao.class).insertStudent(student);
//		// session.getMapper()를 호출하면 인터페이스 타입으로
//		// 인터페이스 메소드명과 일치하는 구문 ID를 호출할 수 있는
//		// 가상객체가 만들어지는데, 인터페이스의 구현 객체이다.
//		// 그러므로 session.getMapper()롤 생성되는 객체를 컨테이너에 등록할 수 있다.
//		// 스프링에서는 MapperFactoryBean 클래스로 제공한다.
//		
//		//-------------------------------------
//		// CASE2. 구문을 직접 호출 가능
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
