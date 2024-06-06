package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String display() {
		return "hello";
	}

	@RequestMapping("/list")
	public String list() {
		return "list";
	}
	
	@RequestMapping("/data")
	public String list(Model model) {
		model.addAttribute("name", "Preeti");
		return "data";
	}
	
	@RequestMapping("/login")  
	
	    public String display(@RequestParam("name") String name,@RequestParam("pass") String pass, Model m)  
	    {  
	        if(pass.equals("admin"))  
	        {  
            String msg=name;  
	            //add a message to the model  
	            m.addAttribute("message", msg);  
	            return "success";  
	        }  
	        else  
	        {  
	            String msg="Sorry "+ name+". You entered an incorrect password";  
	            m.addAttribute("message", msg);  
	            return "error";  
	        }     
	    }

}
