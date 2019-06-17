package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("onlyData.do")
	public Map<String, Object> onlyData() {
		Map<String, Object> attr = new HashMap<String, Object>();
		attr.putIfAbsent("greeting", "Hello World");
		return attr;
	}
	
	@RequestMapping("onlyPage.do")
	public String onlyPage(Model model) {
		model.addAttribute("greeting", "Hello World");
		return "onlyPage";
	}
	
}
