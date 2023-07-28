import Flights.InsertFlights;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FlightComInsert extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();
        
        String fid = req.getParameter("fid");
        String airline = req.getParameter("airlines");
        String arrival = req.getParameter("arrival");
        String departure = req.getParameter("departure");
        String eco = req.getParameter("economy");
        String business = req.getParameter("business");
        String days = req.getParameter("days");
        
        InsertFlights ob = new InsertFlights();
        ob.setFid(fid);
        ob.setAirline(airline);
        ob.setArrival(arrival);
        ob.setDeparture(departure);
        ob.setEco(eco);
        ob.setBusiness(business);
        ob.setDays(days);
        
        boolean x = ob.insertAFlight();
        if(x==true)
        {
            pw1.println("Insert Successfull");
        }
        else
        {
            pw1.println("Insert Unsucessful");
        }
    }
}