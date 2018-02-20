<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>

<html><body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table class="table-bordered">
        <thead>
        <tr class="tableSubHeadingColor">
            <td>First Name</td>
            <td>Last Name</td>
            <td>User Id</td>
            <td>User Name</td>
        </tr>
        </thead>
        <c:forEach var = "user" items = "${users}">
            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.id}</td>
                <td>${user.userName}</td>
            </tr>

        </c:forEach>

    </table>
</div>

</body>
</html>

