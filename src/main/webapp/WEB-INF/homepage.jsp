<%--suppress XmlPathReference --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">


    <title>Title</title>
</head>
<body>

<c:import url="fragments/header.jsp"/>

<br>
<h3 style="margin-left: 5%">Current orders</h3>
<c:forEach var="map" items="${requestScope.ordersMap}">
    <table class="table table-hover" style="width: 90%; margin-right: 5%; margin-left: 5%">
        <thead>
        <tr>
            <th scope="col" style="width: 10%">#Id ${map.key.id}</th>
            <th scope="col" colspan="2" style="width: 90%">${map.key.name} ${map.key.surname}</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${map.value}">
            <tr>
                <th scope="row" style="width: 10%">${order.id}</th>
                <td style="width: 80%">${order.problemDescription}</td>
                <td style="width: 10%"><a href="/order?id=${order.id}" class="btn btn-primary">Details</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:forEach>

<%--<c:forEach var="map" items="${requestScope.ordersMap}">--%>
    <%--<table class="table table-bordered thead-light">--%>
        <%--<th scope="col">#</th>--%>
        <%--<th scope="col">Id. ${map.key.id}</th>--%>
        <%--<th scope="col">${map.key.name} ${map.key.surname}</th>--%>
            <%--<tr>--%>
            <%--<table class="table table-bordered">--%>

        <%--<c:forEach var="order" items="${map.value}">--%>
            <%--<tr>--%>
                <%--<td>Id. ${order.id}</td>--%>
                <%--<td>${order.problemDescription}</td>--%>
                <%--<td><a href="/orders?id=${order.id}" class="btn btn-primary">Details</a></td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>

            <%--</table>--%>
            <%--</tr>--%>
    <%--</table>--%>
<%--</c:forEach>--%>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
        integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>
</body>
</html>
