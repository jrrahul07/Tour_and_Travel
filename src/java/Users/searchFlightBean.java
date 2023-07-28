/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class searchFlightBean {
    
    private String arrival;
    private String departure;

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }
    
    public void searchMeathod()
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:"
                    + "oracle:thin:@localhost:1521:XE", "system", "system");
            Statement stmt = con.createStatement();
            String q1 = "Select * from flights where arrival='"+arrival+"' and departure='"+departure+"'";
            ResultSet rs = stmt.executeQuery(q1);
            System.out.println("Here are some of the flight options based on your requirements");
            System.out.println("<table border=1 width=50% height=50%>");  
            System.out.println("<tr><th>Flignt Id</th><th>Airlines</th><th>Flight Time</th><th>Economy</th<th>Business</th>><tr>");
            while(rs.next())
            {
                 String fid = rs.getString("flingtId");  
                 String airline = rs.getString("airline");  
                 String time = rs.getString("time"); 
                 String economy = rs.getString("economy");
                 String business = rs.getString("business");
                 System.out.println("<tr><td>" + fid + "</td><td>" + airline + "</td><td>" + time + "</td><td>" + economy +"</td><td>"+ business +"</td></tr>");   
             }  
             System.out.println("</table>");  
             System.out.println("</html></body>"); 
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
