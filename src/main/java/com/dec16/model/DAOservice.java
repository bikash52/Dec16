package com.dec16.model;

import java.sql.*;

public class DAOservice {
         private Connection con;
         private Statement stmnt;
         
         
         public void connectDB() {
        	 try {
        		 Class.forName("com.mysql.cj.jdbc.Driver");
        		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dec16","root","Qwe@83288");
        	     stmnt=con.createStatement();
        	 }catch(Exception e) {
        		 e.printStackTrace();
        	 }
         }
         public boolean verifyLogin(String email,String password) {
        	 try {
        		 ResultSet result = stmnt.executeQuery
        				 ("SELECT * FROM login where email='"+email+"' and password='"+password+"'");
        		 return result.next();
        	 }catch(Exception e) {
        		 e.printStackTrace();
        	 }
        	 return false;
         }
         public void closeConnection() {
        	 try {
        		 con.close();
        	 }catch(Exception e) {
        		 e.printStackTrace();
        	 }
           }
         public void addStudent(
        		 String name,
        		 String email,
        		 String mobile
        		 ) {
        	 try {
        		 stmnt.executeUpdate("insert into student values('"+name+"','"+email+"','"+mobile+"')");
        	 }catch(Exception e) {
        		 e.printStackTrace();
        	 }
         }
		public ResultSet getAllStudents() {
			try {
       		 ResultSet result = stmnt.executeQuery("SELECT * FROM Student");
       		 return result;
       	 }catch(Exception e) {
       		 e.printStackTrace();
       	 }			return null;
		}
		public void deleteStudentInfo(String email) {
			try {
	       		 stmnt.executeUpdate("delete from student where email='"+email+"'");
	       	 }catch(Exception e) {
	       		 e.printStackTrace();
	       	 }
		}
		public void updateRegistration(String email, String mobile) {
			try {
	       		 stmnt.executeUpdate("update student set mobile='"+mobile+"' where email='"+email+"'");
	       	 }catch(Exception e) {
	       		 e.printStackTrace();
	       	 }
		}
		
         
}
