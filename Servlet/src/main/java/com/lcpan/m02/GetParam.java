package com.lcpan.m02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetParam")
public class GetParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public GetParam() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String age = request.getParameter("age");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String html = "<html><body><h3>Hello" + username + "<br>"+ "<html><body><h3>Your Age Is " + age + ",您好<h3></body></html>";
		
		out.append(html);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
