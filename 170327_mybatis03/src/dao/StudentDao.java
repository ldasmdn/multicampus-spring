package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Student;

public class StudentDao implements IStudentDao {

	private SqlSessionFactory sqlSessionFactory;

	public StudentDao() {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public int insertStudent(Student student) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();

		try {
			// -------------------------------------------------------------------
			// session.getMapper(*.class)
			// -------------------------------------------------------------------
			// �����Ǵ� ��ü�� IStudentDao Ÿ���� ��
			// �� �޼ҵ� ���� �ֳ����̼ǿ� ���ǵ� SQL���� ȣ���ϴ� ������ ���� ��
			return session.getMapper(IStudentDao.class).insertStudent(student);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();

		try {
			// -------------------------------------------------------------------
			// session.getMapper(*.class)
			// -------------------------------------------------------------------
			// �����Ǵ� ��ü�� IStudentDao Ÿ���� ��
			// �� �޼ҵ� ���� �ֳ����̼ǿ� ���ǵ� SQL���� ȣ���ϴ� ������ ���� ��
			return session.getMapper(IStudentDao.class).updateStudent(student);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return 0;
	}

	@Override
	public int deleteStudent(int s_id) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();

		try {
			// -------------------------------------------------------------------
			// session.getMapper(*.class)
			// -------------------------------------------------------------------
			// �����Ǵ� ��ü�� IStudentDao Ÿ���� ��
			// �� �޼ҵ� ���� �ֳ����̼ǿ� ���ǵ� SQL���� ȣ���ϴ� ������ ���� ��
			return session.getMapper(IStudentDao.class).deleteStudent(s_id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return 0;
	}

	@Override
	public Student selecctStudentInfo(int s_id) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			// -------------------------------------------------------------------
			// session.getMapper(*.class)
			// -------------------------------------------------------------------
			// �����Ǵ� ��ü�� IStudentDao Ÿ���� ��
			// �� �޼ҵ� ���� �ֳ����̼ǿ� ���ǵ� SQL���� ȣ���ϴ� ������ ���� ��
			return session.getMapper(IStudentDao.class).selecctStudentInfo(s_id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			// -------------------------------------------------------------------
			// session.getMapper(*.class)
			// -------------------------------------------------------------------
			// �����Ǵ� ��ü�� IStudentDao Ÿ���� ��
			// �� �޼ҵ� ���� �ֳ����̼ǿ� ���ǵ� SQL���� ȣ���ϴ� ������ ���� ��
			return session.getMapper(IStudentDao.class).selectStudentList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return null;
	}

}
