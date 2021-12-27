
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class OrderProduct extends HttpServlet {
    String username="";
    String password="";
    Connection con=null;
    Statement st=null,st1=null;
    ResultSet rs=null,rs1=null;
    
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
        String product1 = req.getParameter("product1");
       
	
	HttpSession sn = req.getSession(true);
     sn.setAttribute("product1",product1);
     sn.setAttribute("prod","1");
   
		RequestDispatcher rd = null;
                
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodorder","root","password");
              
             
                rd=req.getRequestDispatcher("userpage.jsp");
           
	     rd.forward(req,res);
        }
        catch(Exception e2)
         {
            System.out.println("Exception : "+e2.toString());
        }
    }
}
