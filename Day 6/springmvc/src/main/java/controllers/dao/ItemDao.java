package controllers.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import controllers.model.Item;
import javax.transaction.Transactional;

@Component
public class ItemDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void addItem(Item list) {
		System.out.println("Inside DAO add item method ");
		this.hibernateTemplate.save(list);
	}
	@Transactional
	public List<Item> getItems() {
		List<Item> items = this.hibernateTemplate.loadAll(Item.class);
		return items;
		
	}
	
	@Transactional
	public void deleteItem(int itemId) {
		Item item= this.hibernateTemplate.load(Item.class, itemId);
		this.hibernateTemplate.delete(item);
		
	}
	@Transactional
	public Item getItem(int itemId) {
		Item item = this.hibernateTemplate.load(Item.class, itemId);
		return item;
		
	}
	
	
}
