package service;

import java.util.HashMap;
import java.util.List;

public interface IBoardService {
	
	public boolean insertBoard(String name, String pass, String email, String title, String content);
	public boolean updateBoard(int num, String name, String pass, String email, String title, String content);
	public boolean deleteBoard(int num);
	public HashMap<String, Object> getBoardInfo(int num);
	public HashMap<String, Object> getBoardList(int page);
	
}