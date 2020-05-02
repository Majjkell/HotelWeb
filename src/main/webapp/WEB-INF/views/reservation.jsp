<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>

</head>
<body>
<table class="table table-bordered">
    <tr>
        <th colspan="2">DANE DOTYCZACE REZERWACJI</th>
    </tr>
    <tr>
        <th>Nr pokoju:</th>
        <td><c:out value="${reservation.room.numberOfRoom}"/></td>
    </tr>
    <tr>
        <th>Liczba osob:</th>
        <td><c:out value="${reservation.numOfPpl}"/></td>
    </tr>
    <tr>
        <th>Od kiedy:</th>
        <td><c:out value="${reservation.dateFrom}"/></td>
    </tr>
    <tr>
        <th>Do Kiedy:</th>
        <td><c:out value="${reservation.dateTo}"/></td>
    </tr>
    <tr>
        <th>Cena:</th>
        <td><c:out value="${reservation.room.price}"/></td>
    </tr>
    <form action="/submit" method="GET">
        <tr>
            <th>Dodatkowe informacje:</th>
            <td><input type="text" name="addInfo"></td>
        </tr>
        <tr>
            <th>Typ pokoju:</th>
            <td><c:out value="${reservation.roomType}"/></td>
        </tr>
        <tr>
            <th colspan="2"><button type="submit" class="btn btn-primary">Submit</button></th>
        </tr>
    </form>

</table>
</body>
</html>
