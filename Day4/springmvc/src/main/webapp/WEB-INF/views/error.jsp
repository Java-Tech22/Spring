<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String message = (String)request.getAttribute("message"); %>
<h4><%=message %></h4>
<jsp:include page="/index.jsp"></jsp:include>
</body>
</html>