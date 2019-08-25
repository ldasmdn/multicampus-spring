package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import commons.Constant;

public class EmployeeDao {
	
	//-------------------------------------------------------
	// (1) VO 클래스를 HashMap으로 대체하기
	// (2) 2개의 테이블을 조인하여 데이터 조회
	//-------------------------------------------------------

	private Connection conn;
	private static EmployeeDao instance;
	
	private static final String URL = "jdbc:mysql://localhost:3306/empdept_db";
	private static final String USER = "root";
	private static final String PASSWORD = "mysql";
	
	private EmployeeDao() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
		} catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("클래스 적재 실패");
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("커넥션 연결 실패");
			
		}
		
	}
	
	public static EmployeeDao getInstance() {
		
		if( instance == null ) instance = new EmployeeDao();
		return instance;
		
	}
	
	/**
	 * [INSERT] 직원정보를 하나를 추가하는 기능
	 */
	public boolean insertEmp(HashMap<String, Object> params) {
		
		PreparedStatement pstmt = null;
		String sql = "insert into emp values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {	
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt   (1, (int)    params.get(Constant.EMPNO)   );
			pstmt.setString(2, (String) params.get(Constant.ENAME)   );
			pstmt.setString(3, (String) params.get(Constant.JOB)     );
			pstmt.setInt   (4, (int)    params.get(Constant.MGR)     );
			pstmt.setString(5, (String) params.get(Constant.HIREDATE)); // java.util.Date는 적용되지 않음
			pstmt.setInt   (6, (int)    params.get(Constant.SAL)     );
			pstmt.setInt   (7, (int)    params.get(Constant.COMM)    );
			pstmt.setInt   (8, (int)    params.get(Constant.DEPTNO)  );
			int result = pstmt.executeUpdate(); // 쿼리 실행
			
			if(result > 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) { pstmt.close(); }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
		
	}
	
	/**
	 * [INSERT] 부서정보 하나를 추가하는 기능
	 */
	public boolean insertDept(HashMap<String, Object> params) {
		
		PreparedStatement pstmt = null;
		String sql = "insert into dept values(?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt   (1, (int)    params.get(Constant.DEPTNO));
			pstmt.setString(2, (String) params.get(Constant.DNAME) );
			pstmt.setString(3, (String) params.get(Constant.LOC)   );
			int result = pstmt.executeUpdate(); // 쿼리 실행
			
			if(result > 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) { pstmt.close(); }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
		
	}
	
	/**
	 * [UPDATE] 직원정보 하나를 수정하는 기능
	 */
	public boolean updateEmp(HashMap<String, Object> params) {

		PreparedStatement pstmt = null;
		String sql = "update emp set ename     = ? "
								+ ", job       = ? "
								+ ", mgr       = ? "
								+ ", hiredate  = ? "
								+ ", sal       = ? "
								+ ", comm      = ? "
								+ ", deptno    = ? "
								+ "where empno = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String) params.get(Constant.ENAME)   );
			pstmt.setString(2, (String) params.get(Constant.JOB)     );
			pstmt.setInt   (3, (int)    params.get(Constant.MGR)     );
			pstmt.setString(4, (String) params.get(Constant.HIREDATE));
			pstmt.setInt   (5, (int)    params.get(Constant.SAL)     );
			pstmt.setInt   (6, (int)    params.get(Constant.COMM)    );
			pstmt.setInt   (7, (int)    params.get(Constant.DEPTNO)  );
			pstmt.setInt   (8, (int)    params.get(Constant.EMPNO)   );

			int result = pstmt.executeUpdate();

			if (result > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;

	}
	
	/**
	 * [DELETE] 직원정보 하나를 삭제하는 기능
	 */
	public boolean deleteEmp(int empno) {

		PreparedStatement pstmt = null;
		String sql = "delete from emp where empno = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			int result = pstmt.executeUpdate(); // 쿼리 실행

			if (result > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;

	}
	
	/**
	 * [SELECT] 부서로 직원을 검색하는 기능
	 */
	public List<HashMap<String, Object>> selectEmpByDeptno(int deptno) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HashMap<String, Object>> list = new ArrayList<>();

		String sql = "select * from emp e, dept d where e.deptno = d.deptno and e.deptno = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery(); // 쿼리 실행

			while (rs.next()) {
				HashMap<String, Object> emp = new HashMap<>();
				emp.put(Constant.EMPNO   , rs.getInt   (Constant.EMPNO)   );
				emp.put(Constant.ENAME   , rs.getString(Constant.ENAME)   );
				emp.put(Constant.JOB     , rs.getString(Constant.JOB)     );
				emp.put(Constant.MGR     , rs.getInt   (Constant.MGR)     );
				emp.put(Constant.HIREDATE, rs.getString(Constant.HIREDATE));
				emp.put(Constant.SAL     , rs.getInt   (Constant.SAL)     );
				emp.put(Constant.COMM    , rs.getInt   (Constant.COMM)    );
				emp.put(Constant.EMPNO   , rs.getInt   (Constant.EMPNO)   );
				emp.put(Constant.DEPTNO  , rs.getInt   (Constant.DEPTNO)  );
				emp.put(Constant.DNAME   , rs.getString(Constant.DNAME)   );
				emp.put(Constant.LOC     , rs.getString(Constant.LOC)     );
				list.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;

	}
	
	/**
	 * [SELECT] 직무로 직원을 검색하는 기능
	 */
	public List<HashMap<String, Object>> selectEmpByJob(String job) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HashMap<String, Object>> list = new ArrayList<>();

		String sql = "select * from emp e, dept d where e.deptno = d.deptno and e.job = ?";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, job);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				HashMap<String, Object> emp = new HashMap<>();
				emp.put(Constant.EMPNO   , rs.getInt   (Constant.EMPNO)   );
				emp.put(Constant.ENAME   , rs.getString(Constant.ENAME)   );
				emp.put(Constant.JOB     , rs.getString(Constant.JOB)     );
				emp.put(Constant.MGR     , rs.getInt   (Constant.MGR)     );
				emp.put(Constant.HIREDATE, rs.getString(Constant.HIREDATE));
				emp.put(Constant.SAL     , rs.getInt   (Constant.SAL)     );
				emp.put(Constant.COMM    , rs.getInt   (Constant.COMM)    );
				emp.put(Constant.EMPNO   , rs.getInt   (Constant.EMPNO)   );
				emp.put(Constant.DEPTNO  , rs.getInt   (Constant.DEPTNO)  );
				emp.put(Constant.DNAME   , rs.getString(Constant.DNAME)   );
				emp.put(Constant.LOC     , rs.getString(Constant.LOC)     );
				list.add(emp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;

	}
	
	/**
	 * [SELECT] 직원 이름(포함)으로 검색하는 기능
	 */
	public List<HashMap<String, Object>> selectEmpByEname(String ename) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HashMap<String, Object>> list = new ArrayList<>();

		String sql = "select * from emp e, dept d where e.deptno = d.deptno and ename like '%" + ename + "%'";

		try {

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				HashMap<String, Object> emp = new HashMap<>();
				emp.put(Constant.EMPNO   , rs.getInt   (Constant.EMPNO)   );
				emp.put(Constant.ENAME   , rs.getString(Constant.ENAME)   );
				emp.put(Constant.JOB     , rs.getString(Constant.JOB)     );
				emp.put(Constant.MGR     , rs.getInt   (Constant.MGR)     );
				emp.put(Constant.HIREDATE, rs.getString(Constant.HIREDATE));
				emp.put(Constant.SAL     , rs.getInt   (Constant.SAL)     );
				emp.put(Constant.COMM    , rs.getInt   (Constant.COMM)    );
				emp.put(Constant.EMPNO   , rs.getInt   (Constant.EMPNO)   );
				emp.put(Constant.DEPTNO  , rs.getInt   (Constant.DEPTNO)  );
				emp.put(Constant.DNAME   , rs.getString(Constant.DNAME)   );
				emp.put(Constant.LOC     , rs.getString(Constant.LOC)     );
				list.add(emp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;

	}
	
}