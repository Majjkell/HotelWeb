<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Wybor Pokoju</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
<c:forEach items="${rooms}" var="r">
    <%--        <section>--%>
    <table class="table table-bordered">
        <tr>
            <th>Number Of People:</th>
            <td><c:out value="${r.numOfPpl}"/></td>
        </tr>
        <tr>
            <th>Price:</th>
            <td><c:out value="${r.price}"/></td>
        </tr>
        <tr>
            <th>Rating:</th>
            <td><c:out value="${r.rating}"/></td>
        </tr>
        <tr>
            <th>Room Number:</th>
            <td><c:out value="${r.numberOfRoom}"/></td>
        </tr>
        <tr>
            <th>Conference Room:</th>
            <td><c:out value="${r.conferenceRoom}"/></td>
        </tr>
        <tr>
            <th>Room Type:</th>
            <td><c:out value="${r.typeRoom}"/></td>
        </tr>
        <tr>
            <th>Additional Informations:</th>
            <td><c:out value="${r.addInfo}"/></td>
        </tr>
        <tr>
            <th colspan="2" ><a href="/reservation/${r.numberOfRoom}" class="rp">Reserv</a></th>
    </table>
    <%--        </section>--%>
</c:forEach>
</body>
</html>
