<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">

    <%@ include file="nav.jsp" %>
</head>
<body>
<form:form modelAttribute="guest" action="/submit" method="POST">
    <form:hidden path="id"/>
    <button style="cursor: default;" class="btn btn-success">First Name:</button><form:input path="firstName"/>
    <button style="cursor: default;" class="btn btn-success">Last Name:</button><form:input path="lastName"/>
    <button style="cursor: default;" class="btn btn-success">Date Of Birth:</button><form:input type="Date" pattern="yyyy-MM-dd" path="dateOfBirth"/>
    <button style="cursor: default;" class="btn btn-success">Mail:</button><form:input path="mail"/>
    <button style="cursor: default;" class="btn btn-success">Phone:</button><form:input path="phone"/>
    <button style="cursor: default;" class="btn btn-success">Add Info</button><form:textarea path="addInfo" rows="3" cols="20"/>
    <button style="cursor: default;" class="btn btn-success">Password</button><form:input type="password" path="password"/>
    <form:hidden path="verified" value="true" />
    <form:hidden path="online" value="1" />
    <button type="submit" class="btn btn-danger">Submit</button>
</form:form>

</body>
</html>
