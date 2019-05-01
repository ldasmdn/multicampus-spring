package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import commons.Product;

public class ProductDao {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public boolean insertProduct(HashMap<String, Object> params) {
		
		int result = jdbcTemplate.update("insert into products values(0, ?, ?, ?, ?)",
				params.get(Product.NAME), params.get(Product.PRICE),
				params.get(Product.PICTUREURL), params.get(Product.DESCRIPTION));
		
		if(result > 0)
			return true;
		else
			return false;
		
	}
	
	public boolean updateProduct(HashMap<String, Object> params) {
		
		int result = jdbcTemplate.update("update products set name = ?, price = ?, pictureurl = ?, description = ? where code = ?",
				params.get(Product.NAME), params.get(Product.PRICE),
				params.get(Product.PICTUREURL), params.get(Product.DESCRIPTION), 
				params.get(Product.CODE));
		
		if(result > 0)
			return true;
		else
			return false;
		
	}
	
	public boolean deleteProduct(int code) {
		
		int result = jdbcTemplate.update("delete from products where code = ?", code);
		
		if(result > 0)
			return true;
		else
			return false;
		
	}
	
	public HashMap<String, Object> selectOne(int code) {
		
		return jdbcTemplate.queryForObject("select * from products", mapper, code);
		
	}
	
	public List<HashMap<String, Object>> selectAll() {
		
		return jdbcTemplate.query("select * from products", mapper);
		
	}
	
	private RowMapper<HashMap<String, Object>> mapper = new ProductMapper();
	class ProductMapper implements RowMapper<HashMap<String, Object>> {

		@Override
		public HashMap<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			HashMap<String, Object> result = new HashMap<>();
			result.put(Product.CODE       , rs.getInt   (Product.CODE)       );
			result.put(Product.NAME       , rs.getString(Product.NAME)       );
			result.put(Product.PRICE      , rs.getInt   (Product.PRICE)      );
			result.put(Product.PICTUREURL , rs.getString(Product.PICTUREURL) );
			result.put(Product.DESCRIPTION, rs.getString(Product.DESCRIPTION));
			return result;
		}
		
	}
	
}
