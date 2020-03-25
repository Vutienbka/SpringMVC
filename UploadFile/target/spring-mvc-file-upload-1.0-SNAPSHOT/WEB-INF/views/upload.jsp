<%--
  Created by IntelliJ IDEA.
  User: vutienbka
  Date: 3/25/20
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<body>
<h1>Spring MVC multi files upload example</h1>

<form:form method="POST" action="${pageContext.request.contextPath}/uploadMulti"
           enctype="multipart/form-data">

    <input type="file" name="files" /><br/>
    <input type="file" name="files" /><br/>
    <input type="file" name="files" /><br/><br/>
    <input type="submit" value="Submit" />

</form:form>

</body>
</html>