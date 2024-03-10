package phoenix.model;

/*
    Class to represent a single flight or a flight record.
    Provides a layer of abstraction at the servlet and data access levels.
*/
public class Flight {
    /*
        Instance fields.
    */
    //Holds the id of a flight record.
    private int id;
    //Holds the flight number.
    private String flightNumber;
    //Holds the time of departure.
    private String departTime;
    //Holds the time of arrival.
    private String arrivalTime;
    //Holds the total number of seats.
    private int numberOfSeats;
    //Holds the ticket price.
    private double ticketPrice;
    //Hold the date of flight.
    private String date;
    //Holds the location of departure.
    private String departLocation;
    //Holds the location of arrival. 
    private String arrivalLocation;

    /*
        Getters
    */    
    //Gets the flight number.
    public String getFlightNumber() {
        return flightNumber;
    }
    //Gets the time of departure.
    public String getDepartTime() {
        return departTime;
    }    
    //Gets the time of arrival.
    public String getArrivalTime() {
        return arrivalTime;
    }    
    //Gets the number of seats.
    public int getNumberOfSeats() {
        return numberOfSeats;
    }    
    //Gets the ticket price.
    public double getTicketPrice() {
        return ticketPrice;
    }   
    //Gets the date of flight.
    public String getDate() {
        return date;
    }    
    //Gets the location of departure.
    public String getDepartLocation() {
        return departLocation;
    }    
    //Gets the location of arrival.
    public String getArrivalLocation() {
            return arrivalLocation;
    }    
    //Gets the id of the flight record.
    public int getId() {
        return id;
    }
    
    /*
        Setters
    */
    //Sets the flight number.
    public void setFlightNumber(String flightNumber) {
            this.flightNumber = flightNumber;
    }
    //Sets the time of departure.
    public void setDepartTime(String departTime) {
            this.departTime = departTime;
    }
    //Sets the time of arrival.
    public void setArrivalTime(String arrivalTime) {
            this.arrivalTime = arrivalTime;
    }
    //Sets the number of seats.
    public void setNumberOfSeats(int numberOfSeats) {
            this.numberOfSeats = numberOfSeats;
    }
    //Sets the ticket price.
    public void setTicketPrice(double ticketPrice) {
            this.ticketPrice = ticketPrice;
    }
    //Sets the date of flight.
    public void setDate(String date) {
            this.date = date;
    }
    //Sets the location of departure.
    public void setDepartLocation(String departLocation) {
            this.departLocation = departLocation;
    }
    //Sets the location of arrival.
    public void setArrivalLocation(String arrivalLocation) {
            this.arrivalLocation = arrivalLocation;
    }
    //Sets the id of the flight record.
    public void setId(int id) {
            this.id = id;
    }	
}
