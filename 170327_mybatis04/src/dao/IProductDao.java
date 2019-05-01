package dao;

import java.util.List;

import model.Product;

public interface IProductDao {
	
	public int insertProduct(Product product);
	public int updateProduct(Product product);
	public int deleteProduct(int code);
	public Product selectProductInfo(int code);
	public List<Product> selectProductList();
	
}
