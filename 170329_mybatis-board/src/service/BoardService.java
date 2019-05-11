package service;

import java.util.HashMap;
import java.util.List;

import commons.Constant;
import dao.BoardDao;
import dao.IBoardDao;

public class BoardService implements IBoardService {
	
	private IBoardDao dao = new BoardDao();
	
	@Override
	public boolean insertBoard(String name, String pass, String email, String title, String content) {
		HashMap<String, Object> insertMap = new HashMap<>();
		insertMap.put(Constant.NAME,    name   );
		insertMap.put(Constant.PASS,    pass   );
		insertMap.put(Constant.EMAIL,   email  );
		insertMap.put(Constant.TITLE,   title  );
		insertMap.put(Constant.CONTENT, content);
		
		int result = dao.insertBoard(insertMap);
		if(result > 0) {
			return true;			
		} else {
			return false;			
		}
	}

	@Override
	public boolean updateBoard(int num, String name, String pass, String email, String title, String content) {
		HashMap<String, Object> updateMap = new HashMap<>();
		updateMap.put(Constant.NUM,     num    );
		updateMap.put(Constant.NAME,    name   );
		updateMap.put(Constant.PASS,    pass   );
		updateMap.put(Constant.EMAIL,   email  );
		updateMap.put(Constant.TITLE,   title  );
		updateMap.put(Constant.CONTENT, content);
		
		int result = dao.updateBoard(updateMap);
		if(result > 0) {
			return true;			
		} else {
			return false;			
		}
	}

	@Override
	public boolean deleteBoard(int num) {
		int result = dao.deleteBoard(num);
		if(result > 0) {
			return true;			
		} else {
			return false;
		}
	}

	@Override
	public HashMap<String, Object> getBoardInfo(int num) {
		// TODO Auto-generated method stub
		HashMap<String, Object> boardInfo = dao.selecctBoardInfo(num);
		boardInfo.put(Constant.READCOUNT, (int)boardInfo.get(Constant.READCOUNT) + 1);
		dao.updateBoard(boardInfo);
		
		return boardInfo;
	}

	@Override
	public HashMap<String, Object> getBoardList(int page) {	
		// 게시글 리스트
		int index = (page - 1) * 10;
		int count = 10;
		HashMap<String, Object> setIdxCnt = new HashMap<>();
		setIdxCnt.put("index", index);
		setIdxCnt.put("count", count);
		List<HashMap<String, Object>> list = dao.selectBoardList(setIdxCnt);

		// 페이징 처리
		int fisrtPage = 1;
		int beginIndex = (page - 1) / 10 * 10 + 1;
		int endIndex = ((page - 1) / 10 + 1) * 10;
		int lastPage = (dao.getBoardTotal() - 1) / 10 + 1;
		endIndex = lastPage < endIndex ? lastPage : endIndex; // 끝 페이지 검증
		
		// 결과 세팅
		HashMap<String, Object> boardList = new HashMap<String, Object>();
		boardList.put("list", list);
		boardList.put("currentPage", page);
		boardList.put("firstPage", fisrtPage);
		boardList.put("beginIndex", beginIndex);
		boardList.put("endIndex", endIndex);
		boardList.put("lastPage", lastPage);
		
		return boardList;
	}

}
