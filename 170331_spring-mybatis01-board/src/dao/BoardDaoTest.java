package dao;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardDaoTest {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		IBoardDao dao = context.getBean("boardDao", IBoardDao.class);
		
		for(HashMap<String, Object> board : dao.selectBoardList()) {
			System.out.println(board);
		}
		
	}
	
}
