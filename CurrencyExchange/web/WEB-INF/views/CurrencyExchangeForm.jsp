<%--
  Created by IntelliJ IDEA.
  User: vutienbka
  Date: 3/19/20
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div id = "editForm" class="container-sm" style="border: 1px solid #cccccc; background: #f2f2f2; width: 700px; position: relative;top: 0px">
    <div class="panel-group" style="margin: 0 auto">
        <div class="panel panel-primary"  >
            <div class="panel-heading" >
                <h3 class="panel-title" style="text-align: center; margin-top: 20px; color: blue">Currency Exchange Form</h3>
                <p style="color: red"> ${message}</p>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" action="${pageContext.request.contextPath}/showCurrencyExchangeFormAfterCalculate" >
                    <div class="form-group">
                        <label class="control-label" >USD</label>
                        <input type="text" name="usd"  value="${usd}" class="form-control" placeholder="usd">
                    </div>
                    <div class="form-group">
                        <label class="control-label"  >Rate</label>
                        <input type="text" name="rate"  value="${rate}" class="form-control" placeholder="Rate">
                    </div>

                    <div class="form-group">
                        <label class="control-label"  >Viet Nam Dong</label>
                        <input type="text" name="vietnamDong"  class="form-control" value="${result}" placeholder="VietnamDong">
                    </div>

                    <div class="form-group">
                        <button type="submit" id="save" class="btn btn-success" style="width: 120px">Calculate</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
