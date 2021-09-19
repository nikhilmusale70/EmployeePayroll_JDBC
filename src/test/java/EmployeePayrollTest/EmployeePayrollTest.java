package EmployeePayrollTest;

import EmployeePayroll.JDBC_Connection;
import org.junit.Test;

public class EmployeePayrollTest {
    JDBC_Connection conn = new JDBC_Connection();

    @Test
    public void true_IfDatabaseConection_IsSucessfull() {
        conn.connection();
    }


}
