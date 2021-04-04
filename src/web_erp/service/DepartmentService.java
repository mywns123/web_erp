package web_erp.service;

import java.sql.Connection;
import java.util.List;

import web_erp.dao.impl.DepartmentDaoImpl;
import web_erp.ds.JndiDs;
import web_erp.dto.Department;

public class DepartmentService {
	private Connection con = JndiDs.getConnection();
	private DepartmentDaoImpl dao = DepartmentDaoImpl.getInstance();
	
	public DepartmentService() {
		dao.setCon(con);
	}
	
	public List<Department> showDepartments(){
		return dao.selectDepartmentByAll();
	}
	
	public void addDepartment(Department department) {
		dao.insertDepartment(department);
	}
	
	public Department showDepartment(Department department) {
		return dao.selectDepartmentByNo(department);
	}
	
	public int updateDepartment(Department department) {
		return dao.updateDepartment(department);
	}
	
	public int delDepartment(int deptno) {
		return dao.deleteDepartment(deptno);	
	}	
}
