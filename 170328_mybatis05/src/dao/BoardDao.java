package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDao implements IBoardDao {

	private SqlSessionFactory sqlSessionFactory;

	public BoardDao() {
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
	public int insertBoard(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();

		try {
			// -------------------------------------------------------------------
			// session.getMapper(*.class)
			// -------------------------------------------------------------------
			// �����Ǵ� ��ü�� IBoardDao Ÿ���� ��
			// �� �޼ҵ� ���� �ֳ����̼ǿ� ���ǵ� SQL���� ȣ���ϴ� ������ ���� ��
			return session.getMapper(IBoardDao.class).insertBoard(params);
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
	public int updateBoard(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();

		try {
			// -------------------------------------------------------------------
			// session.getMapper(*.class)
			// -------------------------------------------------------------------
			// �����Ǵ� ��ü�� IBoardDao Ÿ���� ��
			// �� �޼ҵ� ���� �ֳ����̼ǿ� ���ǵ� SQL���� ȣ���ϴ� ������ ���� ��
			return session.getMapper(IBoardDao.class).updateBoard(params);
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
	public int deleteBoard(int s_id) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();

		try {
			// -------------------------------------------------------------------
			// session.getMapper(*.class)
			// -------------------------------------------------------------------
			// �����Ǵ� ��ü�� IBoardDao Ÿ���� ��
			// �� �޼ҵ� ���� �ֳ����̼ǿ� ���ǵ� SQL���� ȣ���ϴ� ������ ���� ��
			return session.getMapper(IBoardDao.class).deleteBoard(s_id);
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
	public HashMap<String, Object> selecctBoardInfo(int num) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			// -------------------------------------------------------------------
			// session.getMapper(*.class)
			// -------------------------------------------------------------------
			// �����Ǵ� ��ü�� IBoardDao Ÿ���� ��
			// �� �޼ҵ� ���� �ֳ����̼ǿ� ���ǵ� SQL���� ȣ���ϴ� ������ ���� ��
			return session.getMapper(IBoardDao.class).selecctBoardInfo(num);
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
	public List<HashMap<String, Object>> selectBoardList() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			// -------------------------------------------------------------------
			// session.getMapper(*.class)
			// -------------------------------------------------------------------
			// �����Ǵ� ��ü�� IBoardDao Ÿ���� ��
			// �� �޼ҵ� ���� �ֳ����̼ǿ� ���ǵ� SQL���� ȣ���ϴ� ������ ���� ��
			return session.getMapper(IBoardDao.class).selectBoardList();
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
	public List<HashMap<String, Object>> selectBySearch(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			// -------------------------------------------------------------------
			// session.getMapper(*.class)
			// -------------------------------------------------------------------
			// �����Ǵ� ��ü�� IBoardDao Ÿ���� ��
			// �� �޼ҵ� ���� �ֳ����̼ǿ� ���ǵ� SQL���� ȣ���ϴ� ������ ���� ��
			return session.getMapper(IBoardDao.class).selectBySearch(params);
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
