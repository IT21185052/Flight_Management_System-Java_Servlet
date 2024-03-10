package phoenix.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import phoenix.model.Flight;

/*
    Class to handle all database CRUD operations related to Flight objects.
    Helps provide a layer of abstraction at the servlet level.
*/
public class FlightDataAccess {
        
    //Holds connection to a MySQL database.
    private final Connection databaseConnection;

    //Constructor to initialise Connection object
    public FlightDataAccess() {
        this.databaseConnection = new DatabaseAccess().getMySQLConnection();
    }
        
    /*
        Method to return the entire flight table from the database.
        The method returns a List of Flight objects.
        Each flight object represents a single record of the flight table.
    */
    public List<Flight> getAllFlightRecords(){
        //List of Flight objects
        List<Flight> flightList=new ArrayList();
        try {
            //Database query to retrieve all flight records.
            String query="select * from flight_table;";
            //Prepared statement object creating using query.
            PreparedStatement pStatement = databaseConnection.prepareStatement(query);
            //ResultSet object to hold results.
            ResultSet results = pStatement.executeQuery();

            //Iterates through each result.
            while(results.next()) {
                //Creates a new flight object.  
                Flight flightRecord = new Flight();
                //Initialises flight object members.
                flightRecord.setId(results.getInt("flight_id"));
                flightRecord.setFlightNumber(results.getString("flight_number"));
                flightRecord.setDate(results.getString("date"));
                flightRecord.setArrivalTime(results.getString("arrival_time"));
                flightRecord.setDepartTime(results.getString("depart_time"));
                flightRecord.setNumberOfSeats(results.getInt("number_of_seats"));
                flightRecord.setTicketPrice(results.getDouble("ticket_price"));
                flightRecord.setDepartLocation(results.getString("depart_location"));
                flightRecord.setArrivalLocation(results.getString("arrival_location"));
                //Adds flight object to flightList
                flightList.add(flightRecord);
            }
        }
        catch(SQLException e) {
            //Handles exceptions
            System.out.println(e.getMessage());
        }
        return flightList;
    }
	
    /*
        Method to insert a flight record to the database.
        Accepts a Flight object as a parameter which holds data to be inserted.
        Returns the number of rows affected.
    */
    public int insertFlightRecord(Flight flight) {
        //Number of rows affected
        int numRows = 0;
        try {
            //Database query to insert a flight record to the database.
            String query = "insert into flight_table (flight_number, depart_time, arrival_time, number_of_seats, ticket_price, date, depart_location, arrival_location) values (?, ?, ?, ?, ?, ?, ?, ?);";
            //Prepared statement object created using query.
            PreparedStatement pStatement = databaseConnection.prepareStatement(query);

            //Sets values from flight object members into the PreparedStatement
            pStatement.setString(1, flight.getFlightNumber());
            pStatement.setString(2, flight.getDepartTime());
            pStatement.setString(3, flight.getArrivalTime());
            pStatement.setInt(4, flight.getNumberOfSeats());
            pStatement.setDouble(5, flight.getTicketPrice());
            pStatement.setString(6, flight.getDate());
            pStatement.setString(7, flight.getDepartLocation());
            pStatement.setString(8, flight.getArrivalLocation());

            //Executed query. It also returns the number of record affected
            numRows = pStatement.executeUpdate();
        }
        catch(SQLException e) {
            //Handles exceptions  
            System.out.println(e.getMessage());
        }
        return numRows;
    }

    /*
        Method to retrieve a single flight record.
        Requires a flight object with a Flight Object parameter, with an initialised id member.
        Returns the updated flight object.
    */
    public Flight getFlightRecord(Flight flight) {
        try {
            //Query to retrieve a single flight record.
            String query = "select * from flight_table where flight_id = ?;";
            //PreparedStatement object created from the query string.
            PreparedStatement pStatement = databaseConnection.prepareStatement(query);
            //Sets the flightId using the initialises id member of Flight object.
            pStatement.setInt(1, flight.getId());
            //Executes the statement and rtrieves a ResultSet object.
            ResultSet result = pStatement.executeQuery();
            //Iterates through the resultSet. As only one record is returned, there will only be on iteration.
            if(result.next()) {
                //Initialises the members of Flight object utilising retrieved record
                flight.setId(result.getInt("flight_id"));
                flight.setFlightNumber(result.getString("flight_number"));
                flight.setDate(result.getString("date"));
                flight.setArrivalTime(result.getString("arrival_time"));
                flight.setDepartTime(result.getString("depart_time"));
                flight.setNumberOfSeats(result.getInt("number_of_seats"));
                flight.setTicketPrice(result.getDouble("ticket_price"));
                flight.setDepartLocation(result.getString("depart_location"));
                flight.setArrivalLocation(result.getString("arrival_location"));
            }
        }
        catch(SQLException ex) {
            //Handles exception
            System.out.println(ex.getMessage());
        }
        return flight;
    }

    /*
        Method to update a single flight record.
        Accpets a Flight object parameter that is completely initialised.
        Returns the number of records affected.
    */
    public int updateFlightRecord(Flight flight) {
        //Number of rows.
        int numRows = 0;
        try {
            //Query to update a single flight record using the flightId.
            String query = "update flight_table set flight_number = ?, depart_time = ?, arrival_time = ?, number_of_seats = ?, ticket_price =?, date = ?, depart_location = ?, arrival_location = ? where flight_id = ?;";
            //PreparedStatement object created from the query.
            PreparedStatement pStatement = databaseConnection.prepareStatement(query);
            //Sets the PrepareStatement with data from member feilds of the Flight object.
            pStatement.setString(1, flight.getFlightNumber());
            pStatement.setString(2, flight.getDepartTime());
            pStatement.setString(3, flight.getArrivalTime());
            pStatement.setInt(4, flight.getNumberOfSeats());
            pStatement.setDouble(5, flight.getTicketPrice());
            pStatement.setString(6, flight.getDate());
            pStatement.setString(7, flight.getDepartLocation());
            pStatement.setString(8, flight.getArrivalLocation());
            pStatement.setInt(9, flight.getId());
            //Excecutes the update query and returns the number of affected rows.
            numRows = pStatement.executeUpdate();
        }
        catch(SQLException ex) {
            //Handles exception
            System.out.println(ex.getMessage());
        }
        //returns number of affected rows
        return numRows;
    }

    /*
        Method to delete a single flight record.
        Accepts a Flight object with an initialised id member as a parameter.
        Returns the number of records affected.
    */
    public int deleteFlightRecord(Flight flight) {
        //Number of affected records.
        int numRows = 0;
        try {
            //Query to delete a record from the flight table.
            String query="delete from flight_table where flight_id = ?;";
            //PreparedStatement object created from the query.
            PreparedStatement pStatement = databaseConnection.prepareStatement(query);
            //Sets the filghtId from the id member of the Flight object.
            pStatement.setInt(1, flight.getId());
            //Excecutes the delete query, returns the number of affected records.
            numRows = pStatement.executeUpdate();
        }
        catch(SQLException ex) {
            //Handles exceptions.
            System.out.println(ex.getMessage());
        }
        //Returns number of affected rows.
        return numRows;
    }
}
