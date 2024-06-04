package Emp;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Employee {

	private int empId;
	private String name;
	private Address address;
	private Map<Integer, String> manager;
	
	
	public Employee() {
		
	}

	public Employee(int empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
	}
	
	
	public Employee(int empId, String name, Address address) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	public Map<Integer, String> getManager() {
		return manager;
	}

	public void setManager(Map<Integer, String> manager) {
		this.manager = manager;
	}

	public void display() {
		System.out.println("Emp Id " + empId);
		System.out.println("Hello " + name);
		System.out.println(""+ address.toString());
		System.out.println("Manager :" );
		
		Set<Entry<Integer, String>> set=manager.entrySet();
		Iterator<Entry<Integer, String>> itr=set.iterator();
		
		while(itr.hasNext()) {
			Entry<Integer, String> entry=itr.next();
			System.out.println("ID : "+entry.getKey() + "  Name : "+entry.getValue());
		}
	}
	
	
}

