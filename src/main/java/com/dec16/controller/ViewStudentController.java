package com.dec16.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;

import com.dec16.model.DAOservice;

@WebServlet("/listStudent")
public class ViewStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ViewStudentController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
		    if(session.getAttribute("email")!=null) {
			DAOservice service=new DAOservice();
			service.connectDB();
	        ResultSet result=service.getAllStudents();
	        request.setAttribute("result", result);
	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
			rd.forward(request, response);
		}else {
			 RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		 	    rd.forward(request, response);
		}
		}catch(Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	 	    rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
