package bank.management.system;

import java.sql.*;

public class con {
    Connection Conn;
    Statement statement;
    public con(){
        try{
            String url ="jdbc:mysql://localhost:3306/banksystem";
            String user = "root";
            String password ="MACINTOSH100";
            Conn = DriverManager.getConnection(url,user,password);
            statement=Conn.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
