<%@ page import="Product_Manage.Controller.SQL_Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vutienbka
  Date: 3/17/20
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
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
    <form style="position: relative; margin-top: 30px">
        <input type="text" name="search" placeholder="Search for">
        <button type="submit">Search</button>
    </form>
    <p><a href="${pageContext.request.contextPath}/">back to product page<<</a></p>
    <p style="font-size: 25px; color: blue">${message}</p>
    <form>
        <button type="submit" class="btn btn-success"><a href="${pageContext.request.contextPath}?action=addProduct">Add Product</a></button>
    </form>
    <div class="card">
        <div class="card-header">Product Information</div>

        <table class="table table-bordered table-striped" style="text-align: center">
            <div class="card-body">
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
                </thead>
                    <%
                SQL_Connection connection = new SQL_Connection();
                Connection conn = connection.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs;
                String getSearch = request.getParameter("search");

                String data;

                if(getSearch!=null){
                    data = "SELECT * from Product WHERE productName like '%" +getSearch+ "%' OR color like '%" +getSearch+ "%' " +
                     "OR description like '%" +getSearch+ "%' OR categorize like '%" +getSearch+ "%'";
                }
                else {
                     data = "SELECT * from Product ORDER BY productId ASC";
                }
                rs = st.executeQuery(data);
                while(rs.next()){
%>
                <tr>
                    <td><%= rs.getInt("productId")%></td>
                    <td><%= rs.getString("productName")%></td>
                    <td><%= rs.getInt("price")%></td>
                    <td><%= rs.getInt("quantity")%></td>
                    <td><%= rs.getString("color")%></td>
                    <td><%= rs.getString("description")%></td>
                    <td><%= rs.getString("categorize")%></td>
                    <td>
                        <button><a href="${pageContext.request.contextPath}?action=editProduct&Id=<%=rs.getInt("productId")%>">Edit
                        </a></button>
                        <button> <a href="${pageContext.request.contextPath}?action=deleteProduct&Id=<%=rs.getInt("productId")%>">Delete
                        </a></button>
                    </td>
                </tr>
                    <%
    }
%>
        </table>
    </div>
</div>
</div>
</body>
</html>
