package mie.example;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

import edu.toronto.dbservice.config.MIE354DBHelper;
import edu.toronto.dbservice.types.Document;
import edu.toronto.dbservice.types.Person;
import edu.toronto.dbservice.types.Timesheet;

import java.sql.Connection;
import java.util.ArrayList;

public class GetTimesheets {

    private Connection conn;
    private int clientId;
    private int year;
    private int month;

    public GetTimesheets(Connection conn, int clientId, int year, int month) {
        this.conn = conn;
        this.clientId = clientId;
        this.year = year;
        this.month = month;
    }

    public ArrayList<Timesheet> fetchTimesheets() {
        return Timesheet.fetchList(conn, clientId, year, month);
    }
}
