<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="#">Car Service</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/orders" id="navbarDropdownOrdersLink" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Orders
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownOrdersLink">
                    <a class="dropdown-item" href="/orders">Current orders</a>
                    <a class="dropdown-item" href="/addOrder">Add order</a>
                    <a class="dropdown-item" href="/ordersHistory">Orders history</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/customers" id="navbarDropdownCustomersLink" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Customers
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownVehiclesLink">
                    <a class="dropdown-item" href="/customers">Customer list</a>
                    <a class="dropdown-item" href="/customerAdd">Add customer</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/vehicles" id="navbarDropdownVehiclesLink" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Vehicles
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownVehiclesLink">
                    <a class="dropdown-item" href="/vehicles">Vehicle list</a>
                    <a class="dropdown-item" href="/addVehicle">Add vehicle</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/employees" id="navbarDropdownEmployeesLink" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Employees
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownVehiclesLink">
                    <a class="dropdown-item" href="/employees">Employee list</a>
                    <a class="dropdown-item" href="/employeeAdd">Add Employee</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/raports" id="navbarDropdownMenuLink" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Raports
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="/raport1">Raport 1</a>
                    <a class="dropdown-item" href="/raport2">Raport 2</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
</header>
