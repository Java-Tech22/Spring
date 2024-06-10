 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>

<!DOCTYPE html>
<%-- <% List list = (List)request.getAttribute("myList");%> --%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${name}</title>
<link href="webjars/bootstrap/5.3.2/css/bootstrap.min.css"
    rel="stylesheet">

</head>
<body><h2 style="border:2px solid Tomato;"><p style="color:DodgerBlue;" align="center" >Your Items</p></h2>
<div class="container">
<table class="table table-striped">
<thead>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Description</th>
    <th>Date</th>
  </tr>
</thead>
<tbody>
    <c:forEach items="${myList}" var="l">
        <tr>
            <td><c:out value="${l.id}"/></td>
            <td><c:out value="${l.name}"/></td>
            <td><c:out value="${l.desc}"/></td>
            <td><c:out value="${l.date}"/></td> 
            <td>
	            <a class="btn btn-success" href="add">Add</a>
	           <a class="btn btn-success" href="modify">Update</a>
	           <a class="btn btn-danger" href="delete">Delete</a>
            </td> 
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<!--  <div class="container"> -->
<!-- <a class="button" href="/add">Add</a> -->
<!-- <a class="button" href="springmvc/modify">Modify</a> -->
<!-- <a class="button" href="springmvc/delete">Delete</a> -->
<!-- </div> -->

<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
<script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>

</body>
</html>