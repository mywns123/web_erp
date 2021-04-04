package web_erp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_erp.dto.Department;
import web_erp.dto.Employee;
import web_erp.dto.Title;
import web_erp.service.EmployeeService;

@WebServlet("/EmployeeInsertServlet")
public class EmployeeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService service;

    public EmployeeInsertServlet() {
    	service = new EmployeeService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//tno=7&tname=인턴
//		int empno = Integer.parseInt(request.getParameter("empNo").trim());
//		String empname = request.getParameter("empName");		
//		String title = request.getParameter("title");
//		int manager = Integer.parseInt(request.getParameter("manager").trim());
//		int salary = Integer.parseInt(request.getParameter("salary").trim());
//		int dept = Integer.parseInt(request.getParameter("dept").trim());
//		Title title1 = title;
//		Employee employee = new Employee(empno,empname,title,manager,salary,dept);
		
//		service.addEmployee(employee);;
		
		response.sendRedirect("EmployeeListServlet");
//		request.getRequestDispatcher("TitleListServlet.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
