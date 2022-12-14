<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="updateStudent" modelAttribute="editStudent" method="post">
		Id:<form:input path="id" readonly="true"/><br><br>
		Name: <form:input path="name"/><br><br>
		Email: <form:input path="email"/><br><br>
		Age: <form:input path="age"/><br><br>
		Gender: <form:input path="gender"/><br><br>
		Contact no: <form:input path="c_no"/><br><br>
		<form:button>Submit</form:button>
	</form:form>
</body>
</html>