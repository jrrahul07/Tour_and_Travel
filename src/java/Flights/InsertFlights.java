/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flights;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author sssuv
 */
public class InsertFlights {
        private String fid ;
        private String airline ;
        private String arrival ;
        private String departure ;
        private String eco  ;
        private String business;
        private String days ;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

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

    public String getEco() {
        return eco;
    }

    public void setEco(String eco) {
        this.eco = eco;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
    
    public boolean insertAFlight()
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con =DriverManager.getConnection
        ("jdbc:oracle:thin:@localhost:1521:XE","system","system");
            Statement stmt = con.createStatement();
            String q1 = "insert into flights values('"+fid+"','"+airline+"',"
                    + "'"+arrival+"','"+departure+"','"+eco+"','"+business+"','"+days+"')";
            // q1 = insert into t1 values('5','suvam','112244') <--- the actual sql query
            int x = stmt.executeUpdate(q1);
            if(x>0){
                return true;
            }else{
                return false;
            }

        }catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
}
