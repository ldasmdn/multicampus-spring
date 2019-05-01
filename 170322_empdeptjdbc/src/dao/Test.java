package dao;

import java.util.HashMap;

import commons.Constant;

/**
 * <pre>
 * DAO Ŭ���� �׽�Ʈ
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
		//[INSERT] �������� �ϳ��� �߰��ϴ� ��� 
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
//		System.out.println(dao.insertEmp(params)); // ��� : true
		
		
		//---------------------------------------------------------------
		//[INSERT] �μ����� �ϳ��� �߰��ϴ� ��� 
		//---------------------------------------------------------------
//		HashMap<String, Object> params = new HashMap<>();
//		params.put(Constant.DEPTNO, 50   	    );
//		params.put(Constant.DNAME , "DEVELOPMENT");
//		params.put(Constant.LOC   , "LOS ANGELES");
//		System.out.println(dao.insertDept(params)); // ��� : true
		
		
		//---------------------------------------------------------------
		//[UPDATE] �������� �ϳ��� �����ϴ� ��� 
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
//		System.out.println(dao.updateEmp(params)); // ��� : true
		
		
		//---------------------------------------------------------------
		//[DELETE] �������� �ϳ��� �����ϴ� ��� 
		//---------------------------------------------------------------
//		System.out.println(dao.deleteEmp(2018)); // ��� : true
		
		
		//---------------------------------------------------------------
		//[SELECT] �μ��� ������ �˻��ϴ� ���
		//---------------------------------------------------------------
//		for(HashMap<String, Object> emp : dao.selectEmpByDeptno(20)) { System.out.println(emp); } // ��� : 5�� ��ȸ
		
		
		//---------------------------------------------------------------
		//[SELECT] ������ ������ �˻��ϴ� ���
		//---------------------------------------------------------------
//		for(HashMap<String, Object> emp : dao.selectEmpByJob("MANAGER")) { System.out.println(emp); } // ��� : 3�� ��ȸ
		
		
		//---------------------------------------------------------------
		//[SELECT] ���� �̸�(����)���� �˻��ϴ� ��� 
		//---------------------------------------------------------------
//		for(HashMap<String, Object> emp : dao.selectEmpByEname("J")) { System.out.println(emp); } // ��� : 2�� ��ȸ
		
	}
	
}
