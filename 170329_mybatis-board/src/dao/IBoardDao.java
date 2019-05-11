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
	
	// 게시글 등록
	public int insertBoard(HashMap<String, Object> params);
	
	// 게시글 수정
	public int updateBoard(HashMap<String, Object> params);
	
	// 게시글 삭제
	public int deleteBoard(int num);
	
	// 게시글 정보 조회
	public HashMap<String, Object> selecctBoardInfo(int num);
	
	// 게시글 리스트 조회
	public List<HashMap<String, Object>> selectBoardList(HashMap<String, Object> params);
	
	// 게시글 총 갯수 조회
	public int getBoardTotal();
	
}