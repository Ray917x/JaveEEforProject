package com.Icpan.project;

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

import com.lcpan.bean.AnimalBean;

@WebServlet("/AnimalGetAllJSTL")
public class AnimalGetAllJSTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	private static final String JDBC_DRIVER ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    private static final String DB_URL="jdbc:sqlserver://localhost:1433;databaseName=servdb;trustServerCertificate=true";
//    private static final String USER = "sa";
//    private static final String PASSWORD = "5tgbnmlp";

	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		@SuppressWarnings("unused")
//		String animal_id = request.getParameter("animal_id");
//		System.out.println("66666666666666");

		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			conn = ds.getConnection();

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM animal");
			ResultSet rs = stmt.executeQuery();
			
			List<AnimalBean> animals = new ArrayList<>();
			AnimalBean animal = null;
			while (rs.next()) {
				animal = new AnimalBean();
				animal.setAnimal_id(rs.getString("animal_id"));
				animal.setAnimal_place(rs.getString("animal_place"));
				animal.setAnimal_kind(rs.getString("animal_kind"));
				animal.setAnimal_sex(rs.getString("animal_sex"));
				animal.setAnimal_bodytype(rs.getString("animal_bodytype"));
				animal.setAnimal_colour(rs.getString("animal_colour"));
				animal.setAnimal_foundplace(rs.getString("animal_foundplace"));
				animal.setAnimal_remark(rs.getString("animal_remark"));
//				animal.setAnimal_update(rs.getString("animal_update"));

				animals.add(animal);

			}

			request.setAttribute("animals", animals);
			stmt.close();

			System.out.println(animals);
			request.getRequestDispatcher("project/AnimalGetAll.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
