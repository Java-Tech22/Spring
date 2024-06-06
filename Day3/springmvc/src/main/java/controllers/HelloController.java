package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public ModelAndView display() {
		ModelAndView m = new  ModelAndView();
		m.setViewName("Hello");
		return m;
	}
	
}
