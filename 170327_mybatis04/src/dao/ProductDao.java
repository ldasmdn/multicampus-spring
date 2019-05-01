package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Product;

public class ProductDao implements IProductDao {

	private SqlSessionFactory sqlSessionFactory;
	
	public ProductDao() {
		InputStream is = null;
		
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (is != null) { is.close(); }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			return session.getMapper(IProductDao.class).insertProduct(product);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(session != null) { session.close(); }
		}
		
		return 0;
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			return session.getMapper(IProductDao.class).updateProduct(product);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(session != null) { session.close(); }
		}
		
		return 0;
	}

	@Override
	public int deleteProduct(int code) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			return session.getMapper(IProductDao.class).deleteProduct(code);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(session != null) { session.close(); }
		}
		
		return 0;
	}

	@Override
	public Product selectProductInfo(int code) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			return session.getMapper(IProductDao.class).selectProductInfo(code);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(session != null) { session.close(); }
		}
		
		return null;
	}

	@Override
	public List<Product> selectProductList() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			return session.getMapper(IProductDao.class).selectProductList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(session != null) { session.close(); }
		}
		
		return null;
	}
	
}
