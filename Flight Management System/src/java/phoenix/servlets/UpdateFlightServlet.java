package phoenix.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import phoenix.model.Flight;
import phoenix.model.LevelOne;
import java.io.IOException;

/*
    Control Servlet to update a flight record.
    Reads and handles POST request data.
    Redirects staff member to dashboard if passed.
    Redirects staff member to form if failed.
*/
@WebServlet(name="UpdateFlight",urlPatterns = {"/UpdateFlight"})
public class UpdateFlightServlet extends HttpServlet {
    /* Instance fields */
    //serialVersionUID to ensure proper deserialization.
    private static final long serialVersionUID = 1L;
    
    /* Constructors */
    //Calls the default constructor of super class.
    public UpdateFlightServlet() {
        super();   
    }
    
    /*
        Instance methods
    */
    //doPost method to handle POST requests.
    /*
        Instantiates a Flight Object.
        Instantiates a LevelOne Object.
        Reads data from POST request parameters.
        Poluates the Flight object member fields.
        Redirects staff member to dashboard if passed.
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Flight flight=new Flight();
            LevelOne staffLevelOne = new LevelOne();
            if(request.getParameter("updateFlight")!=null) {
                flight.setDate(request.getParameter("date"));
                flight.setArrivalTime(request.getParameter("arrivalTime"));
                flight.setDepartTime(request.getParameter("departTime"));
                flight.setFlightNumber(request.getParameter("flightNumber"));
                flight.setNumberOfSeats(Integer.valueOf(request.getParameter("numberOfSeats")));
                flight.setTicketPrice(Double.valueOf(request.getParameter("ticketPrice")));
                flight.setDepartLocation(request.getParameter("departLocation"));
                flight.setArrivalLocation(request.getParameter("arrivalLocation"));
                flight.setId(Integer.valueOf(request.getParameter("id")));
                int numRows = staffLevelOne.updateFlightDetails(flight);
                if(numRows > 0) {
                    response.sendRedirect("staff_dashboard.jsp");
                }
            }
    }

}
