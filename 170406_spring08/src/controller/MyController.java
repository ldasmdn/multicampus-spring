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
	public ModelAndView hello(HttpServletRequest req, HttpServletResponse resp, @RequestParam(required=false, value="name") String myName, @RequestParam(defaultValue="0") int age) {
		// 요청으로 들어온 request 객체와, 응답으로 사용할 response 객체를 사용하려면
		// 매개변수에 request와 response 객체를 두면 자동으로 해당 객체가 들어옴
		// 대체로 스프링 MVC에서는 필요한 정보가 있다면 절절한 타입의 매개변수를 넣어두면 알아서 들어옴
		
		// 파라미터를 받고 싶으면 파라미터 키 값과 같은 이름으로 매개변수를 넣어두면 됨
		// 파라미터 키 값과 다르게 하려면
		// @RequestParam("name") String myName
		
		// 숫자에 대해서 정수로 매개변수를 주면 형변환 후 알아서 들어감
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("greeting", "Hello Spring MVC");
		mav.addObject("userIP", req.getRemoteAddr());
		mav.addObject("name", myName);
		mav.addObject("age", age - 1);
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
