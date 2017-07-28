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
        <link rel="stylesheet" href="styles/bootstrap.css" type="text/css"/>
        <title>Employee List</title>
    </head>
    <body>
        <div class="container">
            <h1>Employee List</h1>
            <c:if test="${searchDateFormatted != null}">
                <div class="alert alert-success" role="alert">
                    You searched for employees hired ${searchCriteria} ${searchDateFormatted}.
                </div>
            </c:if>
            
            <div class="row">
                <div class="col-md-8">
                    <table class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>First Name</th>
                                <th>Middle Initial</th>
                                <th>Last Name</th>
                                <th>Employee ID</th>
                                <th>Birth Date</th>
                                <th>Hire Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="employee" items="${employeeList}">
                                <tr>
                                    <td>${employee.firstName}</td>
                                    <td>${employee.middleName}</td>
                                    <td>${employee.lastName}</td>
                                    <td>${employee.employeeID}</td>
                                    <td>${employee.birthDate}</td>
                                    <td>${employee.hireDate}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-4">
                    <form action="EmployeeListServlet" method="post">
                        <input type="hidden" name="action" value="searchRequest">
                        <div class="form-group">
                            <label for="select-hire-date">Search hire date</label>
                            <input type="date" name="searchDate" class="form-control" id="select-hire-date">
                        </div>
                        <div class="radio">
                            <label for="before-date">
                                <input type="radio" name="optionsDate" id="before-date" value="before" checked>Before selected date
                            </label>
                        </div>
                        <div class="radio">
                            <label for="after-date">
                                <input type="radio" name="optionsDate" id="after-date" value="after">After selected date
                            </label>
                        </div>

                        <input type="submit" value="Search">
                        <input type="reset">
                    </form>
                </div>
            </div> <!-- end row -->
        </div> <!-- end container -->
    </body>
</html>
