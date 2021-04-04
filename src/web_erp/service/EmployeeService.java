package web_erp.service;

import java.sql.Connection;
import java.util.List;

import web_erp.dao.impl.EmployeeImpl;
import web_erp.ds.JndiDs;
import web_erp.dto.Employee;

public class EmployeeService {
	private Connection con = JndiDs.getConnection();
	private EmployeeImpl dao = EmployeeImpl.getInstance();
	
	public EmployeeService() {
		dao.setCon(con);
	}
	
	public List<Employee> showEmployees(){
		return dao.selectEmployeeByAll();
	}
	
	public void addEmployee(Employee employee) {
		dao.insertEmployee(employee);
	}
	
	public Employee showEmployee(Employee employee) {
		return dao.selectEmployeeByNo(employee);
	}
	
	public int updateEmployee(Employee employee) {
		return dao.updateEmployee(employee);
	}
	
	public int delEmployee(int empNo) {
		return dao.deleteEmployee(empNo);	
	}	
}
