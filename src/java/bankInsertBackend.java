import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class bankInsertBackend extends HttpServlet {
    
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();
        
        String name = req.getParameter("name");
        String id = req.getParameter("id");
        String balance = req.getParameter("balance");
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:"
                    + "oracle:thin:@localhost:1521:XE", "system", "system");
            Statement stmt = con.createStatement();
            String q1 = "insert into banks values('" + id + "','" + name + "','" + balance + "')";
            System.out.println(q1);
            int x = stmt.executeUpdate(q1);
            if (x > 0) {
                pw1.println("Done");
            }else{
                pw1.println("Not done");
            }
        }catch(Exception e){
            pw1.println(e);
        }
    }
}