package phoenix.model;

/*
    Class to represent a single ticket or a single ticket_booking record.
    Provides a layer of abstraction at the servlet and data access levels.
*/
public class Ticket {
    /*
        Instance fields
    */
    //Holds the ticket id.
    private int id;
    //Holds the number of seats booked.
    private int numberOfSeats;
    //Holds the email address of the User who booked the ticket.
    private String email;
    //Holds the id of the flight record to which the ticket belongs.
    private int flightId;
    //Holds the payment status of the ticket.
    private String paymentStatus;

    /*
        Getters
    */
    
    //Gets the ticket id.
    public int getId() {
        return id;
    }
    //Gets the number of seats booked.
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    //Gets the email of the user who booked the ticket.
    public String getEmail() {
        return email;
    }
    //Gets the id of the flight to which the ticket belongs.
    public int getFlightId() {
        return flightId;
    }
    //Gets the payment status of the ticket.
    public String getPaymentStatus() {
        return paymentStatus;
    }

    /*
        Setters
    */
    
    //Sets the ticket id.
    public void setId(int id) {
            this.id = id;
    }
    //Sets the number of seats booked.
    public void setNumberOfSeats(int numberOfSeats) {
            this.numberOfSeats = numberOfSeats;
    }
    //Gets the email of the user who booked the ticket.
    public void setEmail(String email) {
            this.email = email;
    }
    //Gets the id of the flight to which the ticket belongs.
    public void setFlightId(int flightId) {
            this.flightId = flightId;
    }
    //Gets the payment status of the ticket.
    public void setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
    }	
	
}
