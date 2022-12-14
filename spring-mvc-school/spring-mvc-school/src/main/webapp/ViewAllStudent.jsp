<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table cellpadding="2" border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Age</th>
				<th>Gender</th>
				<th>Contact No</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="allStudent" items="${allstudents}">
			<tr>
				<th>${allStudent.getId()}</th>
				<th>${allStudent.getName()}</th>
				<th>${allStudent.getEmail()}</th>
				<th>${allStudent.getAge()}</th>
				<th>${allStudent.getGender()}</th>
				<th>${allStudent.getC_no()}</th>
				<th> <a href="editStudent?id= ${allStudent.getId()}">Edit</a> </th>
				<th> <a href="deleteStudent?id= ${allStudent.getId()}">Delete</a> </th>
			</tr>
			</c:forEach>
	</table>
</body>
</html>