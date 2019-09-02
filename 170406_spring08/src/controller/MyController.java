package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping(value="hello.do", method=RequestMethod.GET)
	public ModelAndView hello(HttpServletRequest request, HttpServletResponse response, 
			@RequestParam(required=false, value="name") String myName, @RequestParam(defaultValue="0") int age) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("greeting", "Hello Spring MVC");
		mav.addObject("yourIP", request.getRemoteAddr());
		mav.addObject("yourName", myName);
		mav.addObject("yourAge", age - 1);
		mav.setViewName("hello.jsp");
		return mav;
	}
	
	@RequestMapping("goToNaver.do")
	public ModelAndView goToNaver() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:https://www.naver.com");
		return mav;
	}
	
}
