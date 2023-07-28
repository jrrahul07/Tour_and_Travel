import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class hotelBookingBackend extends HttpServlet {
    
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();
        
        String name = req.getParameter("name");
        String aadhaar = req.getParameter("aadhar");
        String contact = req.getParameter("number");
        String address = req.getParameter("address");
        String rooms = req.getParameter("rooms");
        String days = req.getParameter("days");
        String beds = req.getParameter("beds");
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:"
                    + "oracle:thin:@localhost:1521:XE", "system", "system");
            Statement stmt = con.createStatement();
            String q1 = "insert into hotels values('" + name + "','" + address + "','" + aadhaar + "','" + contact + "','" + rooms + "','"+ days+"','"+beds+"')";
            System.out.println(q1);
            int x = stmt.executeUpdate(q1);
            if (x > 0) {
                pw1.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <title>Document</title>\n" +
"</head>\n" +
"<body>\n" +
"    <a href=\"paymentHotels.html\">Go to payment</a>\n" +
"</body>\n" +
"</html>");
            } else {
                pw1.println("Unsucesssful");
            }
        }catch(Exception e)
        {
            pw1.println(e);
        }
    }
}