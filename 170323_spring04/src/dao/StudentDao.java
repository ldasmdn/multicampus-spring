package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import commons.Student;

@Component
public class StudentDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public int insertStudent(HashMap<String, Object> params) {
		String sql = "insert into students values(0, :name, :age, :score)";
		return jdbcTemplate.update(sql, params);
	}
	
	public int updateStudent(HashMap<String, Object> params) {
		String sql = "update students set name = :name, age = :age, score = :score where s_id = :s_id";
		return jdbcTemplate.update(sql, params);
	}
	
	public int deleteStudent(int s_id) {
		String sql = "delete from students where s_id = :s_id";
		return jdbcTemplate.update(sql, Collections.singletonMap("s_id", s_id));
	}
	
	public HashMap<String, Object> selectStudentInfo(int s_id) {
		String sql = "select * from students where s_id = :s_id";
		return jdbcTemplate.queryForObject(sql, Collections.singletonMap("s_id", s_id), mapper);
	}
	
	public List<HashMap<String, Object>> selectStudentList() {
		String sql = "select * from students";
		return jdbcTemplate.query(sql, mapper);
	}
	
	
	private RowMapper<HashMap<String, Object>> mapper = new StudentMapper();
	class StudentMapper implements RowMapper<HashMap<String, Object>> {

		@Override
		public HashMap<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			HashMap<String, Object> result = new HashMap<>();
			result.put(Student.S_ID , rs.getInt   (Student.S_ID) );
			result.put(Student.NAME , rs.getString(Student.S_ID) );
			result.put(Student.AGE  , rs.getInt   (Student.AGE)  );
			result.put(Student.SCORE, rs.getInt   (Student.SCORE));
			return result;
		}
		
	}
}
