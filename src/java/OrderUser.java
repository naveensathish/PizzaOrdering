 
   import java.io.*;
   import java.sql.*;
   import javax.servlet.*;
   import javax.servlet.http.*;
   import java.lang.*;
import java.text.DecimalFormat;
import java.util.Properties;
   
   import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class OrderUser extends HttpServlet {

Connection con=null;
    Statement st=null,st1=null;
    ResultSet rs=null;
    RequestDispatcher rd=null;
     String host = "smtp.gmail.com";
                String from="securecomputing10@gmail.com";
                String subject = "Food Order";
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
 
            
            HttpSession sn = req.getSession(true);
     
            String product = sn.getAttribute("product1").toString();
            String prod = sn.getAttribute("prod").toString();
            
            int pcount = Integer.parseInt(product);
            int tot =0;
            String prodname="";
            if(prod.equals("1"))
            {
               tot = 200 * pcount;
               prodname="pizza-1";
            }
            else if(prod.equals("2"))
            {
               tot = 250 * pcount;
               prodname="pizza-2";
            }
	  
            String username= req.getParameter("username");
          String mobile= req.getParameter("mobile");
            String addr= req.getParameter("addr");
        	
                String mailid= req.getParameter("mailid");
        	
		
               
              
        	RequestDispatcher rd;

	try {
		
		
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodorder","root","password");
            
            
             
             String messageText = "Your order has been placed, Will deliver soon...";
boolean sessionDebug = true;
// Create some properties and get the default Session.
//System.setProperty("smtp.protocols", "SSLv3");
Properties props = System.getProperties();

props.put("mail.smtp.starttls.enable","true");
props.setProperty("mail.transport.protocol","smtp");
props.setProperty("mail.host",host);
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.port", "587");    //port is 587 for TLS  if you use SSL then port is 465
props.put("mail.debug", "true");
props.put("mail.smtp.socketFactory.port", "465");
props.put("mail.smtp.socketFactory.fallback", "false");
props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

Session mailSession = Session.getInstance(props, new javax.mail.Authenticator()
{
protected PasswordAuthentication getPasswordAuthentication() {return new PasswordAuthentication("UserName", "Password");
}
});
 
// Set debug on the Session
// Passing false will not echo debug info, and passing True will.
 
mailSession.setDebug(sessionDebug);
 
// Instantiate a new MimeMessage and fill it with the
// required information.
 
Message msg = new MimeMessage(mailSession);
msg.setFrom(new InternetAddress(from));
InternetAddress[] address = {new InternetAddress(mailid)};
msg.setRecipients(Message.RecipientType.TO, address);
msg.setSubject(subject);
//msg.setSentDate(new Date());
msg.setText(messageText);

 
// Hand the message to the default transport service
// for delivery.
 
Transport transport = mailSession.getTransport("smtp");
transport.connect(host, "propsessionmail", "mailsession");
transport.sendMessage(msg, msg.getAllRecipients());

            String s1 = "vicky";
            String s2="7502483537";
            
            st1 = con.createStatement();
            int add=st1.executeUpdate("insert into userorders values('"+username+"','"+mobile+"','"+addr+"','"+mailid+"')");
           
            
            st1 = con.createStatement();
            int add1=st1.executeUpdate("insert into costdetails values('"+username+"','"+prodname+"','"+product+"','"+tot+"')");
           
             st1 = con.createStatement();
            int add11=st1.executeUpdate("insert into deliverdetails values('"+username+"','"+s1+"','"+s2+"')");
           
            
            rd=req.getRequestDispatcher("success.jsp");
            rd.forward(req,res);
        } catch(Exception e2) {
            // rd=req.getRequestDispatcher("failure.jsp");
        }
    }
}