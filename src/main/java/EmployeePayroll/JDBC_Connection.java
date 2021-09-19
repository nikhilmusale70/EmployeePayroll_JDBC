package EmployeePayroll;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_Connection {
    private String url = "jdbc:mysql://localhost:3306/employeepayroll";
    Connection con;

    public Connection connection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","1234");
            System.out.println("Connection succesful");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return con;
    }
}
