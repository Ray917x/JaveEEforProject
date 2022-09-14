package com.lcpan.m10;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcpan.bean.EmpBean;

@WebServlet("/GetAllEmps")
public class GetAllEmps extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String JDBC_DRIVER ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_URL="jdbc:sqlserver://localhost:1433;databaseName=servdb;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASSWORD = "5tgbnmlp";
   
    Connection conn;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unused")
		String empno = request.getParameter("empno");
    	
			try {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee");
				ResultSet rs = stmt.executeQuery();
				List<EmpBean> emps = new ArrayList<>();
				EmpBean emp = null;
				while (rs.next()) {
					emp = new EmpBean();
					emp.setEmpno(rs.getString("empno"));
					emp.setEname(rs.getString("ename"));
					emp.setHiredate(rs.getString("hiredate"));
					emp.setSalary(rs.getString("salary"));
					emp.setDeptno(rs.getString("deptno"));
					emp.setTitle(rs.getString("title"));
					emps.add(emp);
				}
				request.setAttribute("emps", emps);
				stmt.close();
				request.getRequestDispatcher("/m10/GetAllEmps.jsp").forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		
	}

}
