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


