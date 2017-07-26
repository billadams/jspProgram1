<%-- 
    Document   : index
    Created on : Jul 26, 2017, 11:18:14 AM
    Author     : da202057
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <title>Employee List</title>
    </head>
    <body>
        <h1>Employee List</h1>

        <table>
            <tr>
                <th>First Name</th>
                <th>Middle Initial</th>
                <th>Last Name</th>
                <th>Employee ID</th>
                <th>Birth Date</th>
                <th>Hire Date</th>
            </tr>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td>${employee.firstName}</td>
                    <td>${employee.middleName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.employeeID}</td>
                    <td>${employee.birthDate}</td>
                    <td>${employee.hireDate}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
