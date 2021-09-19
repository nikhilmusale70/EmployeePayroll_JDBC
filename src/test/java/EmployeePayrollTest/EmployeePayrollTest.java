package EmployeePayrollTest;

import EmployeePayroll.EmployeePayrollQueries;
import EmployeePayroll.JDBC_Connection;
import org.junit.Test;

import java.sql.SQLException;

public class EmployeePayrollTest {
    JDBC_Connection conn = new JDBC_Connection();
    EmployeePayrollQueries epq = new EmployeePayrollQueries();

    @Test   //uc1
    public void true_IfDatabaseConection_IsSucessfull() {
        conn.connection();
    }

    @Test  //uc2
    public void returnsQuerry_FromDatabase() throws SQLException {
        String query = "SELECT * FROM employee_payroll;";
        epq.run(query);
    }
}
