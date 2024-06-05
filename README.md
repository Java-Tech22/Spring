# Spring Concepts
Spring Framework


**DAY 1**


Why use SpringFramework ?
Spring is lightweight when it comes to size and transparency. The basic version of Spring framework is around 2MB.

Millions of developers around the world use Spring Framework to create high performing, easily testable, and reusable code.

 Spring framework targets to make J2EE development easier to use and promotes good programming practices by enabling a POJO-based programming model.


Dependency Injection (DI)
Dependency injection can happen in the way of passing parameters to the constructor or by post-construction using setter methods.


Core Container
The Core Container consists of the Core, Beans, Context, and Expression Language modules the details of which are as follows −
The Core module provides the fundamental parts of the framework, including the IoC and Dependency Injection features.
The Bean module provides BeanFactory, which is a sophisticated implementation of the factory pattern.
The Context module builds on the solid base provided by the Core and Beans modules and it is a medium to access any objects defined and configured. The ApplicationContext interface is the focal point of the Context module.
The SpEL module provides a powerful expression language for querying and manipulating an object graph at runtime.


Spring Configuration Metadata
Spring IoC container is totally decoupled from the format in which this configuration metadata is actually written. Following are the three important methods to provide configuration metadata to the Spring Container −
XML based configuration file.
Annotation-based configuration
Java-based configuration





Loosely coupled code (Dependency Injection) VS Tightly coupled code 

Class Animal {
Food food1;

Food food=new Food();    //Tightly coupled code
food.pizza();


Animal(Food food) {
this.food1=food;
}

Void setFood(Food food) {
this.food1=food;
}

Void eat() {

	food1.pizza();
}

}

Class Food {

      Void pizza() {
	sop(“Pizza”);
	}
}

**DAY 2**

In Spring framework, IOC container is responsible to inject the dependency. We provide metadata to the IOC container either by XML file or annotation.
Advantage of Dependency Injection
makes the code loosely coupled so easy to maintain
makes the code easy to test
Advantages of Spring Framework
1) Predefined Templates
Spring framework provides templates for JDBC, Hibernate, JPA etc. technologies. So there is no need to write too much code. It hides the basic steps of these technologies.
2) Loose Coupling
The Spring applications are loosely coupled because of dependency injection.
3) Easy to test
The Dependency Injection makes easier to test the application. The EJB or Struts application require server to run the application but Spring framework doesn't require server.
4) Lightweight
Spring framework is lightweight because of its POJO implementation. The Spring Framework doesn't force the programmer to inherit any class or implement any interface. That is why it is said non-invasive.
5) Fast Development
The Dependency Injection feature of Spring Framework and it support to various frameworks makes the easy development of JavaEE application.
6) Powerful abstraction
It provides powerful abstraction to JavaEE specifications such as JMS, JDBC, JPA and JTA.
7) Declarative support
It provides declarative support for caching, validation, transactions and formatting.
Spring Modules
The Spring framework comprises of many modules such as core, beans, context, expression language, AOP, Aspects, Instrumentation, JDBC, ORM, OXM, JMS, Transaction, Web, Servlet, Struts etc. These modules are grouped into Test, Core Container, AOP, Aspects, Instrumentation, Data Access / Integration, Web (MVC / Remoting) as displayed in the following diagram.

The IoC container is responsible to instantiate, configure and assemble the objects. The IoC container gets informations from the XML file and works accordingly. The main tasks performed by IoC container are:
to instantiate the application class
to configure the object
to assemble the dependencies between the objects
There are two types of IoC containers. They are:
BeanFactory
ApplicationContext


**DAY 3**

Difference between constructor and setter injection
Partial dependency: can be injected using setter injection but it is not possible by constructor. Suppose there are 3 properties in a class, having 3 arg constructor and setters methods. In such case, if you want to pass information for only one property, it is possible by setter method only.
Overriding: Setter injection overrides the constructor injection. If we use both constructor and setter injection, IOC container will use the setter injection.
Changes: We can easily change the value by setter injection. It doesn't create a new bean instance always like constructor. So setter injection is flexible than constructor injection.
Autowiring in Spring
Autowiring feature of spring framework enables you to inject the object dependency implicitly. It internally uses setter or constructor injection.
Autowiring can't be used to inject primitive and string values. It works with reference only.
Advantage of Autowiring
It requires the less code because we don't need to write the code to inject the dependency explicitly.

Disadvantage of Autowiring
No control of programmer.


A Spring MVC is a Java framework which is used to build web applications. It follows the Model-View-Controller design pattern. It implements all the basic features of a core spring framework like Inversion of Control, Dependency Injection.
A Spring MVC provides an elegant solution to use MVC in spring framework by the help of DispatcherServlet. Here, DispatcherServlet is a class that receives the incoming request and maps it to the right resource such as controllers, models, and views.
Spring Web Model-View-Controller

Model - A model contains the data of the application. A data can be a single object or a collection of objects.
Controller - A controller contains the business logic of an application. Here, the @Controller annotation is used to mark the class as the controller.
View - A view represents the provided information in a particular format. Generally, JSP+JSTL is used to create a view page. Although spring also supports other view technologies such as Apache Velocity, Thymeleaf and FreeMarker.
Front Controller - In Spring Web MVC, the DispatcherServlet class works as the front controller. It is responsible to manage the flow of the Spring MVC application.

Understanding the flow of Spring Web MVC

All the incoming request is intercepted by the DispatcherServlet that works as the front controller.
The DispatcherServlet gets an entry of handler mapping from the XML file and forwards the request to the controller.
The controller returns an object of ModelAndView.
The DispatcherServlet checks the entry of view resolver in the XML file and invokes the specified view component.

Advantages of Spring MVC Framework
Let's see some of the advantages of Spring MVC Framework:-
Separate roles - The Spring MVC separates each role, where the model object, controller, command object, view resolver, DispatcherServlet, validator, etc. can be fulfilled by a specialized object.
Light-weight - It uses light-weight servlet container to develop and deploy your application.
Powerful Configuration - It provides a robust configuration for both framework and application classes that includes easy referencing across contexts, such as from web controllers to business objects and validators.
Rapid development - The Spring MVC facilitates fast and parallel development.
Reusable business code - Instead of creating new objects, it allows us to use the existing business objects.
Easy to test - In Spring, generally we create JavaBeans classes that enable you to inject test data using the setter methods.
Flexible Mapping - It provides the specific annotations that easily redirect the page.

