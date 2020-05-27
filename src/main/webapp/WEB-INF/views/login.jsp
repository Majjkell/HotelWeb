<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%@ include file="nav.jsp" %>
<form action="/login" method="POST">
    <div class="form-group">
        <button type="label"   class="btn btn-success">First Name:</button>
        <input class="form-control" placeholder="First Name" name="firstName"/>
    </div>
    <div class="form-group">
        <button style="cursor: default;" class="btn btn-success">Password:</button>
        <input class="form-control" type="password" placeholder="Password" name="password"/>
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-danger">Submit</button>
    </div>
</form>

</body>
</html>
