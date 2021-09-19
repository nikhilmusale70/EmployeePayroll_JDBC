package EmployeePayrollTest;

import EmployeePayroll.EmployeePayrollException;
import EmployeePayroll.EmployeePayrollQueries;
import EmployeePayroll.JDBC_Connection;
import org.junit.Test;

import java.sql.SQLException;

public class EmployeePayrollTest {
    JDBC_Connection conn = new JDBC_Connection();
    EmployeePayrollQueries epq = new EmployeePayrollQueries();

    @Test   //uc1
    public void true_IfDatabaseConection_IsSucessfull() throws EmployeePayrollException {
        conn.connection();
    }

    @Test  //uc2
    public void returnsQuerry_FromDatabase() throws EmployeePayrollException {
        String query = "SELECT * FROM employee_payroll;";
        try {
            epq.run(query);
        }catch (Exception e){
            throw new EmployeePayrollException("Some Error");
        }
    }
}
