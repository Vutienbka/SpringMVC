<%--
  Created by IntelliJ IDEA.
  User: vutienbka
  Date: 3/22/20
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Detail</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/NewCss.css">
    <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
    <script src="src/js/jquery.js"></script>
    <script src="src/js/bootstrap.js"></script>
</head>
<body>
<div class="container">
    <table class="table table-bordered">
        <tr>
            <th>CustomerId</th>
            <th>CustomerName</th>
            <th>CustomerEmail</th>
            <th>CustomerAddress</th>
            <th>CustomerDateOfBirth</th>
        </tr>
        <tbody>
            <tr>
                <td><c:out value="${customer.getCustomerId()}"></c:out></td>
                <td><c:out value="${customer.getCustomerName()}"></c:out></td>
                <td><c:out value="${customer.getCustomerEmail()}"></c:out></td>
                <td><c:out value="${customer.getCustomerAddress()}"></c:out></td>
                <td><c:out value="${customer.getCustomerDateOfBirth()}"></c:out></td>
            </tr>
        </tbody>

    </table>
</div>
</body>
</html>
