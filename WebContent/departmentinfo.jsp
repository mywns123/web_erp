<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>직책 정보</h2>
		<form action="DepartmentDelServlet" method="get">
			<fieldset>
				<legend>직책 정보</legend>
				<ul>
					<li>
						<label for="deptno">부서번호</label>
						<input type="number" name="deptno" size="20" id="deptno" value="${department.deptNo}" readonly>
					</li>
					<li>
						<label for="deptname">부서명</label>
						<input type="text" name="deptname" size="20" id="deptname" value="${department.deptName}" readonly>
					</li>
					<li>
						<label for="floor">위치</label>
						<input type="number" name="floor" size="20" id="floor" value="${department.floor}" readonly>
					</li>				
					<li>
						<a href="departmentUpdate.jsp?deptno=${department.deptNo}&deptname=${department.deptName}&floor=${department.floor}">수정</a>
						<a href="DepartmentDelServlet?deptno=${department.deptNo}">삭제</a>
					</li>
				</ul>
			</fieldset>
		</form>
</body>
</html>