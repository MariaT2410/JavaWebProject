<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Department</title>
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
     <a href="${pageContext.request.contextPath}/insertDepartment">Add New Department</a>
        

</h2>
<h2>List of Department</h2>  
<div>
<table class="table">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="department" items="${listDepartment}">
            <tr>
                <td><c:out value="${department.id}" /></td>
                <td><c:out value="${department.name}" /></td>
                <td>
                    <a href="editDepartment?id=<c:out value='${department.id}' />">Edit</a>
                    
                    <a href="deleteDepartment?id=<c:out value='${department.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>