package dao;

import java.util.HashMap;

import commons.Constant;

/**
 * <pre>
 * DAO 클래스 테스트
 * </pre>
 * 
 * @version 1.0, 2019/04/30
 * @author ldasmdn
 *
 */
public class Test {
	
	public static void main(String[] args) {
		
		EmployeeDao dao = EmployeeDao.getInstance();
		
		//---------------------------------------------------------------
		//[INSERT] 직원정보 하나를 추가하는 기능 
		//---------------------------------------------------------------
//		HashMap<String, Object> params = new HashMap<>();
//		params.put(Constant.EMPNO   , 2018   	  );
//		params.put(Constant.ENAME   , "Jeong"	  );
//		params.put(Constant.JOB     , "MANAGER"	  );
//		params.put(Constant.MGR     , 100		  );
//		params.put(Constant.HIREDATE, "2019-05-01");
//		params.put(Constant.SAL     , 10000		  );
//		params.put(Constant.COMM    , 10000		  );
//		params.put(Constant.DEPTNO  , 10		  );
//		System.out.println(dao.insertEmp(params)); // 결과 : true
		
		
		//---------------------------------------------------------------
		//[INSERT] 부서정보 하나를 추가하는 기능 
		//---------------------------------------------------------------
//		HashMap<String, Object> params = new HashMap<>();
//		params.put(Constant.DEPTNO, 50   	    );
//		params.put(Constant.DNAME , "DEVELOPMENT");
//		params.put(Constant.LOC   , "LOS ANGELES");
//		System.out.println(dao.insertDept(params)); // 결과 : true
		
		
		//---------------------------------------------------------------
		//[UPDATE] 직원정보 하나를 수정하는 기능 
		//---------------------------------------------------------------
//		HashMap<String, Object> params = new HashMap<>();
//		params.put(Constant.ENAME   , "KIM"	      );
//		params.put(Constant.JOB     , "MANAGER"	  );
//		params.put(Constant.MGR     , 100		  );
//		params.put(Constant.HIREDATE, "2018-12-12");
//		params.put(Constant.SAL     , 10000		  );
//		params.put(Constant.COMM    , 10000		  );
//		params.put(Constant.DEPTNO  , 10		  );
//		params.put(Constant.EMPNO   , 2018   	  );
//		System.out.println(dao.updateEmp(params)); // 결과 : true
		
		
		//---------------------------------------------------------------
		//[DELETE] 직원정보 하나를 삭제하는 기능 
		//---------------------------------------------------------------
//		System.out.println(dao.deleteEmp(2018)); // 결과 : true
		
		
		//---------------------------------------------------------------
		//[SELECT] 부서로 직원을 검색하는 기능
		//---------------------------------------------------------------
//		for(HashMap<String, Object> emp : dao.selectEmpByDeptno(20)) { System.out.println(emp); } // 결과 : 5건 조회
		
		
		//---------------------------------------------------------------
		//[SELECT] 직무로 직원을 검색하는 기능
		//---------------------------------------------------------------
//		for(HashMap<String, Object> emp : dao.selectEmpByJob("MANAGER")) { System.out.println(emp); } // 결과 : 3건 조회
		
		
		//---------------------------------------------------------------
		//[SELECT] 직원 이름(포함)으로 검색하는 기능 
		//---------------------------------------------------------------
//		for(HashMap<String, Object> emp : dao.selectEmpByEname("J")) { System.out.println(emp); } // 결과 : 2건 조회
		
	}
	
}
