package phoenix.model;

import java.util.List;
import phoenix.daos.TicketDataAccess;
import phoenix.daos.UserDataAccess;

/*
    Class to represent a single user or a single user record.
    Provides a layer of abstraction at the servlet and data access levels.
*/
public class User {
    /*
        Member fields.
    */
    //Holds user id.
    private int id;
    //Holds user name.
    private String name;
    //Holds user date of birth.
    private String dob;
    //Holds user e-mail.
    private String email;
    //Holds user address.
    private String address;
    //Holds user password.
    private String password;
    //Holds user role.
    private String role;
    //Holds user account status.
    private String accStatus;
	
    /*
        Constructors.
    */
    //Default Constructor
    public User() {

    }
    //Parameterised constructor
    public User(String name, String dob, String email, String address, String password, String role) {
        super();
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.password = password;
        this.role = role;
    }
        
    /*
        Getters.
    */
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDob() {
        return dob;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }
    public String getAccStatus() {
        return accStatus;
    }
    /*
        Setters.
    */
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAccStatus(String acc_status) {
        this.accStatus = acc_status;
    }
    
    /*
        Instance methods
    */
    
    /*
        Method to reserve a ticket.
        Requires a fully initialised ticket object as parameter.
        Calls the insertTicket method of TicketDataAccess object.
        Returns the number of rows modified.
    */
    public int reserveTicket(Ticket ticket) {
        int numRows;
        TicketDataAccess ticketDao=new TicketDataAccess();
        numRows = ticketDao.insertTicket(ticket);
        return numRows;
    }
    
    /*
        Method to retrieve tickets belonging to a particular e-mail.
        Requires a ticket object with e-mail initialised as parameter.
        Calls the getTicketsByEmail method of TicketDataAccess object.
        Returns a List of Ticket objects with same e-mail instance members.
    */
    public List<Ticket> viewTicketsByEmail(Ticket ticket) {
        List<Ticket> ticketList;
        TicketDataAccess ticketDao = new TicketDataAccess();
        ticketList = ticketDao.getTicketsByEmail(ticket);
        return ticketList;
    }
    
    /*
        Method to updates a ticket record.
        Requires a ticket object fully intialised with data to be updated.
        Calls the updateTicketRecord method of TicketDataAccess object.
        Returns number of rows affected.
    */
    public int updateTicket(Ticket ticket) {
            int numRows;
            TicketDataAccess ticketDao = new TicketDataAccess();
            numRows = ticketDao.updateTicketRecord(ticket);
            return numRows;
    }

    /*
        Method to updates a user record.
        Requires a user object fully intialised with data to be updated.
        Calls the updateUserRecord method of UserDataAccess object.
        Returns number of rows affected.
    */
    public int updateProfile(User user) {
        int numRows;
        UserDataAccess userDao =new UserDataAccess();
        numRows = userDao.updateUserRecords(user);
        return numRows;
    }
    
    public void viewFlightDetails() {

    }
}
