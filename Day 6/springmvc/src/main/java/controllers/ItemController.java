package controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import controllers.service.ItemService;

@Controller
@SessionAttributes("name")
public class ItemController {

	@Autowired
	private ItemService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showList(ModelMap model) {
		model.addAttribute("myList", service.retrieveLists());
		return "list";
	}
	
	
	  @RequestMapping(value = "/add", method = RequestMethod.GET) 
	  public String displayAddPage() { 
		  return "add"; 
	  }
	 

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addToList(ModelMap model, @RequestParam String name,@RequestParam String desc) {
		service.addList(name, desc, new Date());
		System.out.println("Inside addtoList method");
		//model.clear();// to prevent request parameter "name" to be passed
		return "redirect:list";
	}
	

	  @RequestMapping(value = "/modify", method = RequestMethod.GET) 
	  public String updateItem() { 
		  return "redirect:list"; 
	  }
	  

	  @RequestMapping(value = "/delete", method = RequestMethod.GET) 
	  public String deleteItem() { 
		  return "redirect:list"; 
	  }
	
	
}
