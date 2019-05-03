package dao;

import java.util.HashMap;
import java.util.List;

public interface IBoardDao {
	
	public int insertBoard(HashMap<String, Object> params);
	public int updateBoard(HashMap<String, Object> params);
	public int deleteBoard(int num);
	public HashMap<String, Object> selecctBoardInfo(int num);
	public List<HashMap<String, Object>> selectBoardList();
	public List<HashMap<String, Object>> selectBySearch(HashMap<String, Object> params);
	
}
