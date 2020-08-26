<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pokoje</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%@ include file="nav.jsp" %>
<section class="form" >
    <p>Dane szukanego pokoju</p>
    <form:form modelAttribute="reservation" action="/roomChoose" method="POST">
        <div class="form-group">
            <button style="cursor: default;" class="btn btn-success">Number Of People:</button><form:input class="form-control" type="number" path="numOfPpl"/>
        </div>
        <div class="form-group">
            <button style="cursor: default;" class="btn btn-success">Stay From:</button><form:input class="form-control" type="date" pattern="yyyy-MM-dd" path="dateFrom"/>
        </div>
        <div class="form-group">
            <button style="cursor: default;" class="btn btn-success">Stay To:</button><form:input class="form-control" type="date" pattern="yyyy-MM-dd" path="dateTo"/>
        </div>
        <div class="form-group">
            <button style="cursor: default;" class="btn btn-success">Room Type:</button><form:select class="form-control" path="roomType" items="${type}"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-danger">Submit</button>
        </div>
    </form:form>


</section>
<%--    <c:forEach items="${rooms1}" var="rt">--%>
<%--        <section class="s2">--%>
<%--        <p class="num_of_ppl_t">Liczba osob: 2-4</p>--%>
<%--        <p class="type_room_t">Typ Pokoju: <c:out value="${rt.add_info}"/></p>--%>
<%--        <p class="price_t">Cena Pokoju Od: <c:out value="${rt.price}"/></p>--%>
<%--        </section>--%>
<%--    </c:forEach>--%>
<%@ include file="roomsAvailable.jsp" %>
</body>
</html>
