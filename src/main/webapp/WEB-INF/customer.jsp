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

<div class="card" style="margin-left: 5%; margin-right: 5%">
    <div class="card-header">
        Employee #Id ${employee.id}
    </div>
    <div class="card-body">
        <h5 class="card-title">Employee details</h5>
        <p class="card-text">
        <table class="table" style="width: 90%; margin-right: 5%; margin-left: 5%">
            <tbody>

            <tr><td style="width: 30%">Name:</td><td style="width: 70%"> ${employee.name}</td></tr>
            <tr><td style="width: 30%">Surname:</td><td style="width: 70%">${employee.surname}</td></tr>
            <tr><td style="width: 30%">Address:</td><td style="width: 70%">${employee.address}</td></tr>
            <tr><td style="width: 30%">Phone:</td><td style="width: 70%">${employee.phone}</td></tr>
            <tr><td style="width: 30%">Email:</td><td style="width: 70%">${employee.email}</td></tr>
            <tr><td style="width: 30%">Birth date:</td><td style="width: 70%">${employee.birthDate}</tr>
            <tr><td style="width: 30%">Hourly:</td><td style="width: 70%">${employee.hourly}</td></tr>
            <tr><td style="width: 30%">Note:</td><td style="width: 70%">${employee.note}</td></tr>
            <tr><td style="width: 10%"><a href="/employeeorders?id=${employee.id}&actual=false" class="btn btn-primary">all orders</a></td></tr>
            <tr><td style="width: 10%"><a href="/employeeorders?id=${employee.id}&actual=true" class="btn btn-primary">actual orders</a></td></tr>
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
