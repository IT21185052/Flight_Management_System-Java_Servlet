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
    Control Servlet to update a ticket_booking record.
    Reads and handles POST request data.
    Redirects staff member to dashboard if passed.
*/
@WebServlet(name="UpdateTicket",urlPatterns = {"/UpdateTicket"})
public class UpdateTicketServlet extends HttpServlet {
    /* Instance fields */
    //serialVersionUID to ensure proper deserialization.
    private static final long serialVersionUID = 1L;    
    /* Constructors */
    //Calls the default constructor of super class.
    public UpdateTicketServlet() {
        super();
    }
    
    /*
        Instance methods
    */
    //doPost method to handle POST requests.
    /*
        Instantiates a Ticket Object.
        Instantiates a User Object.
        Reads data from POST request parameters.
        Populates the Ticket object member fields.
        Redirects staff member to dashboard if passed.
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("updateTicket")!=null) {
            Ticket ticket=new Ticket();
            User user=new User();
            ticket.setEmail(request.getParameter("email"));
            ticket.setNumberOfSeats(Integer.valueOf(request.getParameter("numberOfSeats")));
            ticket.setFlightId(Integer.valueOf(request.getParameter("id")));
            ticket.setId(Integer.valueOf(request.getParameter("tid")));
            int result=user.updateTicket(ticket);
            if(result>0) {
                response.sendRedirect("user_dashboard.jsp");
            }
        }
    }

}
