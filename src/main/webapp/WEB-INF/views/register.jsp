<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">--%>
    <%--    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>--%>
    <link rel="stylesheet" href="css/style.css">

    <%@ include file="nav.jsp" %>
</head>
<body>
<form:form modelAttribute="guest" method="POST">
    <form:hidden path="id"/>
    First Name: <form:input path="first_name"/>
    Last Name: <form:input path="last_name"/>
    Date Of Birth: <form:input type="Date" pattern="yyyy-MM-dd" path="date_of_birth"/>
    Mail: <form:input path="mail"/>
    Phone: <form:input path="phone"/>
    Add Info <form:textarea path="add_info"/>
    Password <form:input type="password" path="password"/>
    <form:hidden path="verified" value="true" />
    <form:hidden path="online" value="1" />
    <input type="submit" value="Submit">
</form:form>

</body>
</html>
