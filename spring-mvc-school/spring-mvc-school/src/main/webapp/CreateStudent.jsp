<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="saveStudent" modelAttribute="student" method="post">
		Name: <form:input path="name"/><br>
		Email: <form:input path="email"/><br>
		Age: <form:input path="age"/><br>
		Gender: <form:input path="gender"/><br>
		Contact no: <form:input path="c_no"/><br>
		
		<form:button>Register</form:button>
	</form:form>
</body>
</html>