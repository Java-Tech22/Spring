package controllers.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controllers.dao.ItemDao;
import controllers.model.Item;

@Service
public class ItemService {
	
	@Autowired
	private ItemDao itemDao;
	
	/*
	 * private static List<Item> Lists = new ArrayList<Item>(); private static int
	 * ListCount = 3;
	 * 
	 * //int id, String name, String desc, Date date
	 * 
	 * static { Lists.add(new Item(1, "Neeraj", "Learn Spring MVC", new Date()));
	 * Lists.add(new Item(2, "Suhas", "Learn Struts", new Date())); Lists.add(new
	 * Item(3, "Narayan", "Learn Hibernate", new Date())); }
	 */

	public List<Item> retrieveLists() {
		return itemDao.getItems();
	}

	public void addList(String name, String desc, Date date) {
		System.out.println("Inside addList service");
		Item item=new Item();
		item.setName(name);
		item.setDesc(desc);
		item.setDate(date);
		itemDao.addItem(item);
		
	}

	public void deleteList(int id) {
		itemDao.deleteItem(id);
	}



}
