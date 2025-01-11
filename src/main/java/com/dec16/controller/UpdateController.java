package com.dec16.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

import com.dec16.model.DAOservice;

@WebServlet("/updateStudent")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateController() {
        super();
        }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String email=request.getParameter("email");
	   String mobile=request.getParameter("mobile");
	   
	   request.setAttribute("email",email);
	   request.setAttribute("mobile",mobile);
	   
	   RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/update_registration.jsp");
	   rd.forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		   String mobile=request.getParameter("mobile");
		   
		   DAOservice service=new DAOservice();
		   service.connectDB();
		   service.updateRegistration(email,mobile);
		   
		   ResultSet result=service.getAllStudents();
	        request.setAttribute("result", result);
	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
			rd.forward(request, response);
	}

}
