package EmployeePayroll;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeePayrollQueries {

    public void run(String query) throws  EmployeePayrollException {
        EmployeePayrollQueries epq = new EmployeePayrollQueries();

        ResultSet rs = epq.queries(query);
        printingResultSer(rs);

    }

    public ResultSet queries(String query) throws EmployeePayrollException {
        JDBC_Connection jdbcCon = new JDBC_Connection();
        Connection con = jdbcCon.connection();
        ResultSet rs;
        try {
            Statement statement = con.createStatement();
            rs  = statement.executeQuery(query);
        }
        catch (Exception e){
            throw new EmployeePayrollException("Quey is not proper");
        }

        return rs;

    }

    public void printingResultSer(ResultSet resultSet) throws EmployeePayrollException {
        String head = String.format("%-5s","ID") + String.format("%-10s","Name") + String.format("%-15s","Salary") + String.format("%-10s","Start");
        System.out.println(head + "\n");

        try {
            while (resultSet.next()) {
                System.out.print(String.format("%-5s", resultSet.getInt("id")));
                System.out.print(String.format("%-10s", resultSet.getString("name")));
                System.out.print(String.format("%-15s", resultSet.getDouble("salary")));
                System.out.print(String.format("%-10s", resultSet.getDate("start")));

                System.out.println();
            }
        }
        catch (Exception e){
            throw new EmployeePayrollException("Readin problem");
        }
    }
}
