<%--
  Created by IntelliJ IDEA.
  User: vutienbka
  Date: 3/22/20
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
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
    <h3>Calculator</h3>
    <!--<form action="${pageContext.request.contextPath}/calculator/result" method="post"> -->
    <form action="${pageContext.request.contextPath}flashAttribute/result" method="get">
        <input name="operand1" type="text" value="${operand1}" style="width: 200px">
        <input name="operand2" type="text" value="${operand2}" style="width: 200px">
        <span>=<input name="result" type="text" value="${result}" style="width: 200px"></span>
        <br>
        <br>
        <button type="submit"  name="operator" value="+" style="width: 150px">Addition(+)</button>
        <button type="submit"  name="operator" value="-" style="width: 150px">Subtraction(-)</button>
        <button type="submit"  name="operator" value="*" style="width: 150px">Multiplication(*)</button>
        <button type="submit"  name="operator" value="/" style="width: 150px">Division(/)</button>
    </form>
</div>
</body>
</html>
