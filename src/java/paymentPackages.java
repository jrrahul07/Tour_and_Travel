import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class paymentPackages extends HttpServlet {
    
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();
        
        String name = req.getParameter("name");
        String x = req.getParameter("amount");
        String cno = req.getParameter("cardNo");
        String cvv = req.getParameter("cvv");
        String paidto = req.getParameter("payto");
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:"
                    + "oracle:thin:@localhost:1521:XE", "system", "system");
            Statement stmt = con.createStatement();
            String q1 = "insert into transactions values('" + name + "','" + x + "','" + cno + "','" + cvv +"','"+paidto+"')";
            System.out.println(q1);
            String q2 = "update banks set balance ='"+x+"' where name='"+paidto+"'";
            int p = stmt.executeUpdate(q1);
            int q = stmt.executeUpdate(q2);
            if(p>0 && q>0){
                pw1.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <title>Flight details successful</title>\n" +
"</head>\n" +
"<style>\n" +
"    body{\n" +
"        background-color: rgb(178, 235, 254);\n" +
"        font-family: montserrat; \n" +
"    }\n" +
"    h1{\n" +
"        font-size: 3.5rem;\n" +
"        text-align: center;\n" +
"        color: rgb(26, 11, 141);  \n" +
"    }\n" +
"    .Details_link{\n" +
"        margin: 30px 0;\n" +
"        text-align: center;\n" +
"        font-size: 22px;\n" +
"        color: #c9c00b;\n" +
"    }\n" +
"    .Login_link a{\n" +
"        color:navy;\n" +
"        text-align: center;\n" +
"        text-decoration: underline;\n" +
"    }\n" +
"</style>\n" +
"<body>\n" +
"    <h1>Your tour has been booked. Enjoy your trip .</h1>\n" +
"    <div class=\"Details_link\">\n" +
"       <a href=\"package.html\"> Want to book another trip </a>\n" +
"    </div>\n" +
"</body>\n" +
"</html>");
            }else{
                pw1.println("Payment failed");
            }
        }catch(Exception e){
            pw1.println(e);
        }
    }
}