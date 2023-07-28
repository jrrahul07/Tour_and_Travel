
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class fp2 extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();
        String contact = req.getParameter("contact");
        try {
            HttpSession ses = req.getSession();
            String s1 = (String) ses.getAttribute("nm1");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
            Statement stmt = con.createStatement();
            String q1 = "Select * from users where email='" + s1 + "' and contact='" + contact + "'";
            //pw1.println(q1);
            ResultSet rs = stmt.executeQuery(q1);
            if (rs.next()) {
                pw1.println("<html lang=>\n"
                        + "<head>\n"
                        + "    <meta charset=\"UTF-8\">\n"
                        + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "    <title>Create new password</title>\n"
                        + "</head>\n"
                        + "<style>\n"
                        + "body{\n"
                        + "        margin: 0;\n"
                        + "        padding: 0;\n"
                        + "        font-family: montserrat; \n"
                        + "        height: 100vh;\n"
                        + "        overflow: hidden;\n"
                        + "    }\n"
                        + "    .center{\n"
                        + "        position: absolute;\n"
                        + "        top: 30%;\n"
                        + "        left: 50%;\n"
                        + "        transform: translate(-50% ,-50%);\n"
                        + "        width: 400px;\n"
                        + "        background: rgb(217, 231, 237);\n"
                        + "        border: 2px solid black;\n"
                        + "        border-radius: 10px;\n"
                        + "    }\n"
                        + "    .center h1{\n"
                        + "        text-align: center;\n"
                        + "        padding: 0 0 20px 0;\n"
                        + "        border-bottom: 1px solid silver;\n"
                        + "    }\n"
                        + "    .center form{\n"
                        + "        padding: 20px 40px;\n"
                        + "        box-sizing: border-box;\n"
                        + "    }\n"
                        + "    form .txt_field{\n"
                        + "        position: relative;\n"
                        + "        border-bottom: 2px solid #adadad;\n"
                        + "        margin: 30px 0;\n"
                        + "    }\n"
                        + "    .txt_field input{\n"
                        + "        width: 100%;\n"
                        + "        padding: 0 5px;\n"
                        + "        height: 40px;\n"
                        + "        font-size: 16px;\n"
                        + "        border: none;\n"
                        + "        background: none;\n"
                        + "        outline: none;\n"
                        + "    }\n"
                        + "    .txt_field label{\n"
                        + "        position: absolute;\n"
                        + "        top: 50%;\n"
                        + "        left: 5px;\n"
                        + "        color: #1d1212;\n"
                        + "        transform: translateY(-50%);\n"
                        + "        font-size: 16px;\n"
                        + "        pointer-events: none;\n"
                        + "        transition: .5s;\n"
                        + "    }\n"
                        + "    .txt_field span::before{\n"
                        + "        content: '';\n"
                        + "        position: absolute;\n"
                        + "        top: 40px;\n"
                        + "        left: 0;\n"
                        + "        width: 0%;\n"
                        + "        height: 2px;\n"
                        + "        background: #2691d9;\n"
                        + "        transition: .5s;\n"
                        + "    }\n"
                        + "    .txt_field input:focus ~ label,\n"
                        + "    .txt_field input:valid ~label{\n"
                        + "        top: -5px;\n"
                        + "        color: #2691d9;\n"
                        + "    }\n"
                        + "    .txt_field input:focus ~ span::before,\n"
                        + "    .txt_field input:valid ~span::before{\n"
                        + "        width: 100%;\n"
                        + "    }\n"
                        + "    input[type=\"submit\"]{\n"
                        + "        width: 50%;\n"
                        + "        height: 30px;\n"
                        + "        border: 1px solid;\n"
                        + "        background: #2691d9;\n"
                        + "        border-radius: 25px;\n"
                        + "        font-size: 18px;\n"
                        + "        color: #e9f4fb;\n"
                        + "        font-weight: 700;\n"
                        + "        cursor: pointer;\n"
                        + "        outline: none;\n"
                        + "    }\n"
                        + "    input[type=\"submit\"]:hover{\n"
                        + "        border-color: #2691d9;\n"
                        + "        transition: .5s;\n"
                        + "    }\n"
                        + "</style>\n"
                        + "<body>\n"
                        + "    <div class=\"center\">\n"
                        + "        <h1>Create new password</h1>\n"
                        + "        <form method=\"post\" action=\"fp3\">\n"
                        + "            <div class=\"txt_field\">\n"
                        + "                <input type=\"password\" required>\n"
                        + "                <span></span>\n"
                        + "                <label >Enter new password</label>\n"
                        + "            </div>\n"
                        + "\n"
                        + "            <div class=\"txt_field\">\n"
                        + "                <input type=\"password\" required>\n"
                        + "                <span></span>\n"
                        + "                <label >Confirm new passwprd</label>\n"
                        + "            </div>\n"
                        + "\n"
                        + "            <input type=\"submit\" value=\"Submit\">\n"
                        + "            \n"
                        + "        </form>\n"
                        + "    </div>\n"
                        + "</body>\n"
                        + "</html>");
            } else {
                pw1.println("data not found");
            }
        } catch (Exception e) {
            pw1.println(e);
        }
    }
}
