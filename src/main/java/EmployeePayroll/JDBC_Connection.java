package EmployeePayroll;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_Connection {
    private String url = "jdbc:mysql://localhost:3306/employeepayroll";
    Connection con;

    public Connection connection() throws EmployeePayrollException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","1234");
        }
        catch (Exception e){
            throw new EmployeePayrollException("Driver not found");
        }

        return con;
    }
}
