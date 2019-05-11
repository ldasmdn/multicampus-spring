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
		
	}
	
}