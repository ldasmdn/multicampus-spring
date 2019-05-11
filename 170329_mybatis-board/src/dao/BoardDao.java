package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * <pre>
 * IBoardDao 인터페이스를 구현한 DAO 클래스
 * </pre>
 * 
 * @version 1.0, 2019/05/01
 *
 */
public class BoardDao implements IBoardDao {

	private SqlSessionFactory sqlSessionFactory;

	public BoardDao() {
		InputStream is = null;
		
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public int insertBoard(HashMap<String, Object> params) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			return session.getMapper(IBoardDao.class).insertBoard(params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) { session.close(); }
		}

		return 0;
	}
	
	@Override
	public int updateBoard(HashMap<String, Object> params) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			return session.getMapper(IBoardDao.class).updateBoard(params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) { session.close(); }
		}

		return 0;
	}

	@Override
	public int deleteBoard(int num) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			return session.getMapper(IBoardDao.class).deleteBoard(num);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) { session.close(); }
		}

		return 0;
	}

	@Override
	public HashMap<String, Object> selecctBoardInfo(int num) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			return session.getMapper(IBoardDao.class).selecctBoardInfo(num);
		} catch(Exception e) {
			
		}
		
		return null;
	}
	
	@Override
	public List<HashMap<String, Object>> selectBoardList(HashMap<String, Object> params) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			return session.getMapper(IBoardDao.class).selectBoardList(params);
		} catch(Exception e) {
			
		}
		
		return null;
	}

	@Override
	public int getBoardTotal() {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			return session.getMapper(IBoardDao.class).getBoardTotal();
		} catch(Exception e) {
			
		}
		
		return 0;
	}

}
