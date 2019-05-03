package service;

import java.util.HashMap;
import java.util.List;

public interface IBoardService {

	public boolean insertBoard(HashMap<String, Object> params);
	public boolean updateBoard(HashMap<String, Object> params);
	public boolean deleteBoard(int num);
	public HashMap<String, Object> selecctBoardInfo(int num);
	public List<HashMap<String, Object>> selectBoardList();
	public List<HashMap<String, Object>> selectBySearch(HashMap<String, Object> params);
	
}
