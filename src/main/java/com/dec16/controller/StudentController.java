package com.dec16.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dec16.model.DAOservice;

@WebServlet("/addStudent")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public StudentController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/student_registration.jsp");
	    rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   try {
		   HttpSession session = request.getSession(false);

		    if(session.getAttribute("email")!=null) {
			String name = request.getParameter("name"); 
		    String email = request.getParameter("email"); 
		    String mobile = request.getParameter("mobile"); 
		    
		    DAOservice service=new DAOservice();
		    service.connectDB();
		    service.addStudent(name, email, mobile);
		    
		    request.setAttribute("msg", "Student is now added");
		    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/student_registration.jsp");
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

}
