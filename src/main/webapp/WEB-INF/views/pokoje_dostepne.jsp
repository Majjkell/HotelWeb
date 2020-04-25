<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Wybor Pokoju</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
    <c:forEach items="${rooms}" var="r">
        <section>
            <button style="cursor: default;" class="btn btn-secondary">Number Of People:</button><button type="button" class="btn btn-success"><c:out value="${r.numOfPpl}"/></button> <br>
            <button style="cursor: default;" class="btn btn-secondary">Price:</button><button type="button" class="btn btn-success"><c:out value="${r.price}"/></button> <br>
            <button style="cursor: default;" class="btn btn-secondary">Rating:</button><button type="button" class="btn btn-success"> <c:out value="${r.rating}"/></button><br>
            <button style="cursor: default;" class="btn btn-secondary">Room Number:</button><button type="button" class="btn btn-success"> <c:out value="${r.numberOfRoom}"/></button><br>
            <button style="cursor: default;" class="btn btn-secondary">Conference Room:</button><button type="button" class="btn btn-success"> <c:out value="${r.conferenceRoom}"/></button><br>
            <button style="cursor: default;" class="btn btn-secondary">Room Type:</button><button type="button" class="btn btn-success"> <c:out value="${r.typeRoom}"/></button><br>
            <button style="cursor: default;" class="btn btn-secondary">Additional Informations:</button><button type="button" class="btn btn-success"><c:out value="${r.addInfo}"/></button><br>
            <a href="/reservation/${r.numberOfRoom}" class="rp">Reserv</a>
        </section>
    </c:forEach>
</body>
</html>
