package service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IBoardDao;

@Service
public class BoardService implements IBoardService {
	
	@Autowired
	private IBoardDao dao;
	
	@Override
	public boolean insertBoard(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		int result = dao.insertBoard(params);
	
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateBoard(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		int result = dao.updateBoard(params);
		
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteBoard(int num) {
		// TODO Auto-generated method stub
		int result = dao.deleteBoard(num);
		
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public HashMap<String, Object> selecctBoardInfo(int num) {
		// TODO Auto-generated method stub
		return dao.selecctBoardInfo(num);
	}

	@Override
	public List<HashMap<String, Object>> selectBoardList() {
		// TODO Auto-generated method stub
		return dao.selectBoardList();
	}

	@Override
	public List<HashMap<String, Object>> selectBySearch(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		return dao.selectBySearch(params);
	}

}
