package com.lcpan.m11;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.lcpan.bean.EmpBean;

@WebServlet("/GetAllEmpsJNDI")
public class GetAllEmpsJNDI extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
//	private static final String JDBC_DRIVER ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    private static final String DB_URL="jdbc:sqlserver://localhost:1433;databaseName=servdb;trustServerCertificate=true";
//    private static final String USER = "sa";
//    private static final String PASSWORD = "5tgbnmlp";
//   
    Connection conn;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unused")
		String empno = request.getParameter("empno");
    	
			try {
				Context context = new InitialContext();
				DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
				conn = ds.getConnection();
				
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		
	}

}
