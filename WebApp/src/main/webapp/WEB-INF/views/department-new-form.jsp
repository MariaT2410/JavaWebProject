<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<h1>Department Management</h1>
<h2>
     <a href="${pageContext.request.contextPath}/insertDepartment">Add New Department</a>
        &nbsp;&nbsp;&nbsp;
     <a href="department-list">List All Department</a>

</h2>
<div align="center">
	<c:if test="${department == null}">
        <form action="${pageContext.request.contextPath}/insertDepartment" method="POST">  
            <table class="table">
                <caption>                 
                        <c:if test="${department == null}">
                            <h2>Add New department</h2>
                        </c:if>
                  
                </caption>
                
                <tr>
                    <th>Department ID: </th>
                    <td>
                    	<input type="text" name="id" size="45" value="<c:out value='${department.id}' />" />
                    </td>
                </tr>
                <tr>
                    <th>Department Name: </th>
                    <td>
                        <input type="text" name="name" size="45" value="<c:out value='${department.name}' />" />
                    </td>
                </tr>
                <tr>
                <th></th>
                    <td colspan="2" align="center"> <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
            
		</form>
	 </c:if>

</div>

</body>
</html>