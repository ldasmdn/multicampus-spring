package dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Student;

/**
 * <pre>
 * �����ͺ��̽� ������ ���� DAO Ŭ����
 * </pre>
 * 
 * @version 1.0, 2019/04/30
 *
 */
public class StudentDao {

	private SqlSessionFactory sqlSessionFactory;
	
	public StudentDao() {
		
		try {
			
			Reader reader = Resources.getResourceAsReader("configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * (INSERT) �л� ������ �߰��ϴ� ���
	 * 
	 * @param student
	 * @return
	 */
	public boolean insertStudent(Student student) {
		
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			
			// [1] ���ӽ����̽���.�������̵�, [2] �Ű�����
			int result = session.insert("student.insert", student);
			
			if(result > 0) {
				session.commit();
				return true;
			} else {
				session.rollback();
				return false;
			}
			
		} catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
			
		} finally {
			
			if(session != null) { session.close(); }
			
		}
		
		return false;

	}
	
	public Student selectOne(int s_id) {
		
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			
			return session.selectOne("student.selectOne", s_id);
			
		} catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
		
		} finally {
			
			if(session != null) { session.close(); }
			
		}
		
		return null;
		
	}
	
	public List<Student> selectAll() {
		
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			
			return session.selectList("student.selectAll");
			
		} catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
		
		} finally {
			
			if(session != null) { session.close(); }
			
		}
		
		return null;
		
	}
	
}
