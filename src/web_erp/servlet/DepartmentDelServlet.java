package web_erp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_erp.service.DepartmentService;

@WebServlet("/DepartmentDelServlet")
public class DepartmentDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartmentService service;
	
    public DepartmentDelServlet() {
    	service= new DepartmentService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int deptno = Integer.parseInt(request.getParameter("deptno").trim());
		service.delDepartment(deptno);
		
		response.sendRedirect("DepartmentListServlet");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
