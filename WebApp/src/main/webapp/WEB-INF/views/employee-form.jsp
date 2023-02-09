<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee</title>
<style type="text/css">
.table {
	width: 100%;
	border: none;
	margin-bottom: 20px;
}
.table thead th {
	font-weight: bold;
	text-align: left;
	border: none;
	padding: 10px 15px;
	background: #d8d8d8;
	font-size: 14px;
	border-left: 1px solid #ddd;
	border-right: 1px solid #ddd;
}
.table tbody td {
	text-align: left;
	border-left: 1px solid #ddd;
	border-right: 1px solid #ddd;
	padding: 10px 15px;
	font-size: 14px;
	vertical-align: top;
}
.table thead tr th:first-child, .table tbody tr td:first-child {
	border-left: none;
}
.table thead tr th:last-child, .table tbody tr td:last-child {
	border-right: none;
}
.table tbody tr:nth-child(even){
	background: #f3f3f3;
}
  </style>
</head>
<body>
<h1>Employee Management</h1>
<h2>
        <a href="${pageContext.request.contextPath}/insertEmployee">Add New Employee</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/employee-list">List All Employees</a>
</h2>
    
<div align="center">
    <form action="${pageContext.request.contextPath}/editEmployee" method="POST">
            <table class="table">
                <caption>
                    <h2>
                        <c:if test="${employee != null}">
                            Edit Employee
                        </c:if>
                    </h2>
                </caption>
                <c:forEach var="employee" items="${employee}">
                <tr>
                    <th>Employee ID: </th>
                    <td>
                <input type="text" readonly name="id" size="45" value="<c:out value='${employee.id}' />" />
                	</td>
                	</tr>
                <tr>
                    <th>Employee Name: </th>
                    <td>
                        <input type="text" name="name" size="45" value="<c:out value='${employee.name}' />"/>
                    </td>
                </tr>
                <tr>
                    <th>Employee Age: </th>
                    <td>
                        <input type="text" name="age" size="45"
                               value="<c:out value='${employee.age}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Employee wage: </th>
                    <td>
                        <input type="text" name="wage" size="45"
                               value="<c:out value='${employee.wage}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>idDepartment: </th>
                    <td>
                        <input type="text" name="idDepartment" size="45"
                               value="<c:out value='${employee.idDepartment}' />"
                        />
                    </td>
                </tr>
                <tr>
                <th></th>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
                </c:forEach>
            </table>
        </form>
</div> 
</body>
</html>