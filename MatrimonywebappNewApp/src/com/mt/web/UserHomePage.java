package com.mt.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mt.dao.UsersDAO;
import com.mt.dto.Users;

@WebServlet("/UserHomePage")
public class UserHomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    public UserHomePage() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		//int userId = (Integer)session.getAttribute("userId");

		String userName = request.getParameter("userName");
		UsersDAO usersDAO = new UsersDAO();
		Users users = usersDAO.getUsers(userName);
		
		request.getAttribute("userData");		
		RequestDispatcher rd = request.getRequestDispatcher("UserHomePage.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
