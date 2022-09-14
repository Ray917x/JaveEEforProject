package com.Icpan.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

@WebServlet("/AnimalUpdate")
public class AnimalUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SQL = "UPDATE animal SET animal_place=?,animal_kind=?,animal_sex=?,animal_bodytype=?,animal_colour=?,animal_foundplace=?,animal_remark=? WHERE animal_id=?";
	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String animal_id = request.getParameter("animal_id");
		String animal_place = request.getParameter("animal_place");
		String animal_kind = request.getParameter("animal_kind");
		String animal_sex = request.getParameter("animal_sex");
		String animal_bodytype = request.getParameter("animal_bodytype");
		String animal_colour = request.getParameter("animal_colour");
		String animal_foundplace = request.getParameter("animal_foundplace");
		String animal_remark = request.getParameter("animal_remark");
		System.out.println(animal_id);
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SQL);

			stmt.setInt(8, Integer.valueOf(animal_id));
			stmt.setString(1, animal_place);
			stmt.setString(2, animal_kind);
			stmt.setString(3, animal_sex);
			stmt.setString(4, animal_bodytype);
			stmt.setString(5, animal_colour);
			stmt.setString(6, animal_foundplace);
			stmt.setString(7, animal_remark);

			stmt.executeUpdate();

			AnimalBean animal = new AnimalBean();
			animal.setAnimal_id(animal_id);
			animal.setAnimal_place(animal_place);
			animal.setAnimal_kind(animal_kind);
			animal.setAnimal_sex(animal_sex);
			animal.setAnimal_bodytype(animal_bodytype);
			animal.setAnimal_colour(animal_colour);
			animal.setAnimal_foundplace(animal_foundplace);
			animal.setAnimal_remark(animal_remark);

			request.setAttribute("animal", animal);
			stmt.close();
			request.getRequestDispatcher("project/UpdateSuccess.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}