package dao;

import model.Product;

public class Test {
	
	public static void main(String[] args) {
		
		ProductDao dao = new ProductDao();
		
		Product product = new Product();
		product.setName("NAME");
		product.setPrice(10000);
		product.setPicture("image.jpg");
		product.setDescription("description");
		System.out.println(dao.insertProduct(product));
		
		System.out.println(dao.selectProductInfo(1));
		
		for(Product p : dao.selectProductList()) {
			System.out.println(p);
		}
		
	}
	
}
