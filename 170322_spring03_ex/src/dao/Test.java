package dao;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import commons.Product;

public class Test {
	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		ProductDao dao = context.getBean("productDao", ProductDao.class);
		
//		HashMap<String, Object> params = new HashMap<>();
//		params.put(Product.NAME       , "PRODUCT"    );
//		params.put(Product.PRICE      , 10000        );
//		params.put(Product.PICTUREURL , "image.jpg"  );
//		params.put(Product.DESCRIPTION, "description");
//		System.out.println(dao.insertProduct(params)); // 결과 : true
		
//		System.out.println(dao.deleteProduct(1)); // 결과 : true
		
		for(HashMap<String, Object> product : dao.selectAll()) { System.out.println(product); }
	}
}
