# Spring Concepts
Spring Framework

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
