package web_erp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_erp.dto.Department;
import web_erp.service.DepartmentService;

@WebServlet("/DepartmentInsertServlet")
public class DepartmentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartmentService service;
	
    public DepartmentInsertServlet() {
    	service = new DepartmentService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int deptno = Integer.parseInt(request.getParameter("deptno").trim());
		String deptname = request.getParameter("deptname");		
		int floor = Integer.parseInt(request.getParameter("floor").trim());

		Department department = new Department(deptno,deptname,floor);
		
		service.addDepartment(department);
		
		response.sendRedirect("DepartmentListServlet");
	
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
