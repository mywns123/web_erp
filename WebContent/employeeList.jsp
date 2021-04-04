<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 목록</title>
</head>
<body>
	<h2>사원 목록</h2>
		<table border="1">
			<thead>
				<tr>
					<td>사원번호</td>
					<td>사원명</td>
					<td>직책</td>
					<td>매니저</td>
					<td>연봉</td>
					<td>부서</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="employee" items="${list}">
				<tr>
					<td><a href="EmployeeGetServlet?empno=${employee.empNo}">${employee.empNo}</a></td>
					<td><a href="EmployeeGetServlet?empno=${employee.empNo}">${employee.empName}</a></td>
					<td><a href="EmployeeGetServlet?empno=${employee.empNo}">${employee.title}</a></td>
					<td><a href="EmployeeGetServlet?empno=${employee.empNo}">${employee.manager}</a></td>
					<td><a href="EmployeeGetServlet?empno=${employee.empNo}">${employee.salary}</a></td>
					<td><a href="EmployeeGetServlet?empno=${employee.empNo}">${employee.dept}</a></td>
				</tr>			
			</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2"><a href="employeeInput.jsp">사원 추가</a></td>
			</tfoot>
		</table>
</body>
</html>