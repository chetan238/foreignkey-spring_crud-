<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<table border="1px solid black">

<tr>
	<th>ID </th>
	<th>First Name </th>
	<th>Last Name</th>
	<th>User Name</th>
	<th>Password</th>
	<th>Action</th>
</tr>

<c:forEach items="${search}" var="a">
<tr>
	<td>${a.id}</td>
	<td>${a.fn}</td>
	<td>${a.ln}</td>
	<td>${a.lv.un}</td>
	<td>${a.lv.pwd}</td>
	<td><a href="delete.html?delete_id=${a.id} &id_login=${a.lv.id}">delete /</a>&nbsp;&nbsp;<a href="edit.html?edit_id=${a.id}">edit </a></td>
	
</tr>
</c:forEach>
</body>
</html>