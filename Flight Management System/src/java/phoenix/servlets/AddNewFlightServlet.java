package phoenix.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import phoenix.model.Flight;
import phoenix.model.LevelTwo;
import java.io.IOException;

/*
    Control Servlet to add a new Flight record.
    Reads and handles POST request data.
    Redirects staff member to dashboard if passed.
    Redirects staff member to form if failed.
    
*/
@WebServlet(name="AddNewFlight",urlPatterns = {"/AddNewFlight"})
public class AddNewFlightServlet extends HttpServlet {
    
    /* Instance fields */
    //serialVersionUID to ensure proper deserialization.
    private static final long serialVersionUID = 1L;
       
    /* Constructors */
    //Calls the default constructor of super class.
    public AddNewFlightServlet() {
        super(); 
    }

    /* Instance methods */
    //doPost method to handle POST requests.
    /*
        Instantiates a Flight object and populates it with data from POST request parameters.
        A LevelTwo object is instantiated and calls the insertNewFlightDetails method.
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            Flight flight=new Flight();
            LevelTwo l2Staff = new LevelTwo();

            if(request.getParameter("addFlight") != null) {
                //Populates a Flight object with explicit POST data.
                flight.setDate(request.getParameter("date"));
                flight.setArrivalTime(request.getParameter("arrivalTime"));
                flight.setDepartTime(request.getParameter("departTime"));
                flight.setFlightNumber(request.getParameter("flightNumber"));
                flight.setNumberOfSeats(Integer.valueOf(request.getParameter("numberOfSeats")));
                flight.setTicketPrice(Double.valueOf(request.getParameter("ticketPrice")));
                flight.setDepartLocation(request.getParameter("departLocation"));
                flight.setArrivalLocation(request.getParameter("arrivalLocation"));               
                //Attempts to perform a database insertion.
                int numRows = l2Staff.insertNewFlightDetails(flight);
                if(numRows > 0) {
                    //if fail
                    response.sendRedirect("staff_dashboard.jsp");
                }
                else {
                    //if success
                    response.sendRedirect("add_new_flight.jsp");
                }
            }
    }

}
