<%--
  Created by IntelliJ IDEA.
  User: vutienbka
  Date: 3/20/20
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Email Validation</title>
</head>
<body>

<h1>Email Validate</h1>
<h3 style="color:red">${message}</h3>

<form action="${pageContext.request.contextPath}validate" method="post">
  <input type="text" name="email"><br>
  <input type="submit" value="Validate">
</form>

</body>
</html>