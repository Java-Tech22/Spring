## Environment:
- Java version: 17
- Maven version: 3.*
- Spring Boot version: 3.3.0

## Read-Only Files:
- src/test/*

## Data:
Sample example of JSON data object:
```json
{
   "id": 1,
   "name": "John Doe",
   "mobile": "987465238",
}
```

## Requirements:
There is a app `Contact Management System`, and this problem is focused on maintaining a person's name and mobile number in database.

The following architectural components for this application have already been provide as standard Java classes:

* `ContactController`: the controller class where you have to define REST endpoints for the POST and GET methods
* `ContactService`: the service class, expected to be used by the controller class to save/retrieve contacts to/from the repository
* `ContactRepository`: the repository class, expected to be used by the service class to save/retrieve contacts to/from the database
* `Person`: the model class to hold the contact information

You have two tasks:
1. Annotate these classes using appropriate Spring Boot stereotypes.
2. Define the following 4 REST endpoints in the controller class.

`POST` request to `/contact/save`
* expects a valid person data object as its body payload, except that it does not have an id property; you can assume that the given object is always valid
* adds the given object to the database and assigns a unique integer id to it
* the response code is 201 and the response body is the created record, including its unique id

`GET` request to `/contact/retrieve/{id}`
* the response code is 200 and the response body is the matching object
* expect that the requested id exists in the database

`DELETE` request to `/contact/delete/{id}`
* the response code is 202 Accepted and the response
* expect that the requested id exists in the database
* 
* 
  `UPDATE` request to `/contact/update/{id}`
* the response code is 202 Accepted and the response
* expect that the requested id exists in the database

You need to complete the given project so that it passes all the test cases when running the provided unit tests. The project by default supports the use of the H2 database.

## Commands
- run:
```bash
mvn clean package -DskipTests && java -jar target/tdd-1.0.jar
```
- install:
```bash
mvn clean install
```
- test:
```bash
mvn clean test
```