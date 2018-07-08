<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Car service - edit vehicle</title>
</head>
<body>
<c:import url="fragments/header.jsp"/>
<br>
<div class="card" style="margin-left: 5%; margin-right: 5%">
    <div class="card-header">
        Vehicle #Id ${vehicle.id} - Edit </a>
    </div>
    <div class="card-body">
        <h5 class="card-title">Vehicle details</h5>
        <p class="card-text">
        <form action="/editVehicle" method="post">
            <input type="hidden" id="id" name="id" value="${vehicle.id}">
            <input type="hidden" id="brand" name="brand" value="${vehicle.brand}">
            <input type="hidden" id="model" name="model" value="${vehicle.model}">
            <input type="hidden" id="productionYear" name="productionYear" value="${vehicle.productionYear}">
            <div class="form-group row">
                <label for="br" class="col-2 col-form-label">Brand:</label>
                <div class="col-10">
                    <input class="form-control" type="text"
                           value="${vehicle.brand}" id="br" name="br"
                           disabled>
                </div>
            </div>
            <div class="form-group row">
                <label for="mod" class="col-2 col-form-label">Model:</label>
                <div class="col-10">
                    <input class="form-control" type="text"
                           value="${vehicle.model}" id="mod" name="mod"
                           disabled>
                </div>
            </div>
            <div class="form-group row">
                <label for="reg" class="col-2 col-form-label">Registration Number:</label>
                <div class="col-10">
                    <input class="form-control" type="text"
                           value="${vehicle.registrationNumber}" id="reg" name="reg"
                           disabled>
                </div>
            </div>
            <div class="form-group row">
                <label for="production" class="col-2 col-form-label">Production Year:</label>
                <div class="col-10">
                    <input class="form-control" type="text"
                           value="${vehicle.productionYear}" id="production" name="production"
                           disabled>
                </div>
            </div>
            <div class="form-group row">
                <label for="nextService" class="col-2 col-form-label">Next service:</label>
                <div class="col-10">
                    <input class="form-control" type="date" placeholder="YYYY/MM/DD"
                           value="${vehicle.nextService}" id="nextService" name="nextService">
                </div>
            </div>
            <div class="form-group row">
                <label for="customerId" class="col-2 col-form-label">Customer:</label>
                <div class="form-group">
                    <div class="form-check">
                        <c:forEach var="customers" items="${customers}">
                            <c:if test="${customers.id != customer.id}">
                                <div class="form-check form-check-inline">
                                    <label class="form-check-label" for="customerId">
                                        <input class="form-check-input" type="radio" id="customerId" name="customerId"
                                               value="${customers.id}">
                                        #Id ${customers.id}
                                        - ${customers.name} ${customers.surname}
                                    </label>
                                </div>
                            </c:if>
                            <c:if test="${customers.id == customer.id}">
                                <div class="form-check form-check-inline">
                                    <label class="form-check-label" for="customerId">
                                        <input class="form-check-input" type="radio" id="customerId" name="customerId"
                                               value="${customers.id}" checked>
                                        #Id ${customers.id}
                                        - ${customers.name} ${customers.surname}
                                    </label>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <input type="submit" class="btn btn-primary"/>
        </form>
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
