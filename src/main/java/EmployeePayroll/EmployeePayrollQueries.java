package EmployeePayroll;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeePayrollQueries {

    public void run(String query) throws SQLException {
        EmployeePayrollQueries epq = new EmployeePayrollQueries();

        ResultSet rs = epq.queries(query);
        printingResultSer(rs);

    }

    public ResultSet queries(String query) throws SQLException {
        JDBC_Connection jdbcCon = new JDBC_Connection();
        Connection con = jdbcCon.connection();
        Statement statement = con.createStatement();

        return statement.executeQuery(query);

    }

    public void printingResultSer(ResultSet resultSet) throws SQLException {
        String head = String.format("%-5s","ID") + String.format("%-10s","Name") + String.format("%-15s","Salary") + String.format("%-10s","Start");
        System.out.println(head + "\n");

        while (resultSet.next()){
            System.out.print(String.format("%-5s",resultSet.getInt("id" )) );
            System.out.print(String.format("%-10s",resultSet.getString("name" )) );
            System.out.print(String.format("%-15s",resultSet.getDouble("salary" )) );
            System.out.print(String.format("%-10s",resultSet.getDate("start" )) );

            System.out.println();
        }
    }
}
