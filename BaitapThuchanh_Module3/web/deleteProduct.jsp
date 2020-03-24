<%--
  Created by IntelliJ IDEA.
  User: vutienbka
  Date: 3/17/20
  Time: 11:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/NewCss.css">
    <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
</head>
<body>
<div class="container">
    <form method="post" style="position: relative; margin-top: 30px; color: red">
        <table class="table table-bordered table-striped" style="text-align: center">
            <p>Do you want to delete ?</p>
            <p style="color: blue" ><a href="${pageContext.request.contextPath}/">back to product page<<</a></p>
            <div class="card-body" style="margin: 0; padding: 0">
                <thead>
                <tr>
                    <th>ProductId</th>
                    <th>ProductName</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Color</th>
                    <th>Description</th>
                    <th>Categorize</th>
                    <th>Action</th>
                </tr>
                <tr>
                    <td>${product.getProductId()}</td>
                    <td>${product.getProductName()}</td>
                    <td>${product.getPrice()}</td>
                    <td>${product.getQuantity()}</td>
                    <td>${product.getColor()}</td>
                    <td>${product.getDescription()}</td>
                    <td>${product.getCategorize()}</td>
                    <td>
                        <button class="btn btn-primary">Delete</button>
                    </td>
                </tr>

                </thead>
            </div>
        </table>
    </form>
</div>
</body>
</html>
