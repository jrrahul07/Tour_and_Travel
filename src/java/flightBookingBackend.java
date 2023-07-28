import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class flightBookingBackend extends HttpServlet {
    
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();
        
        String from = req.getParameter("from");
        String to = req.getParameter("to");
        String aadhaar = req.getParameter("aadhar");
        String contact = req.getParameter("number");
        String adult = req.getParameter("adults");
        String children = req.getParameter("children");
        String classSeats = req.getParameter("class");
        String name = req.getParameter("name");
        String fid = req.getParameter("fid");
        String retdate = req.getParameter("retdate");
        String depdate = req.getParameter("depdate");
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:"
                    + "oracle:thin:@localhost:1521:XE", "system", "system");
            Statement stmt = con.createStatement();
            String q1 = "insert into flightBookings values('" + from + "','" + to + "','" + aadhaar + "','" + contact + "','" + name + "','"+ fid+"','"+depdate+"','"+retdate+"','"+adult+"','"+children+"','"+classSeats+"')";
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
"    <a href=\"paymentFlights.html\">Go to payment</a>\n" +
"</body>\n" +
"</html>");
            } else {
                pw1.println("Unsucesssful");
            }
        }catch(Exception e)
        {
            pw1.println(e);
        }
        
//        flightBookingBean ob = new flightBookingBean();
//        ob.setFrom(from);
//        ob.setTo(to);
//        ob.setFid(fid);
//        ob.setContact(contact);
//        ob.setAdult(adult);
//        ob.setChildren(children);
//        ob.setClassSeats(Class);
//        ob.setDeparting(depdate);
//        ob.setReturning(retdate);
//        ob.setName(name);
//        ob.setAdhaar(aadhaar);
//
//        
//        
//        boolean x = ob.insertMethod();
//        if(x==true)
//        {
//            //To be done from here....
//            pw1.println("<!DOCTYPE html>\n" +
//"<html lang=\"en\">\n" +
//"<head>\n" +
//"    <meta charset=\"UTF-8\">\n" +
//"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
//"    <meta name=\"viewport\" content=\"width=, initial-scale=1.0\">\n" +
//"    <title>Document</title>\n" +
//"</head>\n" +
//"<body>\n" +
//"    <a href=\"payment.html\"></a>\n" +
//"</body>\n" +
//"</html>");
//        }
//        else{
//            pw1.println("Flight cannot be booked");
//        }
        
    }
}