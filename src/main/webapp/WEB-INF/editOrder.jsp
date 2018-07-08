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
    <title>Car service - edit order</title>
</head>
<body>
<c:import url="fragments/header.jsp"/>
<br>
<div class="card" style="margin-left: 5%; margin-right: 5%">
    <div class="card-header">
        Order #Id ${order.id} - Edit </a>
    </div>
    <div class="card-body">
        <h5 class="card-title">Order details</h5>
        <p class="card-text">
        <form action="/editOrder" method="post">
            <input type="hidden" id="orderId" name="orderId" value="${order.id}">
            <input type="hidden" id="vehicleId" name="vehicleId" value="${vehicle.id}">
            <input type="hidden" id="acceptance" name="acceptance" value="${order.acceptance}">
            <div class="form-group row">
                <label for="statusId" class="col-2 col-form-label">Status #Id:</label>
                <div class="col-10">
                    <input class="form-control" type="number" min="1" max="6" value="${order.statusId}" id="statusId"
                           name="statusId">
                    <small id="statusIdHelp" class="form-text text-muted">1 - In service | 2 - Accepted costs | 3 -
                        Maintenance activities in progress | 4 - Ready for
                        collection | 5 - Cancelled | 6 - Finished
                    </small>
                </div>
            </div>
            <div class="form-group row">
                <label for="vehicle" class="col-2 col-form-label">Vehicle:</label>
                <div class="col-10">
                    <input class="form-control" type="text"
                           value="#Id ${vehicle.id} - ${vehicle.brand} ${vehicle.model}" id="vehicle" name="vehicleId"
                           disabled>
                </div>
            </div>
            <div class="form-group row">
                <label for="problemDescription" class="col-2 col-form-label">Problem description:</label>
                <div class="col-10">
                    <textarea class="form-control" type="text"
                              id="problemDescription" name="problemDescription">${order.problemDescription}</textarea>
                </div>
            </div>
            <div class="form-group row">
                <label for="orderAcceptance" class="col-2 col-form-label">Order acceptance:</label>
                <div class="col-10">
                    <input class="form-control" type="text" value="${order.acceptance}" id="orderAcceptance"
                           name="orderAcceptance" disabled>
                </div>
            </div>
            <div class="form-group row">
                <label for="plannedMaintenance" class="col-2 col-form-label">Planned maintenance:</label>
                <div class="col-10">
                    <input class="form-control" type="datetime-local" placeholder="YYYY/MM/DD 00:00:00"
                           value="${order.plannedMaintenance}" id="plannedMaintenance" name="plannedMaintenance">
                </div>
            </div>
            <div class="form-group row">
                <label for="maintenanceStart" class="col-2 col-form-label">Maintenance start date:</label>
                <div class="col-10">
                    <input class="form-control" type="datetime-local" placeholder="YYYY/MM/DD 00:00:00"
                           value="${order.maintenanceStart}" id="maintenanceStart" name="maintenanceStart">
                </div>
            </div>


            <div class="form-group row">
                <label for="employeeId" class="col-2 col-form-label">Employee select:</label>
                <div class="form-group">

                    <div class="form-check">
                        <c:forEach var="employees" items="${employees}">
                            <c:if test="${employees.id != employee.id}">
                                <div class="form-check form-check-inline">
                                    <label class="form-check-label" for="employeeId">
                                        <input class="form-check-input" type="radio" id="employeeId" name="employeeId"
                                               value="${employees.id}">
                                        #Id ${employees.id}
                                        - ${employees.name} ${employees.surname}
                                    </label>
                                </div>
                            </c:if>
                            <c:if test="${employees.id == employee.id}">
                                <div class="form-check form-check-inline">
                                    <label class="form-check-label" for="employeeId">
                                        <input class="form-check-input" type="radio" id="employeeId" name="employeeId"
                                               value="${employees.id}" checked>
                                        #Id ${employees.id}
                                        - ${employees.name} ${employees.surname}
                                    </label>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="maintenaceDescription" class="col-2 col-form-label">Maintenance description:</label>
                <div class="col-10">
                    <textarea class="form-control" type="text"
                              id="maintenaceDescription"
                              name="maintenaceDescription">${order.maintenaceDescription}</textarea>
                </div>
            </div>
            <div class="form-group row">
                <label for="totalPrice" class="col-2 col-form-label">Total price:</label>
                <div class="col-10">
                    <input class="form-control" type="number" step="0.01" min="0.01" value="${order.totalPrice}"
                           id="totalPrice" name="totalPrice">
                </div>
            </div>
            <div class="form-group row">
                <label for="partsCost" class="col-2 col-form-label">Parts cost:</label>
                <div class="col-10">
                    <input class="form-control" type="number" step="0.01" min="0.01" value="${order.partsCost}"
                           id="partsCost" name="partsCost">
                </div>
            </div>
            <div class="form-group row">
                <label for="hoursAmount" class="col-2 col-form-label">Maintenance time:</label>
                <div class="col-10">
                    <input class="form-control" type="number" min="1" value="${order.hoursAmount}"
                           id="hoursAmount" name="hoursAmount">
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
