package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		
		ModelAndView mav = new ModelAndView();
		
		// 데이터와 페이지를 지정
		mav.addObject("greeting", "HelloWorld"); // req.setAttribute()와 유사
		mav.setViewName("hello");
		
		return mav;
	}
	
}
