package web_erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web_erp.dao.EmployeeDao;
import web_erp.dto.Department;
import web_erp.dto.Employee;
import web_erp.dto.Title;

public class EmployeeImpl implements EmployeeDao {

	private static EmployeeImpl instance = new EmployeeImpl();
	private Connection con;
	
	private EmployeeImpl() {
	}

	public static EmployeeImpl getInstance() {
		if(instance == null) {
			instance = new EmployeeImpl();
		}
		return instance;
	}

	public  void setCon(Connection con) {
		this.con = con;
	}
	@Override
	public List<Employee> selectEmployeeByAll() {
		String sql = "select empNo,empName,title_no,title_name,manager_no,manager_name,salary,dept_no,dept_name,floor"
				   + " from vw_full_employee";
		try (PreparedStatement std = con.prepareStatement(sql);
				ResultSet rs = std.executeQuery()) {
			if (rs.next()) {
				List<Employee> list = new ArrayList<>();
				do {
					list.add(getEmployee(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
		int empNo = rs.getInt("empno");
		String empName = rs.getString("empname");
		Title title = new Title(rs.getInt("title_no"));		
		Employee manager = new Employee(rs.getInt("manager_no"));		
		int salary = rs.getInt("salary");
		Department dept = new Department(rs.getInt("dept_no"));
		try{
			title.setName(rs.getString("title_name"));
		}catch (SQLException e) {}
		
		
		try{
			manager.setEmpName(rs.getNString("manager_name"));
		}catch (SQLException e) {}
		
		try{
			dept.setDeptName(rs.getNString("dept_name"));
		}catch (SQLException e) {}
		
		try{
			dept.setFloor(rs.getInt("floor"));
		}catch (SQLException e) {}		
		
		return new Employee(empNo, empName, title, manager, salary, dept);
	}

	@Override
	public Employee selectEmployeeByNo(Employee employee) {
		String sql = "select empNo, empName, title as title_no ,manager as manager_no ,salary,dept as dept_no" +
				     " from employee" +  
				     " where empno = ?";
		try (PreparedStatement std = con.prepareStatement(sql);) {
			std.setInt(1, employee.getEmpNo());
			try (ResultSet rs = std.executeQuery()) {
				if (rs.next()) {
					return getEmployee(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertEmployee(Employee employee) {
		String sql = "insert into employee  values(?,?,?,?,?,?);";
		try (PreparedStatement std = con.prepareStatement(sql);) {
			std.setInt(1, employee.getEmpNo());
			std.setString(2, employee.getEmpName());
			std.setInt(3, employee.getTitle().getNo());
			std.setInt(4, employee.getManager().getEmpNo());
			std.setInt(5, employee.getSalary());
			std.setInt(6, employee.getDept().getDeptno());
			return std.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateEmployee(Employee employee) {
		String sql = "update employee " + 
					 " set empname = ?, title = ?, manager = ?, salary = ?, dept = ?" + 
					 " where empno =?;";
		try (PreparedStatement std = con.prepareStatement(sql)) {
			std.setString(1, employee.getEmpName());			
			std.setInt(2, employee.getTitle().getNo());
			std.setInt(3, employee.getManager().getEmpNo());
			std.setInt(4, employee.getSalary());
			std.setInt(5, employee.getDept().getDeptno());
			std.setInt(6, employee.getEmpNo());
			return std.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteEmployee(int empNo) {
		String sql = "delete" + 
					 " from employee " + 
					 " where empno = ?;";
		try (PreparedStatement std = con.prepareStatement(sql)) {
			std.setInt(1, empNo);
			return std.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
