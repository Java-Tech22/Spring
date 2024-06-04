package Emp;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("applicationContext.xml");
		
		BeanFactory factory = new XmlBeanFactory(resource);
		
//		Employee emp = (Employee)factory.getBean("empbean");
//		emp.display();
		
		Employee emp1 = (Employee)factory.getBean("empbean1");
		emp1.display();

	}

}
