import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class searchFlightRes extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();
        
        String dept = req.getParameter("departure");
        String arr = req.getParameter("arrival");
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
            Statement stmt=con.createStatement();
            String q1 = "select * from flights where arrival='"+arr+"' and departure='"+dept+"'";
            //String q1 = " select * from flights where arrival='Kolkata' and departure='Shimla'";
            pw1.println(q1);
            pw1.println("Here are some of the flight options based on your requirements");
            pw1.println("<html><head></head><body>");
            pw1.println("<table border=1>");  
            pw1.println("<tr><th>Flight Id</th><th>Airlines</th><th>Flight Time</th><th>Economy</th><th>Business</th><th>Book</th><tr>");
            ResultSet rs = stmt.executeQuery(q1);
            while(rs.next())
            {
                 pw1.println("<tr><td>" + rs.getInt(1) + "</td><td>" + rs.getString(2) + "</td><td>" +
                         rs.getString(7) + "</td><td>" + rs.getInt(5) +"</td><td>"+ rs.getInt(6) +"</td><td>\n" +
"            <a href=\"bookAFlight.html\">Book it</a>\n" +
"        </td></tr>");   
             } 
             pw1.println(1234);
             pw1.println("</table>");  
             pw1.println("</body></html>"); 
            
        }catch(Exception e){
            pw1.println(e);
        }
    }
}
