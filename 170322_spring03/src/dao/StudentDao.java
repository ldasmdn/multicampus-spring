package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import commons.Student;

public class StudentDao {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * (INSERT) 직원 정보 하나를 추가한다.
	 * 
	 * @param params
	 * @return
	 */
	public boolean insertStudent(HashMap<String, Object> params) {
		
		// 파라미터 위치는 필요하지만 타입은 필요없음
		int result = jdbcTemplate.update("insert into students values(0, ?, ?, ?)",
				params.get(Student.NAME), params.get(Student.AGE), params.get(Student.SCORE));
		
		if(result > 0)
			return true;
		else
			return false;
		
	}
	
	/**
	 * (UPDATE) 직원 정보 하나를 수정한다.
	 * 
	 * @param params
	 * @return
	 */
	public boolean updateStudent(HashMap<String, Object> params) {
		
		int result = jdbcTemplate.update("update students set name = ?, age = ?, score = ? where s_id = ?",
				params.get(Student.NAME), params.get(Student.AGE), params.get(Student.SCORE), params.get(Student.S_ID));
		
		if(result > 0)
			return true;
		else
			return false;
		
	}
	
	/**
	 * (DELETE) 직원 정보 하나를 삭제한다.
	 * 
	 * @param params
	 * @return
	 */
	public boolean deleteStudent(int s_id) {
		
		int result = jdbcTemplate.update("delete from students where s_id = ?", s_id);
		
		if(result > 0)
			return true;
		else
			return false;
		
	}
	
	/**
	 * (SELECT) 사원 리스트를 조회한다.
	 * 
	 * @param s_id
	 * @return
	 */
	public HashMap<String, Object> selectOne(int s_id) {
		
		// queryForObject(sql, mapper, args) : 단건
		return jdbcTemplate.queryForObject("select * from students where s_id = ?", mapper, s_id);
		
	}
	
	/**
	 * (SELECT) 사원 정보를 조회한다.
	 * 
	 * 
	 * @return
	 */
	public List<HashMap<String, Object>> selectAll() {
		
		// query() : 다건
		return jdbcTemplate.query("select * from students", mapper);
		
	}
	
	
	
	/**
	 * RowMapper를 상속받아서 구현하는 메소드에
	 * ResultSet을 모델(또는 HashMap)에 어떻게 연결시킬지 정의
	 * 
	 * @author ldasmdn
	 *
	 */
	private RowMapper<HashMap<String, Object>> mapper = new StudentMapper();
	class StudentMapper implements RowMapper<HashMap<String, Object>> {

		@Override
		public HashMap<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			HashMap<String, Object> result = new HashMap<>();
			result.put(Student.S_ID , rs.getInt   (Student.S_ID) );
			result.put(Student.NAME , rs.getString(Student.NAME) );
			result.put(Student.AGE  , rs.getInt   (Student.AGE)  );
			result.put(Student.SCORE, rs.getInt   (Student.SCORE));
			return result;
		}
		
	}
	
}
