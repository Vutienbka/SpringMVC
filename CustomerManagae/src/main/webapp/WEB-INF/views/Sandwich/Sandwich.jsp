<%--
  Created by IntelliJ IDEA.
  User: vutienbka
  Date: 3/22/20
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
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
    <style>
        .checkbox{
            width: 18px;
            height: 18px;
        }
        .checkbox:hover{
            background-color: #2196F3;
            color: white;
        }
    </style>
</head>
<body>
<div class="container" style="background: #cccccc">
    <div style="position: relative; text-align: center; margin-top: 15px">
<form action="${pageContext.request.contextPath}/save/spice" method="post" style="font-size: 20px">
    <label> Lettuce</label>
    <input type="checkbox" name="condiment" value="lettuce" class="checkbox">
    <label> Tomato</label>
    <input type="checkbox" name="condiment" value="tomato" class="checkbox">
    <label> Mustard</label>
    <input type="checkbox" name="condiment" value="mustard" class="checkbox">
    <label> Spouts</label>
    <input type="checkbox" name="condiment" value="sprouts" class="checkbox">
    <br>
    <button type="submit" class="btn btn-primary">Save</button>
</form>
    </div>
</div>
</body>
</html>
