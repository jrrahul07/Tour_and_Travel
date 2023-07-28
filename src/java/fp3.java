import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class fp3 extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();
        String password = req.getParameter("password");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
            Statement stmt = con.createStatement();
            HttpSession ses = req.getSession();
            String s1 = (String)ses.getAttribute("nm1");
            String q1 = "Update users set password='"+password+"' where email='"+s1+"'";
            ResultSet rs = stmt.executeQuery(q1);
            if (rs.next()) {
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
"    <h1>Your Password Has Been Updated Successfully</h1>\n" +
"    <div class=\"Details_link\">\n" +
"       <a href=\"Login.html\"> Go Back To Login Page </a>\n" +
"    </div>\n" +
"</body>\n" +
"</html>");
            }else{
                pw1.println("password cannot be updated");
        }
    }
    catch(Exception e

    
        ){
            pw1.println(e);
    }
}
}
