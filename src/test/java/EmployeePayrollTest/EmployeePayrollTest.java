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

    @Test  //uc3 same for uc4
    public void updatesARow_InDatabase() throws EmployeePayrollException {
        String query = "UPDATE employee_payroll SET salary = 3000000.00 WHERE name = 'Terisa';";
        try {
            epq.run(query);
        }catch (Exception e){
            throw new EmployeePayrollException("Some Error");
        }
    }

    @Test  //uc5
    public void employeesJoined_CertainDate() throws EmployeePayrollException {
        String query = "SELECT * FROM employee_payroll WHERE start BETWEEN '2019-01-01' AND DATE(NOW())";
        try {
            epq.run(query);
        }catch (Exception e){
            throw new EmployeePayrollException("Some Error");
        }
    }
}
