package Flights;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class flightBookingBean {
       private String from ;
       private String to ;
       private String adhaar ;
       private String contact;
       private String adult ;
       private String children ;
       private String ClassSeats ;
       private String departing;
       private String returning;
       private String seats;
       private String name;
       private String fid;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAdhaar() {
        return adhaar;
    }

    public void setAdhaar(String adhaar) {
        this.adhaar = adhaar;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getClassSeats() {
        return ClassSeats;
    }

    public void setClassSeats(String ClassSeats) {
        this.ClassSeats = ClassSeats;
    }

    public String getDeparting() {
        return departing;
    }

    public void setDeparting(String departing) {
        this.departing = departing;
    }

    public String getReturning() {
        return returning;
    }

    public void setReturning(String returning) {
        this.returning = returning;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }
       
      
    public boolean insertMethod() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:"
                    + "oracle:thin:@localhost:1521:XE", "system", "system");
            Statement stmt = con.createStatement();
            String q1 = "insert into flightBookings values('" + from + "','" + to + "','" + adhaar + "','" + contact + "','" + name + "','"+ fid+"','"+departing+"','"+returning+"','"+adult+"','"+children+"','"+seats+")";
            System.out.println(q1);
            int x = stmt.executeUpdate(q1);
            if (x > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
   
}
