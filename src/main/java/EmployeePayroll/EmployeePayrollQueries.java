package EmployeePayroll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeePayrollQueries {

    public void run(String query) throws  EmployeePayrollException {
        EmployeePayrollQueries epq = new EmployeePayrollQueries();

        JDBC_Connection jdbcCon = new JDBC_Connection();
        Connection con = jdbcCon.connection();
        ResultSet rs = null;
        try {
            PreparedStatement statement = con.prepareStatement(query);
            if (statement.execute(query)) {
                rs = statement.executeQuery(query);
                rs.next();                                      //AVG QUERRY
                System.out.println(rs.getString("SUM(salary)"));
              //  printingResultSer(rs);
            }
            else {
                int rowsAffected = statement.executeUpdate(query);
                System.out.println(rowsAffected + " Rows Affected");
            }
        }
        catch (Exception e){
            throw new EmployeePayrollException("Query is not proper");
        }


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
