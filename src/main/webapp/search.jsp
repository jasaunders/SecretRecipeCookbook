<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: joannesaunders
  Date: 3/5/18
  Time: 12:45 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<body>
<div class="container">
    <h2>Administrator User Search</h2>
    <h3 class="error">${searchError}</h3>
    <form method="GET" action="searchUser" class="form">

        <label for="searchTerm">Search on Last Name</label><br/>
        <input type="text" class="form-control" name="searchTerm" id="searchTerm"/>
        <br/>
        <button type="submit" class="btn-btn-primary" name="submit" value="Search">Search by Last Name</button>
        <button type="submit" class="btn-btn-primary" name="submit" value="GetAllUsers">Get All Users</button>
    </form>
</div>

</body>
</html>