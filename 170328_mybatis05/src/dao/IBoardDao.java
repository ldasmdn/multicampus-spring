package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <pre>
 * DB에 접근하기 위한 인터페이스
 * </pre>
 * 
 * @version 1.0, 2019/05/01
 *
 */
public interface IBoardDao {
	
	public int insertBoard(HashMap<String, Object> params);                              // (INSERT) 게시글 등록
	public int updateBoard(HashMap<String, Object> params);                              // (UPDATE) 게시글 수정
	public int deleteBoard(int num);                                                     // (DELETE) 게시글 삭제
	public HashMap<String, Object> selecctBoardInfo(int num);                            // (SELECT) 게시글 정보 조회
	public List<HashMap<String, Object>> selectBoardList();                              // (SELECT) 게시글 리스트 조회
	public List<HashMap<String, Object>> selectBySearch(HashMap<String, Object> params); // (SELECT) 제목 또는 내용 검색
	public List<HashMap<String, Object>> selectByMultiKeyword(List<String> params);      // (SELECT) 여러 개의 키워드로 내용 검색
	
}