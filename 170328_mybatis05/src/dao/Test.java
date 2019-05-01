package dao;

import java.util.HashMap;

import commons.Constant;

public class Test {

	public static void main(String[] args) {
		
		IBoardDao dao = new BoardDao();
		
//		HashMap<String, Object> params = new HashMap<String, Object>();
//		params.put(Constant.PASS, "PASS"); 
//		params.put(Constant.NAME, "NAME");
//		params.put(Constant.EMAIL, "EMAIL");
//		params.put(Constant.CONTENT, "CONTENT");
//		dao.insertBoard(params);
//		
//		System.out.println(params.get(Constant.NUM));
//		System.out.println(dao.selecctBoardInfo((int)(long)params.get(Constant.NUM)));
		
		HashMap<String, Object> params = new HashMap<>();
		params.put("keyword", "TI");
		for(HashMap<String, Object> board : dao.selectBySearch(params)) {
			System.out.println(board);
		}
		
	}
	
}