<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action="/add" method="POST">
    	Item Name : <input name="name" type="text" />
        Item Description : <input name="desc" type="text" />
        <input type="submit" value="add"/>
    </form>
</body>
</html>