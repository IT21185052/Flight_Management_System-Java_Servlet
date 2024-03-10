package phoenix.model;

import phoenix.daos.FlightDataAccess;

/*
    Class to represent a single level 1 staff member or a single user record with role as 'Level 1'.
    Inherits from StaffMember class.
    Provides a layer of abstraction at the servlet and data access levels.
*/
public class LevelOne extends StaffMember {

    /*
        Constructors
    */
    //Default Constructor
    public LevelOne() {
        super();	
    }
    //Parameterised Constructor
    public LevelOne(String name, String dob, String email, String address, String password, String role) {
            super(name, dob, email, address, password, role);

    }

    /*
        Instance methods
    */
    
    /*
        Method to update a flight record.
        Requires a fully initialised Flight object with data to be updated as parameter.
        Calls the updateFlightRecord method of FlightDataAccess object.
        Returns the number of rows modified.
    */
    public int updateFlightDetails(Flight flight) {
        int numRows;
        FlightDataAccess flightDao = new FlightDataAccess();
        numRows = flightDao.updateFlightRecord(flight);
        return numRows;
    }
    /*
        Method to delete a flight record.
        Requires a Flight object initialised with id member to be deleted as parameter.
        Calls the deleteFlightRecord method of FlightDataAccess object.
        Returns the number of rows modified.
    */
    public int deleteFlightDetails(Flight flight) {
        int numRows;
        FlightDataAccess flightDao = new FlightDataAccess();
        numRows = flightDao.deleteFlightRecord(flight);
        return numRows;
    }
    public void checkTicketDetails() {

    }
    public void updateTicketDetails() {

    }
    public void deleteTicketDetails() {

    }
    public void internalChat() {

    }
    public void addFlightDetails() {

    }
	
}
