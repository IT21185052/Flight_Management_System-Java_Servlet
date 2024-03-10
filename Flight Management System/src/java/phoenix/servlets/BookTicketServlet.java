package phoenix.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import phoenix.model.Ticket;
import phoenix.model.User;
import java.io.IOException;

/*
    Control Servlet to book a flight ticket.
    Reads and handles POST request data.
    Redirects user to dashboard if passed.
    Redirects user to form if failed.   
*/
@WebServlet(name="BookTicket",urlPatterns = {"/BookTicket"})
public class BookTicketServlet extends HttpServlet {
    /* Instance fields */
    //serialVersionUID to ensure proper deserialization.
    private static final long serialVersionUID = 1L;
       
    /* Constructors */
    //Calls the default constructor of super class.
    public BookTicketServlet() {
        super();
        
    }
        
    /*
        Instance methods
    */
    //doPost method to handle POST requests.
    /*
        Instantiates a Ticket object and User object.
        Populates Ticket object fields with data from POST request parameters.
        Calls the reserveSeats method of the User object on the Ticket object.
        Redirects administrator to dashboard if passed.
    */	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("generateTicket")!=null) {
            Ticket ticket = new Ticket();
            User user = new User();
            //Reads POST data and initialises Ticket fields
            ticket.setEmail(request.getParameter("email"));
            ticket.setNumberOfSeats(Integer.valueOf(request.getParameter("numberOfSeats")));
            ticket.setFlightId(Integer.valueOf(request.getParameter("id")));
            //Reservation
            int numRows = user.reserveTicket(ticket);
            //Checks success of operation
            if(numRows > 0) {
                response.sendRedirect("user_dashboard.jsp");
            }
        }
    }

}
