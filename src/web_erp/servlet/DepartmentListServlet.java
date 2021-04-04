package web_erp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_erp.dto.Department;
import web_erp.service.DepartmentService;

@WebServlet("/DepartmentListServlet")
public class DepartmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartmentService service;
 
    public DepartmentListServlet() {   
    	service = new DepartmentService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");			
		List<Department> list = service.showDepartments();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("departmentList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
