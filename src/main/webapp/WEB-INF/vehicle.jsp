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
        function goBack() {
            window.history.back()
        }
    </script>

    <title>Car service - vehicle details</title>
</head>
<body>

<c:import url="fragments/header.jsp"/>

<br>

<div class="card" style="margin-left: 5%; margin-right: 5%">
    <div class="card-header">
        Vehicle #Id ${vehicle.id} <a href="/editVehicle?id=${vehicle.id}" style="float: right;" class="btn btn-primary">Edit
        vehicle</a>
    </div>
    <div class="card-body">
        <h5 class="card-title">Vehicle details</h5>
        <p class="card-text">
        <table class="table" style="width: 90%; margin-right: 5%; margin-left: 5%">
            <tbody>
            <tr>
                <td style="width: 30%">Brand:</td>
                <td style="width: 70%">${vehicle.brand}</td>
            </tr>
            <tr>
                <td style="width: 30%">Model:</td>
                <td style="width: 70%">${vehicle.model}</td>
            </tr>
            <tr>
                <td style="width: 30%">Registration number:</td>
                <td style="width: 70%">${vehicle.registrationNumber}</td>
            </tr>
            <tr>
                <td style="width: 30%">Production year:</td>
                <td style="width: 70%">${vehicle.productionYear}</td>
            </tr>
            <tr>
                <td style="width: 30%">Next service:</td>
                <td style="width: 70%">${vehicle.nextService}</td>
            </tr>
            <tr>
                <td style="width: 30%">Customer:</td>
                <td style="width: 70%">#Id ${customer.id} - ${customer.name} ${customer.surname}</td>
            </tr>
            </tbody>
        </table>


        </p>
        <a href="/vehicleHistory?id=${vehicle.id}" class="btn btn-primary">Check vehicle's repair history</a>
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
