package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Student;

@Component
public class StudentDao implements IStudentDao {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public int insertStudent(Student student) {
		SqlSession session = sqlSessionFactory.openSession(false); // autoCommit : false
		int result = 0;
		
		try {
			result = session.insert("student.insert", student);
			session.commit();
		} catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public int updateStudent(Student student) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			return session.update("student.update", student);
		} catch(Exception e) {
			
		} finally {
			session.close();
		}
		
		return 0;
	}

	@Override
	public int deleteStudent(int s_id) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			return session.delete("student.delete", s_id);
		} catch(Exception e) {
			
		} finally {
			session.close();
		}
		
		return 0;
	}

	@Override
	public Student selecctStudentInfo(int s_id) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			return session.selectOne("student.selectOne", s_id);
		} catch(Exception e) {
			
		} finally {
			session.close();
		}
		
		return null;
	}

	@Override
	public List<Student> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			return session.selectList("student.selectAll");
		} catch(Exception e) {
			
		} finally {
			session.close();
		}
		
		return null;
	}

}
