<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</head>
<body>
    <p> DANE DOTYCZACE REZERWACJI</p>
    Nr pokoju<c:out value="${reservation.room.number}"/>
    Liczba osob: <c:out value="${reservation.num_of_ppl}"/>
    Od kiedy: <c:out value="${reservation.date_from}"/>
    Do Kiedy: <c:out value="${reservation.date_to}"/>
    Dodatkowe informacje: <input type="text"name="add_info">
    Typ pokoju: <c:out value="${reservation.room_type}"/>
    <a href="/submit">submit</a>

</body>
</html>
