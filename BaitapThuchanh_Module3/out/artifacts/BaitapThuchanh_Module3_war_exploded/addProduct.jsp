<%--
  Created by IntelliJ IDEA.
  User: vutienbka
  Date: 3/17/20
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
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
    <p style="color: blue"><a href="${pageContext.request.contextPath}/">back to product page<<</a></p>
    <div class="panel-body" style="width: 700px; padding: 20px 20px; background: #cccccc">
        <div class="panel panel-primary"  >
            <form method="post" class="form-horizontal">
                <div class="form-group">
                    <label class="control-label">ProductId</label>
                    <input class="form-control" type="text" name="productId" >
                </div>
                <div class="form-group">
                    <label class="control-label">ProductName</label>
                    <input class="form-control" type="text" name="productName" value="${product.getProductName()}" placeholder="${product.getProductName()}">
                </div>
                <div class="form-group">
                    <label class="control-label">Price</label>
                    <input class="form-control" type="text" name="price" placeholder="${product.getPrice()}">
                </div>
                <div class="form-group">
                    <label class="control-label">Quantity</label>
                    <input class="form-control" type="text" name="quantity" placeholder="${product.getQuantity()}">
                </div>
                <div class="form-group">
                    <label class="control-label">Color</label>
                    <input class="form-control" type="text" name="color" placeholder="${product.getColor()}">
                </div><div class="form-group">
                <label class="control-label">Description</label>
                <input class="form-control" type="text" name="description" placeholder="${product.getDescription()}">
            </div><div class="form-group">
                <label class="control-label">Categorize</label>
                <input class="form-control" type="text" name="categorize" placeholder="${product.getCategorize()}">
            </div>
                <input type="submit" value="Save">
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>
