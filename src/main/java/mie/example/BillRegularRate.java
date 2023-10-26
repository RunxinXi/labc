package mie.example;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import edu.toronto.dbservice.types.Timesheet;
import edu.toronto.dbservice.types.Lawyer;
import edu.toronto.dbservice.types.Invoice;

//public class BillRegularRate implements JavaDelegate {
//
//	@Override
//	public void execute(DelegateExecution execution) {
//	    Double newSalary = (Double) execution.getVariable("newSalary");
//	    Integer dependentNumber = (Integer) execution.getVariable("dependentNumber");
//	    String personName = (String) execution.getVariable("personName");
//
//	    Double coPayAmount = newSalary * 0.0003; // 0.03% of the new salary
//
//	    // TODO: Insert the tuple (personName, dependentNumber, coPayAmount) into the CoPayment database table
//
//	    System.out.println("CoPayment calculated for " + personName + " with dependent number " + dependentNumber + " is: " + coPayAmount);
//	}
//
//
//}
import java.sql.Connection;

public class BillRegularRate {

    private Connection conn;
    private Timesheet timesheet;
    private Lawyer lawyer;

    public BillRegularRate(Connection conn, Timesheet timesheet, Lawyer lawyer) {
        this.conn = conn;
        this.timesheet = timesheet;
        this.lawyer = lawyer;
    }

    public void calculateRegularBill() {
        float total = timesheet.hoursBilled * lawyer.hourlyRate;
        Invoice.addToTotal(conn, timesheet.clientId, timesheet.year, timesheet.month, total);
    }
}
