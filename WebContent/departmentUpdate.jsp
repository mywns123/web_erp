<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>부서 정보 수정</h2>
		<form action="DepartmentUpdateServlet" method="get">
			<fieldset>
				<legend>부서 정보</legend>
				<ul>
					<li>
						<label for="deptno">부서번호</label>
						<input type="number" name="deptno" size="20" id="deptno" value="<%=request.getParameter("deptno") %>" readonly>
					</li>
					<li>
						<label for="deptname">부서명</label>
						<input type="text" name="deptname" size="20" id="deptname" value="<%=request.getParameter("deptname") %>">
					</li>
					<li>
						<label for="floor">위치</label>
						<input type="number" name="floor" size="20" id="floor" value="<%=request.getParameter("floor") %>">
					</li>				
					<li>
						<input type="submit" value="수정"><input type="reset" value="취소"> 
					</li>
				</ul>
			</fieldset>
		</form>
</body>
</html>