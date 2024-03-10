package phoenix.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import phoenix.model.Ticket;

/*
    Class to handle all database CRUD operations related to Ticket objects.
    Helps provide a layer of abstraction at the servlet level.
*/
public class TicketDataAccess {
    
    //Holds connection to a MySQL database.
    private Connection databaseConnection;

    //Constructor to initialise Connection object.
    public TicketDataAccess() {
        databaseConnection = new DatabaseAccess().getMySQLConnection();
    }

    /*
        Method to insert a record to the ticket_booking table.
        Requires a fuly initialised Ticket object as a parameter.
        Returns the number of records affected.
    */
    public int insertTicket(Ticket ticket) {
        //Number of affected records
        int  numRecords = 0;
        try {
                //Query to insert a record into the ticket_booking table.
                String query="insert into ticket_booking_table (number_of_seats, email, flight_id) values(?, ?, ?);";
                //PreparedStatement Object created from query
                PreparedStatement pStatement = databaseConnection.prepareStatement(query);
                //Sets the prepared statement suing instance fields of the Ticket object.
                pStatement.setInt(1, ticket.getNumberOfSeats());
                pStatement.setString(2, ticket.getEmail());
                pStatement.setInt(3, ticket.getFlightId());
                //Executes the insert statement and returns the number of affected records.
                numRecords = pStatement.executeUpdate();
        }
        catch(SQLException e) {
                //Handles exceptions
                System.out.println(e.getMessage());
        }
        //Returns the number of affected records.
        return numRecords;
    }

    /*
        Method to retrieve all ticket_booking records with a given e-mail address.
        Requires a Ticket object with the email member field initialised.
        Returns a list of Ticket objects with the same email member feild representing the records.
    */
    public List<Ticket> getTicketsByEmail(Ticket inputTicket) {
        //List of Tickets objects to hold the ticket_booking records
        List<Ticket> ticketList = new ArrayList();	
        try {
            //Query to retrieve all ticket records with a given email.
            String query="select * from ticket_booking_table where email = ?;";
            //Creates a PreparedStatement object from the query.
            PreparedStatement pStatement = databaseConnection.prepareStatement(query);
            //Sets the email address from the inputTicket object.
            pStatement.setString(1, inputTicket.getEmail());
            //Executes the query and retrives the records as a ResultSet object.
            ResultSet result = pStatement.executeQuery();
            //Iterated through the ResultSet object.
            while(result.next()) {
                //Creates a new Ticket object for each ticket_booking record.
                Ticket ticket=new Ticket();
                //Gets values from each column of the record and sets the Ticket object fields.
                ticket.setEmail(result.getString("email"));
                ticket.setFlightId(result.getInt("flight_id"));
                ticket.setId(result.getInt("id"));
                ticket.setNumberOfSeats(result.getInt("number_of_seats"));
                ticket.setPaymentStatus(result.getString("payment_status"));
                //Adds the object to the ticketList collection.
                ticketList.add(ticket);
            }
        }
        catch(SQLException e) {
            //Handles Exceptions
            System.out.println(e.getMessage());
        }
        //Returns the collection of Ticket objects.
        return ticketList;
    }

    /*
        Method to retrieve a single flight record.
        Requires a Ticket object as a parameter with the id member initialised.
        Returns the Ticket object fully initialised with data from the ticket_booking record.
    */
    public Ticket getTicketRecord(Ticket ticket) {
        try {
            //Query to retrieve a single ticket_booking record.
            String query = "select * from ticket_booking_table where id = ?;";
            //PreparedStatement object made from query.
            PreparedStatement pStatement = databaseConnection.prepareStatement(query);
            //Sets the PreparedStatement with the id member of the Ticket object.
            pStatement.setInt(1, ticket.getId());
            //Retrieves data from a single ticket_booking record as a ResultSet.
            ResultSet result = pStatement.executeQuery();
            //Iterates through the ResultSet object.
            while(result.next()) {
                //Initialises the member feilds of the Ticket object using columns from ticket_booking record.
                ticket.setEmail(result.getString("email"));
                ticket.setFlightId(result.getInt("flight_id"));
                ticket.setId(result.getInt("id"));
                ticket.setNumberOfSeats(result.getInt("number_of_seats"));
                ticket.setPaymentStatus(result.getString("payment_status"));	
            }
        }
        catch(SQLException e) {
            //Handles exceptions
            System.out.println(e.getMessage());
        }
        //Returns a fully initialised Ticket object.
        return ticket;
    }

    /*
        Updates a single ticket_booking record.
        Requires a Ticket object with an initialised id member as a parameter.
        Returns the number of affected rows.
    */
    public int updateTicketRecord(Ticket ticket) {
        //Number of affected rows.
        int numRows = 0;
        try {
            //Query to update a ticket_booking record.
            String query="update ticket_booking_table set number_of_seats = ?, email = ?, flight_id = ? where id = ?;";
            //PreparedStatement object created from query.
            PreparedStatement pStatement = databaseConnection.prepareStatement(query);
            //Sets the PreparedStatement with member fields of the Ticket object.
            pStatement.setInt(1, ticket.getNumberOfSeats());
            pStatement.setString(2, ticket.getEmail());
            pStatement.setInt(3, ticket.getFlightId());
            pStatement.setInt(4, ticket.getId());
            //Executed the update statement and returns the number of rows affected.
            numRows = pStatement.executeUpdate();
        }
        catch(SQLException e) {
            //Exception handling.
            System.out.println(e.getMessage());
        }
        //Returns the number of rows affected.
        return numRows;
    }

    /*
        Method to delete a ticket_booking record.
        Requires a Ticket object with an initialised id member.
        Returns the number of rows affected.
    */
    public int deleteTicketRecord(Ticket ticket) {
        //Number of affected rows.
        int numRows = 0;
        try {
            //Query to delete aticket_booking record
            String query = "delete from ticket_booking_table where id = ?;";
            //PreparedStatement object created from query.
            PreparedStatement pStatement = databaseConnection.prepareStatement(query);
            //Sets the query with the id member of the Ticket object.
            pStatement.setInt(1, ticket.getId());
            //Executes the query returning the number of rows affected.
            numRows = pStatement.executeUpdate();
        }
        catch(SQLException e) {
            //Handles exceptions
            System.out.println(e.getMessage());
        }
        //Returns the number of affected rows.
        return numRows;
    }
}
