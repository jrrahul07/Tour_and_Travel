package Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class loginBean {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPresent() {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:"
                    + "oracle:thin:@localhost:1521:XE", "system", "system");
            Statement stmt = con.createStatement();
            String q1 = "select * from users where email='"+email+"' and password='"+password+"'";
            int x = stmt.executeUpdate(q1);
            if(x>0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
}
