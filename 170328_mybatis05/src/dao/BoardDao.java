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

	//----------------------------------------------------------------------------
	// (INSERT) 게시글 등록
	//----------------------------------------------------------------------------
	@Override
	public int insertBoard(HashMap<String, Object> params) {
		
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			// -------------------------------------------------------------------
			// session.getMapper(*.class)
			// -------------------------------------------------------------------
			// 생성되는 객체는 IBoardDao 타입이 됨
			// 각 메소드 위에 애노테이션에 정의된 SQL문을 호출하는 몸통을 갖게 됨
			return session.getMapper(IBoardDao.class).insertBoard(params);
			
		} catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
			
		} finally {
			
			if (session != null) { session.close(); }
			
		}

		return 0;
		
	}
	
	//----------------------------------------------------------------------------
	// (UPDATE) 게시글 수정
	//----------------------------------------------------------------------------
	@Override
	public int updateBoard(HashMap<String, Object> params) {
		
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			// -------------------------------------------------------------------
			// session.getMapper(*.class)
			// -------------------------------------------------------------------
			// 생성되는 객체는 IBoardDao 타입이 됨
			// 각 메소드 위에 애노테이션에 정의된 SQL문을 호출하는 몸통을 갖게 됨
			return session.getMapper(IBoardDao.class).updateBoard(params);
			
		} catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
			
		} finally {
			
			if (session != null) { session.close(); }
			
		}

		return 0;
		
	}

	
	//----------------------------------------------------------------------------
	// (DELETE) 게시글 삭제
	//----------------------------------------------------------------------------
	@Override
	public int deleteBoard(int s_id) {
		
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			// -------------------------------------------------------------------
			// session.getMapper(*.class)
			// -------------------------------------------------------------------
			// 생성되는 객체는 IBoardDao 타입이 됨
			// 각 메소드 위에 애노테이션에 정의된 SQL문을 호출하는 몸통을 갖게 됨
			return session.getMapper(IBoardDao.class).deleteBoard(s_id);
			
		} catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
			
		} finally {
			
			if (session != null) { session.close(); }
			
		}

		return 0;
		
	}

	//----------------------------------------------------------------------------
	// (SELECT) 게시글 정보 조회
	//----------------------------------------------------------------------------
	@Override
	public HashMap<String, Object> selecctBoardInfo(int num) {
		
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			
			// -------------------------------------------------------------------
			// session.getMapper(*.class)
			// -------------------------------------------------------------------
			// 생성되는 객체는 IBoardDao 타입이 됨
			// 각 메소드 위에 애노테이션에 정의된 SQL문을 호출하는 몸통을 갖게 됨
			return session.getMapper(IBoardDao.class).selecctBoardInfo(num);
			
		} catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
			
		} finally {
			
			if (session != null) { session.close(); }
			
		}

		return null;
		
	}

	//----------------------------------------------------------------------------
	// (SELECT) 게시글 리스트 조회
	//----------------------------------------------------------------------------
	@Override
	public List<HashMap<String, Object>> selectBoardList() {
		
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			
			// -------------------------------------------------------------------
			// session.getMapper(*.class)
			// -------------------------------------------------------------------
			// 생성되는 객체는 IBoardDao 타입이 됨
			// 각 메소드 위에 애노테이션에 정의된 SQL문을 호출하는 몸통을 갖게 됨
			return session.getMapper(IBoardDao.class).selectBoardList();
			
		} catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
			
		} finally {
			
			if (session != null) { session.close(); }
			
		}

		return null;
		
	}

	//----------------------------------------------------------------------------
	// (SELECT) 제목 또는 내용 검색
	//----------------------------------------------------------------------------
	@Override
	public List<HashMap<String, Object>> selectBySearch(HashMap<String, Object> params) {
		
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			
			// -------------------------------------------------------------------
			// session.getMapper(*.class)
			// -------------------------------------------------------------------
			// 생성되는 객체는 IBoardDao 타입이 됨
			// 각 메소드 위에 애노테이션에 정의된 SQL문을 호출하는 몸통을 갖게 됨
			return session.getMapper(IBoardDao.class).selectBySearch(params);
			
		} catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
			
		} finally {
			
			if (session != null) { session.close(); }
			
		}

		return null;
		
	}

	//----------------------------------------------------------------------------
	// (SELECT) 여러 개의 키워드로 내용 검색
	//----------------------------------------------------------------------------
	@Override
	public List<HashMap<String, Object>> selectByMultiKeyword(List<String> params) {
		
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			
			// -------------------------------------------------------------------
			// session.getMapper(*.class)
			// -------------------------------------------------------------------
			// 생성되는 객체는 IBoardDao 타입이 됨
			// 각 메소드 위에 애노테이션에 정의된 SQL문을 호출하는 몸통을 갖게 됨
			for(String list : params) {
				System.out.println(list);
			}
			
			return session.getMapper(IBoardDao.class).selectByMultiKeyword(params);
			
		} catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
			
		} finally {
			
			if (session != null) { session.close(); }
			
		}
		
		return null;
		
	}

}
