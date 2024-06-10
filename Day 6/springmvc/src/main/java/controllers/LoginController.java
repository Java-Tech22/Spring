package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import controllers.service.ItemService;
import controllers.service.LoginService;



@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping("/hello")
	public String display() {
		return "hello";
	}

	
	
	
	 @RequestMapping("/data") public String list(Model model) {
	 model.addAttribute("name", "Preeti"); return "data"; }
	  
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public String login(@RequestParam("name") String name,@RequestParam("pass") String pass, ModelMap m)  
	    {  
	        if(loginService.validateUser(name, pass)) {
	            //add a message to the model  
	            m.put("name", name);  
	            return "success";  
	        }  
	        else  
	        {  
	            String msg="Sorry "+ name+". You entered an incorrect password";  
	            m.put("message", msg);  
	            return "error";  
	        }     
	    }
}
