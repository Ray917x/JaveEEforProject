package com.lcpan.m11;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_URL="jdbc:sqlserver://localhost:1433;databaseName=servdb;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASSWORD = "5tgbnmlp";
   
    Connection conn;
    
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
		String empno = request.getParameter("empno");
//		String ename = request.getParameter("ename");
//		String hiredate = request.getParameter("hiredate");
//		String salary = request.getParameter("salary");
//		String deptno = request.getParameter("deptno");
//		String title = request.getParameter("title");
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement("delete from employee where empno = ?");
			stmt.setDouble(1, Double.valueOf(empno));
			
			
			stmt.execute();
			stmt.close();
			
			request.getRequestDispatcher("/m11/Delete.jsp").forward(request, response);
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
