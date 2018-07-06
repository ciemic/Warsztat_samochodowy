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
    <script>
        function goBack()
        {
            window.history.back()
        }
    </script>

    <title>Title</title>
</head>
<body>

<c:import url="fragments/header.jsp"/>

<br>

<div class="card" style="margin-left: 5%; margin-right: 5%">
    <div class="card-header">
        Order #Id ${order.id} <a href="/editOrder?id=${order.id}" style="float: right;" class="btn btn-primary">Edit order</a>
    </div>
    <div class="card-body">
        <h5 class="card-title">Order details</h5>
        <p class="card-text">
        <table class="table" style="width: 90%; margin-right: 5%; margin-left: 5%">
            <tbody>
            <tr>
                <td style="width: 30%">Status:</td>
                <td style="width: 70%">
                    <c:choose>
                        <c:when test="${order.statusId==1}">In service</c:when>
                        <c:when test="${order.statusId==2}">Accepted costs</c:when>
                        <c:when test="${order.statusId==3}">Maintenance activities in progress</c:when>
                        <c:when test="${order.statusId==4}">Ready for collection</c:when>
                        <c:otherwise>Error</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr><td style="width: 30%">Vehicle:</td><td style="width: 70%">#Id ${vehicle.id} - ${vehicle.brand} ${vehicle.model}   <a href="/vehicle?id=${vehicle.id}" class="btn btn-secondary btn-sm">Details</a></td></tr>
            <tr><td style="width: 30%">Problem description:</td><td style="width: 70%">${order.problemDescription}</td></tr>
            <tr><td style="width: 30%">Order acceptance:</td><td style="width: 70%">${order.acceptance}</td></tr>
            <tr><td style="width: 30%">Planned maintenance:</td><td style="width: 70%">${order.plannedMaintenance}</td></tr>
            <tr><td style="width: 30%">Maintenance start date:</td><td style="width: 70%">${order.maintenanceStart}</td></tr>
            <tr><td style="width: 30%">Employee</td><td style="width: 70%">#Id ${employee.id} - ${employee.name} ${employee.surname}   <a href="/employee?id=${employee.id}" class="btn btn-secondary btn-sm">Details</a></td></tr>
            <tr><td style="width: 30%">Maintenance description:</td><td style="width: 70%">${order.maintenaceDescription}</td></tr>
            <tr><td style="width: 30%">Total price:</td><td style="width: 70%">${order.totalPrice}</td></tr>
            <tr><td style="width: 30%">Parts cost</td><td style="width: 70%">${order.partsCost}</td></tr>
            <tr><td style="width: 30%">Maintenance time</td><td style="width: 70%">${order.hoursAmount}</td></tr>
            </tbody>
        </table>


        </p>
        <button onclick="goBack()" class="btn btn-primary">Previous page</button>
    </div>
</div>

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
