/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author java.2
 */

public class register1 extends HttpServlet {

Connection con=null;
    Statement st=null,st1=null;
    ResultSet rs=null;
    RequestDispatcher rd=null;
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
 
            
            HttpSession sn = req.getSession(true);
     
            String name= req.getParameter("name");
            String username= req.getParameter("username");
            String password= req.getParameter("password");
            String emailid= req.getParameter("emailid");
            String phonenum= req.getParameter("phonenum");
            String address= req.getParameter("address");
            String city= req.getParameter("city");
       
        	RequestDispatcher rd;

	try {
		
	    Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodorder","root","password");
           
            st1 = con.createStatement();
            int add=st1.executeUpdate("insert into userdetails values('"+name+"','"+username+"','"+password+"','"+emailid+"','"+phonenum+"','"+address+"','"+city+"')");
            
            rd=req.getRequestDispatcher("success2.jsp");
            rd.forward(req,res);
              
        } catch(Exception e2) {
             
        }
    }
}