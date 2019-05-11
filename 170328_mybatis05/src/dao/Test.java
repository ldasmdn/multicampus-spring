package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import commons.Constant;

public class Test {

	public static void main(String[] args) {
		
		IBoardDao dao = new BoardDao();
		
		//-----------------------------------------
		// [INSERT] �Խñ� ���
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
		// [UPDATE] �Խñ� ����
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
		// [DELETE] �Խñ� ����
		//-----------------------------------------
		dao.deleteBoard(num);
		if(dao.selecctBoardInfo(num) == null) { System.out.println("����"); }
		
		//-----------------------------------------
		// [SELECT] ���� �Ǵ� �������� ��ȸ
		//-----------------------------------------
		HashMap<String, Object> selectParams = new HashMap<>();
		selectParams.put("title",   "update");
		selectParams.put("content", "AI"    );
		for(HashMap<String, Object> board : dao.selectBySearch(selectParams)) {
			System.out.println(board);
		}
		
		//-----------------------------------------
		// [SELECT] ���� ���� Ű����� ��ȸ
		//-----------------------------------------
		List<String> selectKeyparams = new ArrayList<>();
		selectKeyparams.add("I");
		selectKeyparams.add("0");
		for(HashMap<String, Object> result : dao.selectByMultiKeyword(selectKeyparams)) {
			System.out.println(result);
		}
		
	}
	
}