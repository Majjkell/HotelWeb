<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="guest" method="POST">
    <form:hidden path="id"/>
    First Name: <form:input path="first_name"/>
    Last Name: <form:input path="last_name"/>
<%--    Date Of Birth: <form:input path="date_of_birth"/>--%>
    Mail: <form:input path="mail"/>
    Phone: <form:input path="phone"/>
    Add Info <form:textarea path="add_info"/>
    Password <form:input path="password"/>
    <form:hidden path="verified"/>
    <input type="submit" value="Submit">
</form:form>

</body>
</html>
