package phoenix.model;

import phoenix.daos.FlightDataAccess;

/*
    Class to represent a single staff member or a single user record with role as 'Level 1' or 'Level 2'.
    Inherits from User class.
    Provides a layer of abstraction at the servlet and data access levels.
*/
public class StaffMember extends User {
        /*
            Instance fields.
        */
        //Holds account status.
	private String accStatus;
	
        /*
            Constructors
        */
        //Default constructor
	public StaffMember() {
		super();
		
	}
        //parameterised constructor
	public StaffMember(String name, String dob, String email, String address, String password, String role) {
		super(name, dob, email, address, password, role);
		this.accStatus="Pending";
	}
        
        /*
            Getters
        */
        @Override
	public String getAccStatus() {
		return accStatus;
	}

        /*
            Setters
        */
        @Override
	public void setAccStatus(String acc_status) {
		this.accStatus = acc_status;
	}
	
        /*
            Method to insert a flight record.
            Requires a fully initialised Flight object with data to be inserted as parameter.
            Calls the insertFlightRecord method of FlightDataAccess object.
            Returns the number of rows modified.
        */
	public int insertNewFlightDetails(Flight flight) {
                int numRows;
		FlightDataAccess flightDao = new FlightDataAccess();
		numRows = flightDao.insertFlightRecord(flight);
		return numRows;
	}
}
