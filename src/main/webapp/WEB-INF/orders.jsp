<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<table class="table table-hover" style="width: 90%; margin-right: 5%; margin-left: 5%">
    <thead>
    <tr>
        <th scope="col" style="width: 5%">#Id</th>
        <th scope="col" style="width: 5%">Order status</th>
        <th scope="col" style="width: 80%">Problem description</th>
        <th scope="col" style="width: 10%">Details</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orders}">
        <tr>
            <th scope="row" style="width: 5%">${order.id}</th>
            <th scope="row" style="width: 15%">
                <c:choose>
                    <c:when test="${order.statusId==1}">In service</c:when>
                    <c:when test="${order.statusId==2}">Accepted costs</c:when>
                    <c:when test="${order.statusId==3}">Maintenance activities in progress</c:when>
                    <c:when test="${order.statusId==4}">Ready for collection</c:when>
                    <c:otherwise>Error</c:otherwise>
                </c:choose>
            </th>
            <td style="width: 70%">${order.problemDescription}</td>
            <td style="width: 10%"><a href="/order?id=${order.id}" class="btn btn-primary">Select</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


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
