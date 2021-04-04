<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 목록</title>
</head>
<body>
<h2>부서 목록</h2>
	<table border="1">
		<thead>
			<tr>
				<td>부서번호</td>
				<td>부서명</td>
				<td>위치</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="department" items="${list}">
			<tr>
				<td><a href="DepartmentGetServlet?deptno=${department.deptNo}">${department.deptNo}</a></td>
				<td><a href="DepartmentGetServlet?deptno=${department.deptNo}">${department.deptName}</a></td>
				<td><a href="DepartmentGetServlet?deptno=${department.deptNo}">${department.floor}</a></td>
			</tr>			
		</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2"><a href="departmentInput.jsp">부서 추가</a></td>
		</tfoot>
	</table>
</body>
</html>