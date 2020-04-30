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
        <tr class="bg-dark">
            <th class="bg-success">Number Of People:</th>
            <td class="bg-success"><c:out value="${r.numOfPpl}"/></td>
        </tr>
        <tr class="bg-dark">
            <th class="bg-success">Price:</th>
            <td class="bg-success"><c:out value="${r.price}"/></td>
        </tr>
        <tr class="bg-dark">
            <th class="bg-success">Rating:</th>
            <td class="bg-success"><c:out value="${r.rating}"/></td>
        </tr>
        <tr class="bg-dark">
            <th class="bg-success">Room Number:</th>
            <td class="bg-success"><c:out value="${r.numberOfRoom}"/></td>
        </tr>
        <tr class="bg-dark">
            <th class="bg-success">Conference Room:</th>
            <td class="bg-success"><c:out value="${r.conferenceRoom}"/></td>
        </tr>
        <tr class="bg-dark">
            <th class="bg-success">Room Type:</th>
            <td class="bg-success"><c:out value="${r.typeRoom}"/></td>
        </tr>
        <tr class="bg-dark">
            <th class="bg-success">Additional Informations:</th>
            <td class="bg-success"><c:out value="${r.addInfo}"/></td>
        </tr>
        <tr class="bg-dark">
            <th class="bg-success" colspan="2" ><a href="/reservation/${r.numberOfRoom}" class="rp">Reserv</a></th>
    </table>
    <%--        </section>--%>
</c:forEach>
</body>
</html>
