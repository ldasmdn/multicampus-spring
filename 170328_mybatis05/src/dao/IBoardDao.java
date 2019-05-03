package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <pre>
 * 데이터에비스에 접근하기 위한 인터페이스
 * </pre>
 * 
 * @version 1.0, 2019/05/01
 *
 */
public interface IBoardDao {
	
	public int insertBoard(HashMap<String, Object> params);
	public int updateBoard(HashMap<String, Object> params);
	public int deleteBoard(int num);
	public HashMap<String, Object> selecctBoardInfo(int num);
	public List<HashMap<String, Object>> selectBoardList();
	public List<HashMap<String, Object>> selectBySearch(HashMap<String, Object> params);
	
	public List<HashMap<String, Object>> selectByMultiKeyword(List<String> params);
	
}
