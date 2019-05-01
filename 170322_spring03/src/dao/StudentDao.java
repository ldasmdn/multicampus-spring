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
	 * (INSERT) ���� ���� �ϳ��� �߰��Ѵ�.
	 * 
	 * @param params
	 * @return
	 */
	public boolean insertStudent(HashMap<String, Object> params) {
		
		// �Ķ���� ��ġ�� �ʿ������� Ÿ���� �ʿ����
		int result = jdbcTemplate.update("insert into students values(0, ?, ?, ?)",
				params.get(Student.NAME), params.get(Student.AGE), params.get(Student.SCORE));
		
		if(result > 0)
			return true;
		else
			return false;
		
	}
	
	/**
	 * (UPDATE) ���� ���� �ϳ��� �����Ѵ�.
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
	 * (DELETE) ���� ���� �ϳ��� �����Ѵ�.
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
	 * (SELECT) ��� ����Ʈ�� ��ȸ�Ѵ�.
	 * 
	 * @param s_id
	 * @return
	 */
	public HashMap<String, Object> selectOne(int s_id) {
		
		// queryForObject(sql, mapper, args) : �ܰ�
		return jdbcTemplate.queryForObject("select * from students where s_id = ?", mapper, s_id);
		
	}
	
	/**
	 * (SELECT) ��� ������ ��ȸ�Ѵ�.
	 * 
	 * 
	 * @return
	 */
	public List<HashMap<String, Object>> selectAll() {
		
		// query() : �ٰ�
		return jdbcTemplate.query("select * from students", mapper);
		
	}
	
	
	
	/**
	 * RowMapper�� ��ӹ޾Ƽ� �����ϴ� �޼ҵ忡
	 * ResultSet�� ��(�Ǵ� HashMap)�� ��� �����ų�� ����
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
