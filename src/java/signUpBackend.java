/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Users.*;

public class signUpBackend extends HttpServlet {
    
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();
        
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String contact = req.getParameter("contact");
        String password = req.getParameter("password");
        String adress = req.getParameter("adress");
        
        javaBean1 ob = new javaBean1();
        ob.setEmail(email);
        ob.setName(name);
        ob.setContact(contact);
        ob.setPassword(password);
        ob.setAdress(adress);
        
        boolean x = ob.insertMethod();
        if(x == true){
            
            pw1.println("Success");
//            pw1.println("<!DOCTYPE html>\n" +
//"<html lang=\"en\">\n" +
//"<head>\n" +
//"    <meta charset=\"UTF-8\">\n" +
//"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
//"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
//"    <title>home1</title>\n" +
//"</head>\n" +
//"<style>\n" +
//"    \n" +
//"    body{\n" +
//"        font-family: 'Fredoka One', cursive;\n" +
//"        color: rgb(3, 40, 73);\n" +
//"        margin: -15px;\n" +
//"        padding: 0px;\n" +
//"        background: url('./front_img1.jpg');\n" +
//"    }\n" +
//"    .left{\n" +
//"        display: inline-block;\n" +
//"        /* border: 2px solid red; */\n" +
//"        position: absolute;\n" +
//"        left: 35px;\n" +
//"        top: 16px;\n" +
//"    }\n" +
//"    .left div{\n" +
//"        line-height: 19px;\n" +
//"        font-size: 18px;\n" +
//"        text-align: center;\n" +
//"    }\n" +
//"    .mid{\n" +
//"        display: block;\n" +
//"        width: 95%;\n" +
//"        margin: 30px auto;\n" +
//"        /* border: 2px solid green; */\n" +
//"    }\n" +
//"    .right{\n" +
//"        position: absolute;\n" +
//"        right: 29px;\n" +
//"        top: 26px;\n" +
//"        display: inline-block;\n" +
//"        /* border: 2px solid yellow; */\n" +
//"    }\n" +
//"    .navbar{\n" +
//"        display: inline-block;\n" +
//"    }\n" +
//"    .navbar li{\n" +
//"        display: inline-block;\n" +
//"        font-size: 15px;\n" +
//"    }\n" +
//"    .navbar li a{\n" +
//"        color: rgb(54, 6, 116);\n" +
//"        text-decoration: none;\n" +
//"        padding: 35px 17px;\n" +
//"    }\n" +
//"    .navbar li a:hover , .navbar li a.active{\n" +
//"        text-decoration: underline;\n" +
//"        color: gray;\n" +
//"    }\n" +
//"    .btn{\n" +
//"        font-family: 'Fredoka One', cursive;\n" +
//"        margin: 0px 8px;\n" +
//"        background-color: rgb(16, 31, 245);\n" +
//"        color: white; \n" +
//"        padding: 3px 10px;\n" +
//"        border: 2px solid grey;\n" +
//"        border-radius: 8px;\n" +
//"        font-size: 12px;\n" +
//"        cursor: pointer;\n" +
//"    }\n" +
//"    .btn li{\n" +
//"        display: flex;\n" +
//"        float: right;\n" +
//"    }\n" +
//"    .btn:hover{\n" +
//"        background-color: grey;\n" +
//"    }\n" +
//"    #home h1{\n" +
//"    color: rgb(60, 12, 122);\n" +
//"    text-align: center;\n" +
//"    margin-top: 16%;\n" +
//"    font-size: 2.9rem;\n" +
//"    font-family: 'Fredoka One', cursive;\n" +
//"}\n" +
//"</style>\n" +
//"<body>\n" +
//"    <header class=\"header\">\n" +
//"        \n" +
//"        <!-- mid box for navbar -->\n" +
//"        <div class=\"mid\">\n" +
//"            <ul class=\"navbar\">\n" +
//"                \n" +
//"                <li><a href=\"#\">Travel-X</a></li>\n" +
//"                <li><a href=\"FlightSearch.html\">Flights</a></li>\n" +
//"                <li><a href=\"package.html\">Tour Packages</a></li>\n" +
//"                <li><a href=\"hb1.html\">Hotels</a></li>\n" +
//"            </ul>\n" +
//"        </div>\n" +
//"        <!-- right box for buttons -->\n" +
//"        <div class=\"right\">\n" +
//"\n" +
//"        <div class=\"\">\n" +
//"                <li>Welcome</li>\n" +
//"            </a>\n" +
//"            \n" +
//"        </div>\n" +
//"        </div>\n" +
//"\n" +
//"    </header>\n" +
//"    <section id=\"home\">\n" +
//"        <h1 class=\"h-primary\">Welcome to Online Tourism</h1>\n" +
//"    </section>\n" +
//"</body>\n" +
//"</html>");
        }else{
            pw1.println("Insert Unsucessful");
        }
    }
}
