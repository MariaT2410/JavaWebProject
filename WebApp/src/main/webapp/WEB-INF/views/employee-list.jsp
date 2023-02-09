<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
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

<jsp:include page="_menu.jsp"></jsp:include>
    <h2>
        <a href="${pageContext.request.contextPath}/insertEmployee" >Add New Employee</a>
       
    </h2>
<p style="color: red;">${errorString}</p>
<div>
<table class ="table" >
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Wage</th>
        <th>Id Department</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${listEmployee}" var="employee" >
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.age}</td>
            <td>${employee.wage}</td>
            <td>${employee.idDepartment}</td>
            <td>
            	<a href="editEmployee?id=<c:out value='${employee.id}' />">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <a href="deleteEmployee?id=<c:out value='${employee.id}' />">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
    
</body>
</html>