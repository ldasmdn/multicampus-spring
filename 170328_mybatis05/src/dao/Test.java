package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import commons.Constant;

public class Test {

	public static void main(String[] args) {
		
		IBoardDao dao = new BoardDao();
		
		//-----------------------------------------
		// [INSERT] 게시글 등록
		//-----------------------------------------
		HashMap<String, Object> insertParams = new HashMap<String, Object>();
		insertParams.put(Constant.PASS,    "PASS" ); 
		insertParams.put(Constant.NAME,    "NAME" );
		insertParams.put(Constant.EMAIL,   "EMAIL");
		dao.insertBoard(insertParams);
		int num = (int)(long)insertParams.get(Constant.NUM);
		System.out.println(insertParams);
		System.out.println(dao.selecctBoardInfo(num));
		
		//-----------------------------------------
		// [UPDATE] 게시글 수정
		//-----------------------------------------
		HashMap<String, Object> updateParams = new HashMap<String, Object>();
		updateParams.put(Constant.PASS,    "updatePASS"   ); 
		updateParams.put(Constant.NAME,    "updateNAME"   );
		updateParams.put(Constant.EMAIL,   "updateEMAIL"  );
		updateParams.put(Constant.TITLE,   "updateTITLE"  );
		updateParams.put(Constant.CONTENT, "updateCONTENT");
		updateParams.put(Constant.NUM,      num           );
		dao.updateBoard(updateParams);
		System.out.println(dao.selecctBoardInfo(num));
		
		//-----------------------------------------
		// [DELETE] 게시글 삭제
		//-----------------------------------------
		dao.deleteBoard(num);
		if(dao.selecctBoardInfo(num) == null) { System.out.println("삭제"); }
		
		//-----------------------------------------
		// [SELECT] 제목 또는 내용으로 조회
		//-----------------------------------------
		HashMap<String, Object> selectParams = new HashMap<>();
		selectParams.put("title",   "update");
		selectParams.put("content", "AI"    );
		for(HashMap<String, Object> board : dao.selectBySearch(selectParams)) {
			System.out.println(board);
		}
		
		//-----------------------------------------
		// [SELECT] 여러 개의 키워드로 조회
		//-----------------------------------------
		List<String> selectKeyparams = new ArrayList<>();
		selectKeyparams.add("I");
		selectKeyparams.add("0");
		for(HashMap<String, Object> result : dao.selectByMultiKeyword(selectKeyparams)) {
			System.out.println(result);
		}
		
	}
	
}